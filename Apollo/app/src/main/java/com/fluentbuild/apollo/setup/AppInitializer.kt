package com.fluentbuild.apollo.setup

import android.content.Context
import timber.log.Timber

class AppInitializer(
    private val appContext: Context,
    private val isDebug: Boolean
) {

    fun init() {
        initLogging()
        NotificationChannelCreator(appContext).create()
    }

    private fun initLogging() {
        if(isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
