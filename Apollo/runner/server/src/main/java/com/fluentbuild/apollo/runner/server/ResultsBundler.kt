package com.fluentbuild.apollo.runner.server

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.cancelInterrupting
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.autoClose
import com.fluentbuild.apollo.foundation.overwrite
import com.fluentbuild.apollo.foundation.putDir
import com.fluentbuild.apollo.work.WorkFiles
import com.fluentbuild.apollo.work.tests.RunReportProto.RunReport
import timber.log.Timber
import java.io.File
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.zip.Deflater
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * Compresses all the results data
 *
 * Files  are compressed atomically,
 * ie: Either all files are compressed successfully, or the entire transaction is rolled backed and an error reported.
 */
class ResultsBundler(
    private val mainThreadHandler: Handler,
    private val executorService: ExecutorService,
    private val workFiles: WorkFiles,
    private val runReport: RunReport
) {

    @MainThread
    fun bundle(callback: Callback): Cancellable {
        Timber.i("Bundling results!")
        requireMainThread()

        val callbackRef = WeakReference(callback)
        val callbackProvider = { callbackRef.get() }
        val bundleFuture = bundle(callbackProvider)

        return object: Cancellable {

            override fun cancel() {
                Timber.i("Cancelling bundle results request")
                callbackRef.clear()
                bundleFuture.cancelInterrupting()
            }
        }
    }

    private fun bundle(callbackProvider: () -> Callback?): Future<*> {
        return executorService.submit {
            val destFile = workFiles.getResultsBundle()

            try {
                compressResults(destFile)
                mainThreadHandler.post {
                    callbackProvider()?.onResultsBundled()
                }
            } catch (e: Exception) {
                destFile.delete()
                mainThreadHandler.post {
                    callbackProvider()?.onBundleResultsError(e)
                }
            }
        }
    }

    private fun compressResults(destFile: File) {
        destFile.overwrite()
        val fileOutputStream = destFile.outputStream()

        ZipOutputStream(fileOutputStream).autoClose { destOutputStream ->
            destOutputStream.setLevel(Deflater.BEST_COMPRESSION)

            Timber.i("Compressing remote storage dir")
            destOutputStream.putDir(workFiles.remoteStorageDir)

            Timber.i("Compressing run report")
            destOutputStream.putNextEntry(ZipEntry(workFiles.getRunReportFileName()))
            runReport.writeTo(destOutputStream)

            destOutputStream.flush()
            fileOutputStream.fd.sync()
        }
    }

    interface Callback {

        fun onResultsBundled()

        fun onBundleResultsError(error: Exception)
    }
}