package com.fluentbuild.apollo.androidtools.notifications

import android.app.NotificationManager.INTERRUPTION_FILTER_NONE
import android.content.Context
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.android.getNotificationManager
import com.fluentbuild.apollo.foundation.async.requireMainThread
import timber.log.Timber

class DndController(
    private val appContext: Context,
    private val dndPermission: DndPermission
) {

    private var initialUserFilter: Int? = null

    @MainThread
    @Throws(DndPermission.NotGrantedException::class)
    fun start() {
        Timber.i("Starting DND!")
        requireMainThread()

        if(AndroidVersion.isAtLeastMarshmallow()) {
            dndPermission.require()
            val notificationManager = appContext.getNotificationManager()

            if(initialUserFilter == null) {
                initialUserFilter = notificationManager.currentInterruptionFilter
            }

            notificationManager.setInterruptionFilter(INTERRUPTION_FILTER_NONE)
        }
    }

    @MainThread
    @Throws(DndPermission.NotGrantedException::class)
    fun stop() {
        Timber.i("Stopping DND!")
        requireMainThread()

        if(AndroidVersion.isAtLeastMarshmallow()) {
            dndPermission.require()
            initialUserFilter?.let {
                appContext.getNotificationManager().setInterruptionFilter(it)
            }
            initialUserFilter = null
        }
    }
}