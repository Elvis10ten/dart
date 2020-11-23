package com.fluentbuild.apollo.runner.client.interrupts

import android.content.Context
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.base.WorkInterruptCallback
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor

internal class InterruptsManager(
    private val targetContext: Context,
    logWrapper: LogWrapper,
    private val activityMonitor: ActivityMonitor,
    private val interruptCallback: WorkInterruptCallback
) {

    private var hasInterrupted = false

    private val navigationInteractObserver = NavigationInteractObserver(
        logWrapper,
        object : NavigationInteractObserver.Callback {

            override fun onHomePressed() {
                interrupt(WorkInterruptCallback.Reason.HOME_PRESSED)
            }

            override fun onRecentAppsPressed() {
                interrupt(WorkInterruptCallback.Reason.RECENT_APPS_PRESSED)
            }
        }
    )

    private val windowInteractObserver = WindowInteractObserver(
        logWrapper,
        object: WindowInteractObserver.Callback {

            override fun onWindowTouchedByUser() {
                interrupt(WorkInterruptCallback.Reason.WINDOW_PRESSED)
            }

            override fun onKeyPressedByUser() {
                interrupt(WorkInterruptCallback.Reason.KEY_PRESSED)
            }
        }
    )

    @MainThread
    fun start() {
        navigationInteractObserver.start(targetContext)
        activityMonitor.registerCallback(windowInteractObserver)
    }

    @MainThread
    fun stop() {
        navigationInteractObserver.stop(targetContext)
        activityMonitor.unregisterCallback(windowInteractObserver)
    }

    @MainThread
    private fun interrupt(reason: WorkInterruptCallback.Reason) {
        if(hasInterrupted) return
        hasInterrupted = true
        interruptCallback.onInterrupted(reason)
    }
}