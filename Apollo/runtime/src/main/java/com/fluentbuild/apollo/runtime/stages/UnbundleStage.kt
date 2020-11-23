package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.PayloadUnbundler

class UnbundleStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val payloadUnbundler: PayloadUnbundler,
    callback: Callback
): Stage(callback), PayloadUnbundler.Callback {

    private var unbundleCancellable: Cancellable? = null

    override fun onStart() {
        unbundlePayload()
    }

    override fun onStop() {
        cancelUnbundlePayloadRequest()
    }

    override fun onRetry(throwable: Throwable) {
        cancelUnbundlePayloadRequest()
        unbundlePayload()
    }

    private fun unbundlePayload() {
        updateUi(UiData(appContext.getString(R.string.runtime_unbundling_payload)))
        unbundleCancellable = payloadUnbundler.unbundle(this)
    }

    private fun cancelUnbundlePayloadRequest() {
        unbundleCancellable?.cancel()
        unbundleCancellable = null
    }

    override fun getMaxRetries() = 3

    override fun getAction() = "Unbundling"

    override fun onPayloadUnbundled() {
        onComplete(RuntimeState.InstallingWork(work))
    }

    override fun onUnbundlePayloadError(error: Throwable) {
        onError(error)
    }
}
