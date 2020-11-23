package com.fluentbuild.apollo.androidtools.notifications

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.fluentbuild.apollo.foundation.android.getNotificationManager

class DndPermission(private val appContext: Context) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun request() {
        Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            appContext.startActivity(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun has(): Boolean {
        return appContext.getNotificationManager().isNotificationPolicyAccessGranted
    }

    @Throws(NotGrantedException::class)
    @RequiresApi(Build.VERSION_CODES.M)
    internal fun require() {
        if (!has()) {
            throw NotGrantedException()
        }
    }

    class NotGrantedException: SecurityException()
}