package com.fluentbuild.apollo.foundation.async

import android.os.Handler

abstract class RepeatableRunnable(
    private val handler: Handler,
    private val repeatMillis: Long
): Runnable {

    private val startLock = Object()
    private var isActive = true

    override fun run() {
        if(isActive) {
            onRun()
            repeat()
        }
    }

    abstract fun onRun()

    fun startRepeating(now: Boolean) {
        synchronized(startLock) {
            if (!isActive) {
                isActive = true

                if (now) {
                    handler.post(this)
                } else {
                    handler.postDelayed(this, repeatMillis)
                }
            }
        }
    }

    fun stopRepeating() {
        synchronized(startLock) {
            if (isActive) {
                isActive = false
                handler.removeCallbacks(this)
            }
        }
    }

    private fun repeat() {
        if(isActive) {
            handler.postDelayed(this, repeatMillis)
        }
    }
}