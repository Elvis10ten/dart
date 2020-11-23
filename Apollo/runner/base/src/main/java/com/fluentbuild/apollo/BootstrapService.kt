package com.fluentbuild.apollo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

private const val LOG_TAG = "BootstrapService"

class BootstrapService: Service() {

    private val binder = BootstrapBinder()

    override fun onBind(intent: Intent?): IBinder {
        Log.i(LOG_TAG, "Bound to BootstrapService")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(LOG_TAG, "Unbind from BootstrapService")
        super.onUnbind(intent)
        return true
    }

    override fun onRebind(intent: Intent?) {
        Log.i(LOG_TAG, "Rebind to BootstrapService")
        super.onRebind(intent)
    }

    inner class BootstrapBinder : Binder() {}
}