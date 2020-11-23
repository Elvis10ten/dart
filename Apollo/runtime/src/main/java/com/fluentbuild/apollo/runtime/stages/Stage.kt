package com.fluentbuild.apollo.runtime.stages

import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.RuntimeManager
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto
import timber.log.Timber

/**
 * A Stage is associated with the current [RuntimeState].
 * The Stage handles all operations of the runtime for that given state.
 *
 * A Stage is started when it is needed and stopped when it is no longer needed.
 * All operations being performed by the Stage must be stopped when it is stopped.
 *
 * Stages are usually light weight single use objects.
 * The actual functionality being performed is done by other component and the Stage mostly handles coordination.
 *
 * A Stage can complete, specifying what is the next [RuntimeState] to goto.
 * A Stage can error, which stops the Runtime in an error state or restarts it (depends on the [RuntimeManager]
 */
abstract class Stage(
    private val callback: Callback
) {

    protected var isStarted = false
        private set
    private var numRetries = 0

    open val work: WorkProto.Work? = null

    @MainThread
    fun start() {
        Timber.i("Starting stage: %s", getAction())
        requireMainThread()
        isStarted = true
        onStart()
    }

    @MainThread
    fun stop() {
        Timber.i("Stopping stage: %s", getAction())
        requireMainThread()
        onStop()
        isStarted = false
    }

    @MainThread
    open fun canRetry(throwable: Throwable): Boolean {
        return numRetries < getMaxRetries() && throwable !is InterruptedException
    }

    @MainThread
    fun retry(throwable: Throwable) {
        requireMainThread()
        check(canRetry(throwable)) { "Cannot retry: ${getAction()}" }
        numRetries++
        onRetry(throwable)
    }

    @MainThread
    protected fun onComplete(nextState: RuntimeState) {
        requireMainThread()
        Timber.d("%s OnComplete; NextState: %s", getAction(), nextState)
        requireStarted()
        callback.onComplete(nextState)
    }

    @MainThread
    protected fun onError(throwable: Throwable) {
        requireMainThread()
        Timber.e(throwable,"%s OnError", getAction())
        requireStarted()
        callback.onError(throwable)
    }

    @MainThread
    protected fun updateUi(uiData: UiData) {
        requireMainThread()
        Timber.d("%s UpdateUi; UiData: %s", getAction(), uiData)
        requireStarted()
        callback.onUiUpdated(uiData)
    }

    @MainThread
    private fun requireStarted() = check(isStarted) { "Stage is not started" }

    @MainThread
    protected abstract fun onStart()

    @MainThread
    protected abstract fun onStop()

    @MainThread
    protected abstract fun getAction(): String

    @MainThread
    protected open fun onRetry(throwable: Throwable) {}

    @MainThread
    open fun getBinder(): StageServiceBinder? = null

    @MainThread
    protected abstract fun getMaxRetries(): Int

    interface Callback {

        @MainThread
        fun onUiUpdated(uiData: UiData)

        @MainThread
        fun onComplete(nextState: RuntimeState)

        @MainThread
        fun onError(error: Throwable)
    }
}
