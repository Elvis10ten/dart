package com.fluentbuild.apollo.runner.server

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import com.fluentbuild.apollo.work.WorkProto.*
import timber.log.Timber

private const val BOOTSTRAP_SERVICE_NAME = "com.fluentbuild.apollo.BootstrapService"
private const val MAX_RETRIES = 3

class ClientBootstrapper(
    private val appContext: Context,
    private val work: Work
) {

    private val intent = Intent().apply {
        setClassName(work.packageName, BOOTSTRAP_SERVICE_NAME)
    }

    private val serviceConnection = object: ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            Timber.e("Client BootstrapService is disconnected")
            attemptRetry()
        }

        override fun onBindingDied(name: ComponentName?) {
            Timber.e("Client BootstrapService binding died")
            attemptRetry()
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Timber.i("Client BootstrapService is connected!")
        }
    }

    private var isActive = false
    private var isBindRequested = false
    private var retryCount = 0

    fun start() {
        Timber.i("Starting client component bootstrapper")
        isActive = true
        startInternal()
    }

    private fun startInternal() {
        isBindRequested = appContext.bindService(
            intent,
            serviceConnection,
            Context.BIND_AUTO_CREATE
        )
    }

    fun stop() {
        Timber.i("Stopping client component bootstrapper")
        isActive = false
        stopInternal()
    }

    private fun stopInternal() {
        if(isBindRequested) {
            appContext.unbindService(serviceConnection)
            isBindRequested = false
        }
    }

    private fun attemptRetry() {
        if(retryCount < MAX_RETRIES) {
            retryCount++
            stopInternal()
            startInternal()
        }
    }
}