package com.fluentbuild.apollo.runner.client.interrupts

import android.app.Activity
import android.view.KeyEvent
import android.view.MotionEvent
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.measurement.ActivityStatsProto.ActivityStats
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor

private const val LOG_TAG = "NavigationClickWatcher"

internal class WindowInteractObserver(
    private val logWrapper: LogWrapper,
    private val callback: Callback
): ActivityMonitor.Callback {

    override fun onStageChanged(activity: Activity, stage: ActivityStats.Stage) {
        /*if(stage == ActivityStats.Stage.CREATED) {
            activity.window.callback = object: WindowCallbackWrapper(activity.window.callback) {

                override fun dispatchTouchEvent(event: MotionEvent): Boolean {
                    evaluateUserMotion(event)
                    return super.dispatchTouchEvent(event)
                }

                override fun dispatchKeyEvent(event: KeyEvent): Boolean {
                    evaluateUserKeyInput(event)
                    return super.dispatchKeyEvent(event)
                }
            }
        }*/
    }

    private fun evaluateUserMotion(event: MotionEvent) {
        if(event.toolMajor != 0f && event.toolMinor != 0f) {
            logWrapper.i(LOG_TAG, "Motion event tool major/minor is zero")
            callback.onWindowTouchedByUser()
        }
    }

    private fun evaluateUserKeyInput(event: KeyEvent) {
        if(event.scanCode != 0) {
            logWrapper.i(LOG_TAG, "Key scanCode is zero")
            callback.onKeyPressedByUser()
        }
    }

    interface Callback {

        fun onWindowTouchedByUser()

        fun onKeyPressedByUser()
    }
}