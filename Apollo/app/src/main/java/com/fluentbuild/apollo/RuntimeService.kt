package com.fluentbuild.apollo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.content.ContextCompat
import com.fluentbuild.apollo.analytics.EventPublisher
import com.fluentbuild.apollo.runtime.RuntimeManager
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.startup.Igniter
import com.fluentbuild.apollo.setup.ComponentInjector
import com.fluentbuild.apollo.utils.ErrorMessageProvider
import com.fluentbuild.apollo.utils.RuntimeNotification

private const val ARG_ACTION = "ARG_ACTION"
private const val ACTION_STOP = "com.fluentbuild.apollo.ACTION_STOP"
private const val ACTION_START = "com.fluentbuild.apollo.ACTION_START"

class RuntimeService: Service(), RuntimeManager.Callback, Igniter.Callback {

    lateinit var runtimeManager: RuntimeManager
    lateinit var runtimeNotification: RuntimeNotification
    lateinit var eventPublisher: EventPublisher
    lateinit var igniter: Igniter

    override fun onBind(intent: Intent): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        initService()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.getStringExtra(ARG_ACTION)) {
            ACTION_START -> {
                runtimeManager.startup()
            }
            ACTION_STOP -> {
                stopSelf()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        runtimeManager.removeCallback(this)
        igniter.removeCallback(this)
        runtimeManager.shutdown()
        runtimeNotification.stopForeground()
        super.onDestroy()
    }

    private fun initService() {
        ComponentInjector.inject(this)
        runtimeNotification.startForeground()
        runtimeManager.addCallback(this)
    }

    override fun onStateChanged(state: RuntimeState) {
        if(state is RuntimeState.PreparingRun || state is RuntimeState.FinalizingRun) {
            val launchUiIntent = MainActivity.getIntent(this)
            launchUiIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            launchUiIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(launchUiIntent)
        }
    }

    override fun onUiUpdated(uiData: UiData) {
        runtimeNotification.showMessage(uiData.message)
    }

    override fun onError(error: Throwable) {
        eventPublisher.publish(error)
        runtimeManager.shutdown()
        runtimeNotification.showMessage(ErrorMessageProvider.get(this, error))
    }

    override fun onEvent(event: Igniter.Event) {
        if(!event.shouldRun() && runtimeNotification.isForeground) {
            runtimeNotification.stopForeground()
        }
    }

    companion object {

        fun startup(context: Context) {
            Intent(context, RuntimeService::class.java).apply {
                putExtra(ARG_ACTION, ACTION_START)
                ContextCompat.startForegroundService(context, this)
            }
        }

        fun shutdown(context: Context) {
            context.stopService(Intent(context, RuntimeService::class.java))
        }

        fun getStopIntent(context: Context): Intent {
            return Intent(context, RuntimeService::class.java).apply {
                putExtra(ARG_ACTION, ACTION_STOP)
            }
        }
    }
}
