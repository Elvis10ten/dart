package com.fluentbuild.apollo.work

import android.content.Context
import android.os.Handler
import com.fluentbuild.apollo.persistence.kv.KeyValueStore
import com.fluentbuild.apollo.work.ft.*
import com.fluentbuild.apollo.work.props.DevicePropsProvider
import timber.log.Timber
import java.io.File
import java.util.concurrent.ExecutorService

private const val WORKS_DIR = "ws"

class WorkModule(
    private val appContext: Context,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler,
    private val remoteStorageDir: File,
    private val workService:  WorkServiceGrpc.WorkServiceStub,
    private val workKeyValueStore: KeyValueStore
) {

    private val worksDir by lazy { File(appContext.filesDir, WORKS_DIR).apply { mkdirs() } }

    val deviceKeyProvider by lazy {
         DeviceKeyProvider(appContext, workKeyValueStore)
    }

    private val ftLogger by lazy {
        object: FtLogger {

            override fun i(message: () -> String) {
                Timber.i(message())
            }

            override fun e(throwable: Throwable, message: () -> String) {
                Timber.e(throwable, message())
            }
        }
    }

    private fun getDevicePropsProvider(): DevicePropsProvider {
        return DevicePropsProvider(appContext, deviceKeyProvider)
    }

    private fun getStorage(dir: File): Storage {
        return FileStorage(dir, ftLogger)
    }

    fun getWorkFiles(work: WorkProto.Work): WorkFiles {
        return WorkFiles(remoteStorageDir, worksDir, work)
    }

    fun getWorkFinder(timeoutSeconds: Int): WorkFinder {
        return WorkFinder(
            timeoutSeconds,
            mainThreadHandler,
            workService,
            getDevicePropsProvider()
        )
    }

    fun getPayloadUnbundler(work: WorkProto.Work): PayloadUnbundler {
        return PayloadUnbundler(
            mainThreadHandler,
            executorService,
            getWorkFiles(work)
        )
    }

    fun getResultsUploader(work: WorkProto.Work): ResultsUploader {
        val workFiles = getWorkFiles(work)
        return ResultsUploader(
            getStorage(workFiles.resultsDir),
            work,
            workFiles,
            workService,
            mainThreadHandler,
            ftLogger
        )
    }

    fun getPayloadDownloader(work: WorkProto.Work): PayloadDownloader {
        val fileProvider = getWorkFiles(work)
        return PayloadDownloader(
            getStorage(fileProvider.workDir),
            workService,
            mainThreadHandler,
            ftLogger
        )
    }

    fun getWorkFinalizer(work: WorkProto.Work, historyUpdater: () -> Unit): WorkFinalizer {
        return WorkFinalizer(
            getWorkFiles(work),
            historyUpdater,
            executorService,
            mainThreadHandler
        )
    }

    fun getWorkerStateReporter(): WorkerStateReporter {
        return WorkerStateReporter(
            mainThreadHandler,
            workService,
            deviceKeyProvider
        )
    }
}
