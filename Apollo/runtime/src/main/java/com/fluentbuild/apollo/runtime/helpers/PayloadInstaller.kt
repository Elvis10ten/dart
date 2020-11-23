package com.fluentbuild.apollo.runtime.helpers

import android.content.Context
import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.androidtools.SystemButtonClicker
import com.fluentbuild.apollo.androidtools.packages.*
import com.fluentbuild.apollo.androidtools.window.SystemWindows
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.foundation.async.Cancellables
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.android.isInstalledAndEnabled
import com.fluentbuild.apollo.work.WorkFiles
import com.fluentbuild.apollo.work.WorkProto.Work
import java.io.File

class PayloadInstaller(
    private val appContext: Context,
    private val work: Work,
    private val workFiles: WorkFiles,
    private val mainThreadHandler: Handler,
    private val apkHelper: ApkHelper,
    private val packageInstaller: PackageInstaller,
    private val systemWindows: SystemWindows
) {

    private var callback: Callback? = null
    private lateinit var uiAutomation: UiAutomation
    private var cancellables = Cancellables()

    @MainThread
    fun install(callback: Callback, uiAutomation: UiAutomation) {
        requireMainThread()
        this.callback = callback
        this.uiAutomation = uiAutomation
        installMainApp()
    }

    @MainThread
    fun cancel() {
        requireMainThread()
        callback = null
        setClicker(null)
        cancellables.cancelAll()
    }

    private fun installMainApp() {
        installApp(
            work.packageName,
            workFiles.getMainApp(),
            { installTestApp() }
        )
    }

    private fun installTestApp() {
        installApp(
            work.testPackageName,
            workFiles.getTestApp(),
            { callback?.onPayloadInstalled() }
        )
    }

    private fun installApp(
        packageName: String,
        appFile: File,
        onSuccess: () -> Unit,
        usePrimaryStrategy: Boolean = true
    ) {
        systemWindows.close()
        val errorHandler = { error: Throwable ->
            if(usePrimaryStrategy) {
                installApp(packageName, appFile, onSuccess, false)
            } else {
                callback?.onPayloadInstallFailed(error)
            }
            Unit
        }

        setClicker(
            SystemButtonClicker(
                SYSTEM_INSTALLERS,
                INSTALLER_CLICK_BUTTON_VIEW_ID,
                INSTALLER_CLICK_FAILURE_NEEDLE,
                { !appContext.isInstalledAndEnabled(packageName) },
                errorHandler
            )
        )

        val appUri = apkHelper.getUri(appFile)
        val request = PackageInstaller.Request(
            true,
            appFile,
            appUri,
            packageName
        )

        cancellables.cancelAll()
        val callback = createInstallCallback(onSuccess, errorHandler)
        cancellables.add(packageInstaller.install(request, callback))
    }

    private fun setClicker(clicker: SystemButtonClicker?) {
        uiAutomation.setOnAccessibilityEventListener(clicker)
    }

    private fun createInstallCallback(
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ): PackageInstaller.Callback {
        return object: PackageInstaller.Callback {

            override fun onSuccess(request: PackageInstaller.Request) {
                setClicker(null)
                mainThreadHandler.postDelayed({
                    if(callback != null) {
                        onSuccess()
                    }
                }, INSTALL_UNINSTALL_REPORT_DELAY_MILLIS)
            }

            override fun onError(request: PackageInstaller.Request, error: Throwable) {
                setClicker(null)
                onError(error)
            }
        }
    }

    interface Callback {

        fun onPayloadInstalled()

        fun onPayloadInstallFailed(error: Throwable)
    }
}