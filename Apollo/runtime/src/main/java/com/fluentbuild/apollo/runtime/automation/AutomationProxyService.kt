package com.fluentbuild.apollo.runtime.automation

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AutomationProxyService: Service() {

    private val lock = Object()
    private lateinit var server: UiAutomationServer

    override fun onCreate() {
        server = AutomationModule.getInstance(this).getUiAutomationServer()
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        setupServer()
        return server
    }

    override fun onRebind(intent: Intent?) {
        setupServer()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        cleanupServer()
        return true
    }

    private fun setupServer() {
        synchronized(lock) {
            AutomationService.INSTANCE?.onAccessibilityEventListener = {
                server.onAccessibilityEvent(it)
            }

            AutomationService.onConnectCallback = {
                setupServer()
            }
        }
    }

    private fun cleanupServer() {
        synchronized(lock) {
            AutomationService.INSTANCE?.onAccessibilityEventListener = null
            AutomationService.onConnectCallback = null
            server.lastAccessibilityEvent = null
            server.accessibilityEventListener = null
        }
    }

    /*Settings.System.putInt(
    getContentResolver(),
    Settings.System.ACCELEROMETER_ROTATION,
    0
    );

    Settings.System.putInt(
    getContentResolver(),
    Settings.System.USER_ROTATION,
    Surface.ROTATION_0 //Or a different ROTATION_ constant
    );*/
}
