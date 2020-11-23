package com.fluentbuild.apollo.runner.server

import android.content.Context
import android.os.Handler
import com.fluentbuild.apollo.automation.UiAutomationConnector
import com.fluentbuild.apollo.runner.base.display.ScreenViewer
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.android.getMediaProjectionManager
import com.fluentbuild.apollo.foundation.android.getWindowManager
import com.fluentbuild.apollo.work.tests.RunReportProto.*
import com.fluentbuild.apollo.work.WorkModule
import com.fluentbuild.apollo.work.WorkProto.*
import java.util.concurrent.ExecutorService

class RunnerServerModule(
    private val appContext: Context,
    private val workModule: WorkModule,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler,
    private val logWrapper: LogWrapper
) {

    val cancelSignal by lazy { CancelSignal(appContext) }

    val workerRetainer by lazy {
        WorkerRetainer(
            mainThreadHandler,
            workModule.getWorkerStateReporter()
        )
    }

    val clientObserver by lazy {
        ClientObserver(
            mainThreadHandler,
            cancelSignal,
            workerRetainer
        )
    }

    fun getUiAutomationCreator(): UiAutomationConnector {
        return UiAutomationConnector(appContext, logWrapper)
    }

    fun getClientBootstrapper(work: Work) =
        ClientBootstrapper(appContext, work)

    fun getResultsBundler(
        work: Work,
        runReport: RunReport
    ): ResultsBundler {
        return ResultsBundler(
            mainThreadHandler,
            executorService,
            workModule.getWorkFiles(work),
            runReport
        )
    }

    val screenViewer by lazy {
        ScreenViewer(
            appContext.getWindowManager(),
            appContext.getMediaProjectionManager(),
            object : ScreenViewer.Callback {

                override fun onPermissionLost() {
                    // todo Timber.i("Permission lost")
                }

                override fun onPermissionObtained() {
                    // todo Timber.i("Permission obtained")
                }

                override fun onPermissionDenied() {
                    // todo Timber.i("Permission denied")
                }
            }
        )
    }
}