package com.fluentbuild.apollo.utils

import android.app.Notification
import android.app.PendingIntent
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.fluentbuild.apollo.MainActivity
import com.fluentbuild.apollo.R
import com.fluentbuild.apollo.RuntimeService
import com.fluentbuild.apollo.foundation.android.getNotificationManager
import com.fluentbuild.apollo.setup.ComponentInjector
import com.fluentbuild.apollo.setup.NotificationWrapper

private const val NOTIFICATION_ID = 1

class RuntimeNotification(
    private val runtimeService: RuntimeService,
    private val notificationChannelId: String
) {

    var isForeground: Boolean = false
        private set

    private val stopAction by lazy {
        val stopPendingIntent = PendingIntent.getService(
            runtimeService,
            0,
            RuntimeService.getStopIntent(runtimeService),
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        NotificationCompat.Action.Builder(
            R.drawable.ic_close_normal_24,
            runtimeService.getString(R.string.cancelRuntimeService),
            stopPendingIntent
        ).build()
    }

    private val launchAppIntent by lazy {
        PendingIntent.getActivity(
            runtimeService,
            0,
            MainActivity.getIntent(runtimeService),
            PendingIntent.FLAG_CANCEL_CURRENT
        )
    }

    fun showMessage(message: String) {
        val notification = getBaseNotificationBuilder()
            .setContentText(message)
            .build()
        holdNotification(notification)
        runtimeService.getNotificationManager().notify(NOTIFICATION_ID, notification)
    }

    fun startForeground() {
        isForeground = true
        val notification = getBaseNotificationBuilder()
            .build()
        holdNotification(notification)
        runtimeService.startForeground(NOTIFICATION_ID, notification)
    }

    fun stopForeground() {
        isForeground = false
        holdNotification(null)
        runtimeService.stopForeground(true)
    }

    private fun holdNotification(notification: Notification?) {
        ComponentInjector.notificationWrapper = if(notification == null) {
            null
        } else {
            NotificationWrapper(NOTIFICATION_ID, notification)
        }
    }

    private fun getBaseNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(runtimeService, notificationChannelId)
            .setContentTitle(runtimeService.getString(R.string.runtimeNotificationTitle))
            .setSmallIcon(R.drawable.ic_logo)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(launchAppIntent)
            .addAction(stopAction)
            .setColor(ContextCompat.getColor(runtimeService, R.color.colorPrimary))
            .setColorized(true)
    }
}