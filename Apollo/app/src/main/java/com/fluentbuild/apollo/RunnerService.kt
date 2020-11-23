package com.fluentbuild.apollo

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import com.fluentbuild.apollo.runtime.RuntimeManager
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.stages.StageServiceBinder
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.setup.ComponentInjector
import com.fluentbuild.apollo.setup.NotificationWrapper
import timber.log.Timber

class RunnerService: Service(), RuntimeManager.Callback {

    lateinit var runtimeManager: RuntimeManager
    lateinit var notificationWrapperProvider: () -> NotificationWrapper?
    lateinit var mainThreadHandler: Handler

    private var stageServiceBinder: StageServiceBinder? = null

    override fun onBind(intent: Intent?): IBinder? {
        return runtimeManager.getCurrentStageBinder()?.apply {
            initService()
            Timber.i("Client connecting to runner service!")
            // todo: handle isolated
            stageServiceBinder = this
        }?.binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        mainThreadHandler.post {
            stageServiceBinder?.unbindCallback?.invoke()
            // todo: handle isolated
            stageServiceBinder = null
        }
        return super.onUnbind(intent)
    }

    private fun initService() {
        val notificationWrapper = notificationWrapperProvider() ?: throw IllegalStateException()
        startForeground(notificationWrapper.id, notificationWrapper.notification)
        runtimeManager.addCallback(this)
    }

    override fun onStateChanged(state: RuntimeState) {
        if(state !is RuntimeState.RunningWork) {
            // todo: find a different way to detach stageServiceBinder(), as this leads to errors on retries, since the runtime doesn't change state from running (remains in running)
            stageServiceBinder = null
            stopSelf()
        }
    }

    override fun onUiUpdated(uiData: UiData) {}

    override fun onError(error: Throwable) {}

    override fun onCreate() {
        super.onCreate()
        ComponentInjector.inject(this)
    }

    override fun onDestroy() {
        runtimeManager.removeCallback(this)
        super.onDestroy()
    }
}