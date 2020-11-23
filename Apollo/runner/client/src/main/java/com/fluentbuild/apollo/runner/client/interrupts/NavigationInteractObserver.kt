package com.fluentbuild.apollo.runner.client.interrupts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.fluentbuild.apollo.foundation.android.LogWrapper

private const val SYSTEM_DIALOG_REASON_KEY = "reason"
private const val SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions"
private const val SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps"
private const val SYSTEM_DIALOG_REASON_HOME_KEY = "homekey"
private const val LOG_TAG = "NavigationClickWatcher"

internal class NavigationInteractObserver(
    private val logWrapper: LogWrapper,
    private val callback: Callback
): BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val action = intent?.action ?: return
        val reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY)
        logWrapper.i(LOG_TAG, "Action: $action, reason: $reason")

        if (action == Intent.ACTION_CLOSE_SYSTEM_DIALOGS) {
            if (reason == SYSTEM_DIALOG_REASON_HOME_KEY) {
                callback.onHomePressed()
            } else if (reason == SYSTEM_DIALOG_REASON_RECENT_APPS) {
                callback.onRecentAppsPressed()
            }
        }
    }

    fun start(context: Context) {
        context.registerReceiver(this, IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS))
    }

    fun stop(context: Context) {
        context.unregisterReceiver(this)
    }

    interface Callback {

        fun onHomePressed()

        fun onRecentAppsPressed()
    }
}