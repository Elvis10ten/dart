package com.fluentbuild.apollo.runtime

import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.runner.server.WorkerRetainer
import com.fluentbuild.apollo.runtime.stages.StageServiceBinder
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.stages.Stage
import com.fluentbuild.apollo.runtime.startup.Igniter
import com.fluentbuild.apollo.work.WorkProto
import timber.log.Timber

class RuntimeManager(
    private val stageProvider: StageProvider,
    private val igniter: Igniter,
    private val workerRetainer: WorkerRetainer
) {

    private lateinit var currentState: RuntimeState
    private lateinit var currentStage: Stage

    private var lastRuntimeUiData: UiData? = null
    private var lastRuntimeError: Throwable? = null
    private val callbacks = mutableSetOf<Callback>()

    private val stageCallback = object: Stage.Callback {

        override fun onUiUpdated(uiData: UiData) {
            lastRuntimeUiData = uiData
            callbacks.forEach { it.onUiUpdated(uiData) }
        }

        override fun onComplete(nextState: RuntimeState) {
            updateState(nextState)
        }

        override fun onError(error: Throwable) {
            if(currentStage.canRetry(error)) {
                currentStage.retry(error)
            } else {
                lastRuntimeError = error
                callbacks.forEach { it.onError(error) }
            }
        }
    }

    init {
        updateState(RuntimeState.Idle)
    }

    @MainThread
    fun startup() {
        requireMainThread()
        Timber.d("Startup Runtime")
        igniter.onEvent(Igniter.Event.MANUAL_START)
    }

    @MainThread
    fun shutdown() {
        requireMainThread()
        Timber.d("Shutdown Runtime")
        igniter.onEvent(Igniter.Event.MANUAL_STOP)
        goIdle()
    }

    @MainThread
    fun getCurrentState(): RuntimeState {
        requireMainThread()
        return currentState
    }

    @MainThread
    private fun updateState(newState: RuntimeState) {
        currentState = newState
        onStateChanged(newState)
        callbacks.forEach { it.onStateChanged(newState) }
    }

    @MainThread
    private fun onStateChanged(newState: RuntimeState) {
        stopCurrentStage()

        currentStage = stageProvider.get(newState, stageCallback)
        lastRuntimeUiData = null
        lastRuntimeError = null

        val stageWork = currentStage.work
        if(stageWork != null) {
            workerRetainer.startRetainer(stageWork) { goIdle() }
        } else {
            workerRetainer.stopRetainer()
        }

        currentStage.start()
    }

    @MainThread
    fun addCallback(callback: Callback) {
        requireMainThread()
        callback.onStateChanged(currentState)
        lastRuntimeUiData?.let { callback.onUiUpdated(it) }
        lastRuntimeError?.let { callback.onError(it) }
        callbacks.add(callback)
    }

    @MainThread
    fun removeCallback(callback: Callback) {
        requireMainThread()
        callbacks.remove(callback)
    }

    @MainThread
    fun getCurrentStageBinder(): StageServiceBinder? {
        requireMainThread()
        return currentStage.getBinder()
    }

    @MainThread
    fun getCurrentWork(): WorkProto.Work? {
        requireMainThread()
        return currentStage.work
    }

    private fun stopCurrentStage() {
        if(::currentStage.isInitialized) {
            currentStage.stop()
        }
    }

    private fun goIdle() {
        updateState(RuntimeState.Idle)
    }

    interface Callback {

        fun onStateChanged(state: RuntimeState)

        fun onUiUpdated(uiData: UiData)

        fun onError(error: Throwable)
    }
}
