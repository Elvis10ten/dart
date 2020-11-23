package com.fluentbuild.apollo.runner.client

import android.app.Activity
import android.app.Instrumentation
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.ACTION_CANCEL_SIGNAL
import com.fluentbuild.apollo.runner.client.instrumentation.finishInstrumentation

private const val LOG_TAG = "CancelSignalObserver"

class CancelSignalObserver(
    private val instrumentation: Instrumentation,
    private val logWrapper: LogWrapper
): BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action == ACTION_CANCEL_SIGNAL) {
            logWrapper.e(LOG_TAG, "Cancel signal received")
            instrumentation.finishInstrumentation(Activity.RESULT_CANCELED)
        }
    }

    fun start() {
        instrumentation.targetContext.registerReceiver(
            this,
            IntentFilter(ACTION_CANCEL_SIGNAL)
        )
    }

    fun stop() {
        instrumentation.targetContext.unregisterReceiver(this)
    }
}