package com.fluentbuild.apollo.automation

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.foldNull
import java.util.concurrent.TimeoutException

private const val INIT_TIMEOUT_MILLIS = 10_000L
private const val RUNTIME_PACKAGE = "com.fluentbuild.apollo"
private const val AUTOMATION_SERVICE = "com.fluentbuild.apollo.runtime.automation.AutomationProxyService"
private const val LOG_TAG = "UiAutomationConnector"

class UiAutomationConnector(
    private val context: Context,
    private val logWrapper: LogWrapper
) {

    private val connectLock = Object()
    private val timeoutHandler = Handler(context.mainLooper)

    private val intent = Intent().apply {
        setClassName(RUNTIME_PACKAGE, AUTOMATION_SERVICE)
    }

    private var callback: Callback? = null
    private var uiAutomation: UiAutomation? = null
    private var flags: Int? = null

    private var isConnecting = false
    private var isServiceBindRequested = false
    private val serviceConnection = object: ServiceConnection {

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            clearTimeoutCountdown()
            logWrapper.i(LOG_TAG, "Connected to AutomationService!")

            callback.foldNull({
                setConnecting(false)
                val connectedUiAutomation = getUiAutomation(service)
                uiAutomation = connectedUiAutomation
                setupFlags()
                it.onConnected(connectedUiAutomation)
            }, {
                dispose()
            })
        }

        override fun onServiceDisconnected(name: ComponentName) {
            logWrapper.e(LOG_TAG, "On service disconnected")
            onServiceFailure()
        }

        override fun onBindingDied(name: ComponentName?) {
            logWrapper.e(LOG_TAG, "On service binding died")
            onServiceFailure()
        }
    }

    private val timeoutRunnable = Runnable {
        if(uiAutomation == null) {
            logWrapper.e(LOG_TAG, "Timed out while connecting to UiAutomation")
            dispose()
            callback?.onConnectTimeout()
        }
    }

    /**
     * Creates a new instance of [UiAutomation]. The returned [UiAutomation] is cached for the lifetime of this object.
     * If a call to connect is made again and there is a cached [UiAutomation] that is connected, then it is passed to
     * the callback immediately
     *
     * You should always call [dispose] to release any resources acquired here.
     *
     * T
     */
    fun connect(_flags: Int? = null, _callback: Callback) {
        logWrapper.i(LOG_TAG, "Connecting to AutomationService!")
        synchronized(connectLock) {
            if (isConnecting) {
                throw AlreadyConnectingException()
            }

            setConnecting(true)
            callback = _callback
            flags = _flags

            uiAutomation?.let {
                logWrapper.i(LOG_TAG, "Already connected to AutomationService!")
                setConnecting(false)
                setupFlags()
                callback?.onConnected(it)
                return
            }

            isServiceBindRequested = context.bindService(
                intent,
                serviceConnection,
                Context.BIND_AUTO_CREATE
            )

            if(!isServiceBindRequested) {
                logWrapper.e(LOG_TAG, "Couldn't bind to service")
                onServiceFailure()
                return
            }

            startTimeoutCountdown()
        }
    }

    /**
     * Clean up any resources being used.
     */
    fun dispose() {
        logWrapper.i(LOG_TAG, "Disposing UiAutomationCreator")
        synchronized(connectLock) {
            setConnecting(false)
            callback = null

            clearTimeoutCountdown()

            if (isServiceBindRequested) {
                context.unbindService(serviceConnection)
                isServiceBindRequested = false
            }

            uiAutomation = null
        }
    }

    private fun setConnecting(isConnecting: Boolean) {
        synchronized(connectLock) {
            this.isConnecting = isConnecting
        }
    }

    private fun setupFlags() {
        if(uiAutomation?.getFlags() != flags) {
            uiAutomation?.setFlags(flags)
        }
    }

    private fun getUiAutomation(service: IBinder): UiAutomation {
        val automationServer = AutomationServer.Stub.asInterface(service)
        val client = AutomationClient(automationServer, logWrapper)
        return UiAutomation(client, logWrapper) {
            logWrapper.i(LOG_TAG, "Disconnecting from UiAutomation!")
            dispose()
        }
    }

    private fun onServiceFailure() {
        setConnecting(false)
        clearTimeoutCountdown()
        uiAutomation?.disconnect()
        callback?.onServiceError()
    }

    private fun startTimeoutCountdown() {
        logWrapper.v(LOG_TAG, "Starting timeout countdown")
        timeoutHandler.postDelayed(timeoutRunnable, INIT_TIMEOUT_MILLIS)
    }

    private fun clearTimeoutCountdown() {
        logWrapper.v(LOG_TAG, "Clearing timeout runnable")
        timeoutHandler.removeCallbacks(timeoutRunnable)
    }

    interface Callback {

        fun onConnected(uiAutomation: UiAutomation)

        fun onConnectTimeout()

        fun onServiceError()
    }
}

class UiAutomationConnectTimeoutException: TimeoutException()

class UiAutomationServiceFailedException: RuntimeException()

class AlreadyConnectingException: RuntimeException()