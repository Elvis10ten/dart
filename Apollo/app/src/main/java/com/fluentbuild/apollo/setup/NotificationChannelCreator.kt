package com.fluentbuild.apollo.setup

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.fluentbuild.apollo.R
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.android.getNotificationManager

const val RUNTIME_NOTIFICATION_CHANNEL_ID = "runtime"

class NotificationChannelCreator(private val appContext: Context) {

    fun create() {
        if (AndroidVersion.isAtLeastOreo()) {
            val name = appContext.getString(R.string.runtimeNotificationChannelTitle)
            val descriptionText = appContext.getString(R.string.runtimeNotificationChannelDescription)
            val importance = NotificationManager.IMPORTANCE_LOW

            NotificationChannel(RUNTIME_NOTIFICATION_CHANNEL_ID, name, importance).apply {
                description = descriptionText
                appContext.getNotificationManager().createNotificationChannel(this)
            }
        }
    }
}
