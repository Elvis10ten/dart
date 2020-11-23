package com.fluentbuild.apollo

import android.app.Application
import com.fluentbuild.apollo.setup.AppInitializer

class FluentApplication: Application() {

    override fun onCreate() {
        INSTANCE = this
        super.onCreate()
        AppInitializer(this, BuildConfig.DEBUG).init()
    }

    companion object {

        lateinit var INSTANCE: FluentApplication
            private set
    }
}
