package com.fluentbuild.apollo.runtime.helpers

import android.content.Context
import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.androidtools.SystemButtonClicker
import com.fluentbuild.apollo.androidtools.packages.*
import com.fluentbuild.apollo.androidtools.window.SystemWindows
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.foundation.android.isInstalledAndEnabled
import com.fluentbuild.apollo.foundation.async.Cancellables
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.work.WorkProto

class PayloadUnInstaller(
    private val appContext: Context,
    private val work: WorkProto.Work,
    private val mainThreadHandler: Handler,
    private val packageRemover: PackageRemover,
    private val systemWindows: SystemWindows
) {

    private var callback: Callback? = null
    private lateinit var uiAutomation: UiAutomation
    private var cancellables = Cancellables()

    @MainThread
    fun uninstall(callback: Callback, uiAutomation: UiAutomation) {
        requireMainThread()
        this.callback = callback
        this.uiAutomation = uiAutomation
        uninstallMainApp()
    }

    @MainThread
    fun cancel() {
        requireMainThread()
        callback = null
        cancellables.cancelAll()
        setClicker(null)
    }

    private fun uninstallMainApp() {
        uninstallApp(
            work.packageName,
            { uninstallTestApp() }
        )
    }

    private fun uninstallTestApp() {
        uninstallApp(
            work.testPackageName,
            { callback?.onPayloadUninstalled() }
        )
    }
    
    private fun uninstallApp(
        packageName: String,
        onSuccess: () -> Unit,
        usePrimaryStrategy: Boolean = true
    ) {
        systemWindows.close()
        val errorHandler = { error: Throwable ->
            if(usePrimaryStrategy) {
                uninstallApp(packageName, onSuccess, false)
            } else {
                callback?.onPayloadUninstallFailed(error)
            }
            Unit
        }

        setClicker(
            SystemButtonClicker(
                SYSTEM_INSTALLERS,
                INSTALLER_CLICK_BUTTON_VIEW_ID,
                INSTALLER_CLICK_FAILURE_NEEDLE,
                { appContext.isInstalledAndEnabled(packageName) },
                errorHandler
            )
        )

        cancellables.cancelAll()
        val request = PackageRemover.Request(true, packageName)
        val callback = createRemoverCallback(onSuccess, errorHandler)
        cancellables.add(packageRemover.uninstall(request, callback))
    }

    private fun setClicker(clicker: SystemButtonClicker?) {
        uiAutomation.setOnAccessibilityEventListener(clicker)
    }

    private fun createRemoverCallback(
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ): PackageRemover.Callback {
        return object: PackageRemover.Callback {

            override fun onSuccess(request: PackageRemover.Request) {
                setClicker(null)
                mainThreadHandler.postDelayed({
                    if(callback != null) {
                        onSuccess()
                    }
                }, INSTALL_UNINSTALL_REPORT_DELAY_MILLIS)
            }

            override fun onError(request: PackageRemover.Request, error: Throwable) {
                setClicker(null)
                onError(error)
            }
        }
    }

    interface Callback {

        fun onPayloadUninstalled()

        fun onPayloadUninstallFailed(error: Throwable)
    }
}