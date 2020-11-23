package com.fluentbuild.apollo.work

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.DEFAULT_IO_BUFFER_SIZE
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.overwrite
import com.fluentbuild.apollo.foundation.async.cancelInterrupting
import com.fluentbuild.apollo.foundation.autoClose
import timber.log.Timber
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.zip.ZipEntry
import java.util.zip.ZipFile

/**
 * Decompresses files from the given payload file into the directory.
 *
 * Files in the directory are decompressed atomically,
 * ie: Either all files are decompressed successfully, or the entire transaction is rolled backed and an error reported.
 */
class PayloadUnbundler(
    private val mainThreadHandler: Handler,
    private val executorService: ExecutorService,
    private val workFiles: WorkFiles
) {

    @MainThread
    fun unbundle(callback: Callback): Cancellable {
        requireMainThread()

        var unbundleCallback: Callback? = callback
        val unbundleCallbackProvider = { unbundleCallback }
        val future = unbundle(unbundleCallbackProvider)

        return object: Cancellable {

            override fun cancel() {
                unbundleCallback = null
                future.cancelInterrupting()
                Timber.i("Cancelling unbundle payload request")
            }
        }
    }

    private fun unbundle(
        callbackProvider: () -> Callback?
    ): Future<*> {
        return executorService.submit {
            Timber.i("Unbundling work payload")
            val copiedFiles = mutableListOf<File>()

            try {
                ZipFile(workFiles.getPayloadBundle()).autoClose { zipFile ->
                    for(zipEntry in zipFile.entries()) {
                        if(callbackProvider() == null) {
                            break
                        }
                        copiedFiles += zipEntry.copy(zipFile, workFiles.workDir)
                    }
                }

                mainThreadHandler.post {
                    callbackProvider()?.onPayloadUnbundled()
                }
            } catch (e: Exception) {
                Timber.e(e, "Failed to unbundle work payload")
                copiedFiles.forEach { it.delete() }
                mainThreadHandler.post {
                    callbackProvider()?.onUnbundlePayloadError(e)
                }
            }
        }
    }

    interface Callback {

        fun onPayloadUnbundled()

        fun onUnbundlePayloadError(error: Throwable)
    }
}

private fun ZipEntry.copy(zipFile: ZipFile, destDir: File): File {
    val destFile = File(destDir, name)
    Timber.v("Copying file: %s to: %s", this, destFile)
    destFile.overwrite()

    destFile.outputStream().autoClose { fileOutputStream ->
        zipFile.getInputStream(this).copyTo(fileOutputStream, DEFAULT_IO_BUFFER_SIZE)

    }

    return destFile
}
