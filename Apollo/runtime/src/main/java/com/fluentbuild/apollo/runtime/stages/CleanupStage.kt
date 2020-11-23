package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.automation.UiAutomationConnectTimeoutException
import com.fluentbuild.apollo.automation.UiAutomationConnector
import com.fluentbuild.apollo.automation.UiAutomationServiceFailedException
import com.fluentbuild.apollo.runner.server.CancelSignal
import com.fluentbuild.apollo.foundation.async.Cancellables
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.helpers.PayloadUnInstaller
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkFinalizer
import com.fluentbuild.apollo.work.WorkProto

class CleanupStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val uiAutomationConnector: UiAutomationConnector,
    private val workFinalizer: WorkFinalizer,
    private val cancelSignal: CancelSignal,
    private val payloadUnInstaller: PayloadUnInstaller,
    callback: Callback
): Stage(callback), WorkFinalizer.Callback, PayloadUnInstaller.Callback {

    private var connectedUiAutomation: UiAutomation? = null
    private val cancellables = Cancellables()

    override fun onStart() {
        cancelSignal.send()
        finalizeWork()
    }

    override fun onStop() {
        release()
    }

    override fun onRetry(throwable: Throwable) {
        release()
        finalizeWork()
    }

    private fun connectUiAutomation() {
        updateUi(UiData(appContext.getString(R.string.runtime_cleaning_up_work)))
        uiAutomationConnector.connect(_callback = object: UiAutomationConnector.Callback {

            override fun onConnected(uiAutomation: UiAutomation) {
                connectedUiAutomation = uiAutomation
                payloadUnInstaller.uninstall(this@CleanupStage, uiAutomation)
            }

            override fun onConnectTimeout() {
                onCleanupError(UiAutomationConnectTimeoutException())
            }

            override fun onServiceError() {
                onCleanupError(UiAutomationServiceFailedException())
            }
        })
    }

    private fun release() {
        payloadUnInstaller.cancel()
        cancellables.cancelAll()
        disconnectUiAutomation()
    }

    override fun onPayloadUninstalled() {
        onComplete(RuntimeState.Idle)
    }

    override fun onPayloadUninstallFailed(error: Throwable) {
        onCleanupError(error)
    }

    private fun disconnectUiAutomation() {
        connectedUiAutomation?.disconnect()
        connectedUiAutomation = null
    }

    private fun finalizeWork() {
        cancellables.add(workFinalizer.finalize(this))
    }

    override fun onWorkFinalized() {
        connectUiAutomation()
    }

    override fun onWorkFinalizeError(error: Throwable) {
        onCleanupError(error)
    }

    private fun onCleanupError(error: Throwable) {
        if(canRetry(error)) {
            onError(error)
        } else {
            // If we can't retry anymore, ignore cleanup now. It will be  cleaned up later.
            onComplete(RuntimeState.Idle)
        }
    }

    override fun getMaxRetries() = 5

    override fun getAction() = "Cleaning up"
}
