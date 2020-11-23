package com.fluentbuild.apollo.setup

import android.content.Context
import androidx.annotation.MainThread
import com.fluentbuild.apollo.*
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.presentation.PresentationModule
import com.fluentbuild.apollo.presentation.RuntimeSwitch
import com.fluentbuild.apollo.runtime.RuntimeModule
import com.fluentbuild.apollo.utils.RuntimeNotification

private const val AUTHORITY_FILE_PROVIDER = "com.fluentbuild.apollo.fileprovider"

object ComponentInjector {

    private const val hostName = "192.168.7.21"
    private const val port = 5050
    private val application by lazy { FluentApplication.INSTANCE }

    private val runtimeModule by lazy {
        RuntimeModule(
            application,
            BuildConfig.DEBUG,
            RemoteStorageProvider.getDir(application),
            AUTHORITY_FILE_PROVIDER,
            LogWrapper(BuildConfig.DEBUG)
        )
    }

    private val presentationModule by lazy {
        PresentationModule(runtimeModule, object: RuntimeSwitch {

            override fun startup(context: Context) {
                RuntimeService.startup(context)
            }

            override fun shutdown(context: Context) {
                RuntimeService.shutdown(context)
            }
        })
    }

    var notificationWrapper: NotificationWrapper? = null

    @MainThread
    fun inject(runtimeService: RuntimeService) {
        requireMainThread()
        runtimeService.runtimeManager = runtimeModule.runtimeManager
        runtimeService.eventPublisher = runtimeModule.analyticsModule.eventPublisher
        runtimeService.igniter = runtimeModule.runtimeSwitch
        runtimeService.runtimeNotification = RuntimeNotification(
            runtimeService,
            RUNTIME_NOTIFICATION_CHANNEL_ID
        )
    }

    @MainThread
    fun inject(mainActivity: MainActivity) {
        requireMainThread()
        mainActivity.navigator = presentationModule.navigator
        mainActivity.splashHostProvider = { presentationModule.getSplashHost() }
    }

    @MainThread
    fun inject(runnerService: RunnerService) {
        requireMainThread()
        runnerService.runtimeManager = runtimeModule.runtimeManager
        runnerService.mainThreadHandler = runtimeModule.mainThreadHandler
        runnerService.notificationWrapperProvider = { notificationWrapper }
    }

    fun inject(remoteStorageProvider: RemoteStorageProvider) {
        remoteStorageProvider.runtimeManager = runtimeModule.runtimeManager
    }
}
