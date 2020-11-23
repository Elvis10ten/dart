package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.automation.UiAutomationConnectTimeoutException
import com.fluentbuild.apollo.automation.UiAutomationConnector
import com.fluentbuild.apollo.automation.UiAutomationServiceFailedException
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.helpers.PayloadInstaller
import com.fluentbuild.apollo.runtime.helpers.PayloadUnInstaller
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto

class InstallStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val payloadInstaller: PayloadInstaller,
    private val payloadUnInstaller: PayloadUnInstaller,
    private val uiAutomationConnector: UiAutomationConnector,
    callback: Callback
): Stage(callback), PayloadInstaller.Callback, PayloadUnInstaller.Callback {

    private var connectedUiAutomation: UiAutomation? = null

    override fun onStart() {
        connectUiAutomation()
    }

    override fun onStop() {
        release()
    }

    override fun onRetry(throwable: Throwable) {
        release()
        connectUiAutomation()
    }

    override fun getMaxRetries() = 3

    override fun getAction() = "Installing"

    private fun connectUiAutomation() {
        updateUi(UiData(appContext.getString(R.string.runtime_installing_work)))
        uiAutomationConnector.connect(_callback = object: UiAutomationConnector.Callback {

            override fun onConnected(uiAutomation: UiAutomation) {
                connectedUiAutomation = uiAutomation
                payloadUnInstaller.uninstall(this@InstallStage, uiAutomation)
            }

            override fun onConnectTimeout() {
                onError(UiAutomationConnectTimeoutException())
            }

            override fun onServiceError() {
                onError(UiAutomationServiceFailedException())
            }
        })
    }

    override fun onPayloadInstalled() {
        onComplete(RuntimeState.PreparingRun(work))
    }

    override fun onPayloadInstallFailed(error: Throwable) {
        onError(error)
    }

    override fun onPayloadUninstalled() {
        payloadInstaller.install(this, connectedUiAutomation!!)
    }

    override fun onPayloadUninstallFailed(error: Throwable) {
        onError(error)
    }

    private fun release() {
        payloadUnInstaller.cancel()
        payloadInstaller.cancel()
        disconnectUiAutomation()
    }

    private fun disconnectUiAutomation() {
        connectedUiAutomation?.disconnect()
        connectedUiAutomation = null
    }
}
