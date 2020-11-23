package com.fluentbuild.apollo.runner.server

import android.content.Context
import android.content.Intent
import com.fluentbuild.apollo.runner.ACTION_CANCEL_SIGNAL

class CancelSignal(
    private val appContext: Context
) {

    fun send() {
        appContext.sendBroadcast(Intent(ACTION_CANCEL_SIGNAL))
    }
}