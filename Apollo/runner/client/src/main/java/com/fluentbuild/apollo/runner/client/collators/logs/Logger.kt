package com.fluentbuild.apollo.runner.client.collators.logs

import android.os.ParcelFileDescriptor
import android.util.Log
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.closeCatching
import com.fluentbuild.apollo.foundation.copyAllLines
import com.fluentbuild.apollo.runner.client.FileDescriptorProvider
import java.io.InterruptedIOException
import java.lang.Runtime.getRuntime

private const val CMD_CLEAR_LOGCAT_BUFFERS = "logcat -b all -c"
private const val CMD_START_LOGCAT = "logcat -b all -v threadtime,epoch,printable --dividers"
private const val MAX_RETRIES = 3
private const val LOG_TAG = "Logger"

// TODO: 1. Restarts if inactivity is detected
class Logger(
    private val fieProvider: FileDescriptorProvider,
    private val logWrapper: LogWrapper
) {

    private var logcat: Process? = null
    private var loggingThread: Thread? = null
    private var parcelLogFileDescriptor: ParcelFileDescriptor? = null
    private var retryCount = 0

    fun startLogging(fileName: String) {
        logWrapper.i(LOG_TAG, "Starting logging!")
        retryCount = 0

        loggingThread = Thread {
            try {
                logResiliently(fileName)
            } catch (e: Exception) {
                logWrapper.e(LOG_TAG, e, "Logging error")
            }
        }.apply {
            name = "LoggerThread"
            start()
        }
    }

    @Throws(Exception::class, InterruptedException::class)
    private fun logToFile() {
        val logFileDescriptor = parcelLogFileDescriptor ?: return
        logcat?.inputStream?.copyAllLines(logFileDescriptor)
    }

    fun stopLogging() {
        Log.i(LOG_TAG, "Stopping logging!")
        loggingThread?.interrupt()
        logcat?.destroy()

        parcelLogFileDescriptor?.closeCatching {
            logWrapper.e(LOG_TAG, it, "Failed to close FD")
        }

        loggingThread = null
        logcat = null
        parcelLogFileDescriptor = null
    }

    private fun logResiliently(fileName: String) {
        try {
            clearLogcat()
            logcat = getRuntime().exec(CMD_START_LOGCAT)
            parcelLogFileDescriptor = fieProvider.getAppendableDescriptor(fileName)
            logToFile()
        } catch (e: Throwable) {
            if(retryCount < MAX_RETRIES && isRetryable(e)) {
                retryCount++
                logcat?.destroy()
                parcelLogFileDescriptor?.close()
                logResiliently(fileName)
            } else {
                throw e
            }
        }
    }

    private fun clearLogcat() {
        val clearProcess = getRuntime().exec(CMD_CLEAR_LOGCAT_BUFFERS)
        clearProcess.destroy()
    }

    private fun isRetryable(error: Throwable): Boolean {
        return error !is InterruptedIOException && error !is InterruptedException
    }
}