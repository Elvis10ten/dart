package com.fluentbuild.apollo.work

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.async.cancelInterrupting
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class WorkFinalizer(
    private val workFiles: WorkFiles,
    private val historyUpdater: () -> Unit,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler
) {

    @MainThread
    fun finalize(callback: Callback): Cancellable {
        requireMainThread()

        var finalizeCallback: Callback? = callback
        val callbackProvider = { finalizeCallback }
        val future = finalize(callbackProvider)

        return object: Cancellable {

            override fun cancel() {
                finalizeCallback = null
                Timber.i("Cancelling work finalizer")
                future.cancelInterrupting()
            }
        }
    }

    private fun finalize(finalizeCallbackProvider: () -> Callback?): Future<*> {
        return executorService.submit {
            try {
                if(finalizeCallbackProvider() == null) return@submit
                Timber.d("Cleaning up work data")
                workFiles.clear()

                if(finalizeCallbackProvider() == null) return@submit
                Timber.d("Updating work history")
                historyUpdater()

                mainThreadHandler.post {
                    finalizeCallbackProvider()?.onWorkFinalized()
                }
            } catch (e: Exception) {
                Timber.e(e, "Failed to finalize work")
                mainThreadHandler.post {
                    finalizeCallbackProvider()?.onWorkFinalizeError(e)
                }
            }
        }
    }

    interface Callback {

        fun onWorkFinalized()

        fun onWorkFinalizeError(error: Throwable)
    }
}
