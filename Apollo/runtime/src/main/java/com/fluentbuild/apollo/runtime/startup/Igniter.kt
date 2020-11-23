package com.fluentbuild.apollo.runtime.startup

import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import timber.log.Timber

class Igniter {

    private var lastEvent = Event.NONE
    private var callbacks = mutableSetOf<Callback>()

    @MainThread
    fun addCallback(callback: Callback) {
        requireMainThread()
        callbacks.add(callback)
        callback.onEvent(lastEvent)
    }

    @MainThread
    fun removeCallback(callback: Callback) {
        requireMainThread()
        callbacks.remove(callback)
    }

    @MainThread
    fun onEvent(event: Event) {
        requireMainThread()
        Timber.i("On event: %s", event)
        lastEvent = event
        updateCallbacks()
    }

    private fun updateCallbacks() {
        callbacks.forEach { it.onEvent(lastEvent) }
    }

    enum class Event {
        NONE,
        MANUAL_START,
        MANUAL_STOP,
        SCHEDULED_START,
        SCHEDULED_STOP;

        fun shouldRun() = this == MANUAL_START || this == SCHEDULED_START
    }

    interface Callback {

        fun onEvent(event: Event)
    }
}
