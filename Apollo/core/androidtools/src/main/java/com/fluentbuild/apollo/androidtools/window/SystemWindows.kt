package com.fluentbuild.apollo.androidtools.window

import android.content.Context
import android.content.Intent
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread

class SystemWindows(private val appContext: Context) {

    @MainThread
    fun close() {
        requireMainThread()
        appContext.sendBroadcast(Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS))
    }
}