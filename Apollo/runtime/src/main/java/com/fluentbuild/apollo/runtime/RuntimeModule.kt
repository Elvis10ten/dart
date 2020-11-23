package com.fluentbuild.apollo.runtime

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.fluentbuild.apollo.analytics.AnalyticsModule
import com.fluentbuild.apollo.androidtools.AndroidToolsModule
import com.fluentbuild.apollo.auth.AuthModule
import com.fluentbuild.apollo.auth.WalletService
import com.fluentbuild.apollo.container.ContainerModule
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.createThreadPoolExecutor
import com.fluentbuild.apollo.persistence.PersistenceModule
import com.fluentbuild.apollo.persistence.kv.SharedPrefKeyValueStore
import com.fluentbuild.apollo.runner.server.ResultsHolder
import com.fluentbuild.apollo.runner.server.RunnerServerModule
import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.runtime.helpers.ApkHelper
import com.fluentbuild.apollo.runtime.helpers.PayloadInstaller
import com.fluentbuild.apollo.runtime.helpers.PayloadUnInstaller
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.runtime.models.WorkSchedule
import com.fluentbuild.apollo.runtime.stages.*
import com.fluentbuild.apollo.runtime.startup.Igniter
import com.fluentbuild.apollo.runtime.store.HistoryStore
import com.fluentbuild.apollo.runtime.store.ScheduleStore
import com.fluentbuild.apollo.work.WorkModule
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.WorkServiceGrpc
import com.fluentbuild.apollo.work.WorkSummaryProto
import com.fluentbuild.apollo.work.tests.RunReportProto.RunReport
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

private const val COLLECTION_WORK_HISTORY = "wh"
private const val COLLECTION_WORK_SCHEDULE = "ws"
private const val SHARED_PREF_WORK_MODULE = "work_module"

class RuntimeModule(
    val appContext: Context,
    private val isDebug: Boolean,
    private val remoteStorageDir: File,
    private val privateFileProviderAuthority: String,
    private val logWrapper: LogWrapper
) {

    // region Modules
    private val persistenceModule by lazy { PersistenceModule(appContext, baseGson) }

    val analyticsModule by lazy { AnalyticsModule(appContext) }

    val authModule by lazy {
        AuthModule(
            mainThreadHandler,
            executorService,
            persistenceModule.documentDb,
            analyticsModule.eventPublisher
        )
    }

    val containerModule by lazy { ContainerModule(appContext) }

    val runnerServerModule by lazy {
        RunnerServerModule(
            appContext,
            workModule,
            executorService,
            mainThreadHandler,
            logWrapper
        )
    }

    val androidToolsModule by lazy {
        AndroidToolsModule(
            appContext,
            executorService,
            mainThreadHandler
        )
    }
    // endregion

    private val baseGson by lazy { Gson() }

    private val configProvider by lazy { ConfigProvider() }

    // region Threads
    val mainThreadHandler by lazy { Handler(Looper.getMainLooper()) }

    private val executorService by lazy { createThreadPoolExecutor() }
    // endregion

    // region Runtime
    private val stageProvider by lazy { StageProvider(this) }

    val runtimeManager by lazy {
        RuntimeManager(
            stageProvider,
            runtimeSwitch,
            runnerServerModule.workerRetainer
        )
    }

    val runtimeSwitch by lazy { Igniter() }

    val historyStore by lazy {
        HistoryStore(
            executorService,
            mainThreadHandler,
            persistenceModule.documentDb.collection(
                COLLECTION_WORK_HISTORY,
                object : TypeToken<List<WorkHistory>>() {}.type
            )
        )
    }

    val walletService by lazy {
        WalletService(
            executorService,
            mainThreadHandler
        )
    }

    val workScheduleStore by lazy {
        ScheduleStore(
            executorService,
            mainThreadHandler,
            persistenceModule.documentDb.collection(COLLECTION_WORK_SCHEDULE, WorkSchedule::class.java)
        )
    }
    // endregion

    // region Preconditions-Watchers
    private val runtimePrecondition by lazy {
        RuntimePrecondition(
            appContext,
            containerModule.containerProvisioner,
            runnerServerModule.screenViewer,
            androidToolsModule.dndPermission,
            androidToolsModule.installPermission
        )
    }
    // endregion

    private val networkChannel by lazy {
        NetworkChannel(
            appContext,
            isDebug,
            configProvider,
            executorService
        )
    }

    private val workService by lazy { WorkServiceGrpc.newStub(networkChannel.get()) }

    private val workModule by lazy {
        WorkModule(
            appContext,
            executorService,
            mainThreadHandler,
            remoteStorageDir,
            workService,
            SharedPrefKeyValueStore(appContext, SHARED_PREF_WORK_MODULE)
        )
    }

    // region Stages
    fun getIdleStage(callback: Stage.Callback): IdleStage {
        return IdleStage(appContext, runtimeSwitch, callback)
    }

    fun getInspectingStage(callback: Stage.Callback): InspectionStage {
        return InspectionStage(appContext, runtimePrecondition, callback)
    }

    fun getFindingWorkStage(callback: Stage.Callback): FindStage {
        return FindStage(
            appContext,
            workModule.getWorkFinder(configProvider.getFindWorkTimeoutSeconds()),
            callback
        )
    }

    fun getDownloadPayloadStage(work: WorkProto.Work, callback: Stage.Callback): DownloadStage {
        return DownloadStage(
            appContext,
            work,
            workModule.getPayloadDownloader(work),
            callback
        )
    }

    fun getUnbundlingPayloadStage(work: WorkProto.Work, callback: Stage.Callback): UnbundleStage {
        return UnbundleStage(
            appContext,
            work,
            workModule.getPayloadUnbundler(work),
            callback
        )
    }

    private fun getApkHelper() =
        ApkHelper(appContext, privateFileProviderAuthority)

    private fun getPayloadInstaller(work: WorkProto.Work): PayloadInstaller {
        return PayloadInstaller(
            appContext,
            work,
            workModule.getWorkFiles(work),
            mainThreadHandler,
            getApkHelper(),
            androidToolsModule.getPackageInstaller(),
            androidToolsModule.systemWindows
        )
    }

    private fun getPayloadUnInstaller(work: WorkProto.Work): PayloadUnInstaller {
        return PayloadUnInstaller(
            appContext,
            work,
            mainThreadHandler,
            androidToolsModule.getPackageRemover(),
            androidToolsModule.systemWindows
        )
    }

    fun getInstallingWorkStage(work: WorkProto.Work, callback: Stage.Callback): InstallStage {
        return InstallStage(
            appContext,
            work,
            getPayloadInstaller(work),
            getPayloadUnInstaller(work),
            runnerServerModule.getUiAutomationCreator(),
            callback
        )
    }

    fun getPreparingRunStage(work: WorkProto.Work, callback: Stage.Callback): PreRunStage {
        return PreRunStage(
            appContext,
            work,
            androidToolsModule.systemWindows,
            androidToolsModule.processKiller,
            callback
        )
    }

    fun getRunningWorkStage(
        work: WorkProto.Work,
        instrumentations: List<InstrumentationMeta>,
        callback: Stage.Callback
    ): RunStage {
        return RunStage(
            appContext,
            mainThreadHandler,
            runnerServerModule.clientObserver,
            work,
            ResultsHolder(work),
            androidToolsModule.dndController,
            runnerServerModule.cancelSignal,
            runnerServerModule.getClientBootstrapper(work),
            instrumentations,
            workModule.deviceKeyProvider,
            callback
        )
    }

    fun getFinalizingRunStage(
        work: WorkProto.Work,
        runReport: RunReport,
        callback: Stage.Callback
    ): FinalizeRunStage {
        return FinalizeRunStage(
            appContext,
            work,
            runReport,
            runtimeSwitch,
            callback
        )
    }

    fun getBundlingResultsStage(
        work: WorkProto.Work,
        runReport: RunReport,
        callback: Stage.Callback
    ): ResultsBundleStage {
        return ResultsBundleStage(
            appContext,
            work,
            runReport,
            runnerServerModule.getResultsBundler(work, runReport),
            callback
        )
    }

    fun getUploadingResultsStage(
        work: WorkProto.Work,
        runReport: RunReport,
        callback: Stage.Callback
    ): ResultsUploadStage {
        return ResultsUploadStage(
            appContext,
            work,
            runReport,
            workModule.getResultsUploader(work),
            callback
        )
    }

    fun getCleaningWorkStage(
        work: WorkProto.Work,
        workSummary: WorkSummaryProto.WorkSummary,
        runReport: RunReport,
        callback: Stage.Callback
    ): CleanupStage {
        val cleaner = workModule.getWorkFinalizer(work) {
            historyStore.upsert(work, runReport, workSummary)
        }

        return CleanupStage(
            appContext,
            work,
            runnerServerModule.getUiAutomationCreator(),
            cleaner,
            runnerServerModule.cancelSignal,
            getPayloadUnInstaller(work),
            callback
        )
    }
    // endregion
}
