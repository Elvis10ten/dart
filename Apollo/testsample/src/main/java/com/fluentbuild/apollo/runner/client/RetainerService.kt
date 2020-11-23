package com.fluentbuild.apollo.runner.client

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

private const val LOG_TAG = "RetainerService"

class RetainerService: Service() {

    private val binder = object: Binder() {}

    override fun onBind(intent: Intent?): IBinder {
        Log.d(LOG_TAG, "Binding RetainerService")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(LOG_TAG, "Unbinding RetainerService")
        return super.onUnbind(intent)
    }
}