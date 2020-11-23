package com.fluentbuild.apollo.foundation.async

import android.os.Handler
import androidx.annotation.MainThread
import java.lang.Exception
import java.util.concurrent.ExecutorService
import java.util.concurrent.ThreadPoolExecutor

@Deprecated("Maybe")
abstract class Service<R: Any>(
    private val executor: ExecutorService,
    private val mainThreadHandler: Handler
) {

    private var currentState: ServiceState<R> =
        ServiceState.Idle
    private var callback: ((ServiceState<R>) -> Unit)? = null

    @MainThread
    fun setCallback(callback: (ServiceState<R>) -> Unit) {
        requireMainThread()
        this.callback = callback
        callback(currentState)
    }

    @MainThread
    fun removeCallback() {
        requireMainThread()
        callback = null
    }

    @MainThread
    fun cleanup() {
        requireMainThread()
        removeCallback()
        currentState = ServiceState.Idle
    }

    protected fun updateState(taskState: ServiceState<R>) {
        currentState = taskState
        mainThreadHandler.post { callback?.invoke(taskState) }
    }

    protected fun execute(callable: () -> R) {
        // TODO: WTF? Run this in the executor service
        try {
            val result = callable()
            updateState(ServiceState.Success(result))
        } catch (e: Exception) {
            updateState(ServiceState.Error(e))
        }
    }
}
