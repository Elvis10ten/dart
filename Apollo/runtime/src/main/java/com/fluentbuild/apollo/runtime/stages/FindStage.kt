package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.startup.PreloadedWorkProvider
import com.fluentbuild.apollo.work.WorkFinder
import com.fluentbuild.apollo.work.WorkProto

class FindStage(
    private val appContext: Context,
    private val workFinder: WorkFinder,
    callback: Callback
): Stage(callback), WorkFinder.Callback {

    private var findWorkCancellable: Cancellable? = null

    override fun onStart() {
        findWork()
    }

    private fun findWork() {
        updateUi(UiData(appContext.getString(R.string.runtime_finding_work)))
        val preloadedWork = PreloadedWorkProvider.pop()
        if(preloadedWork != null) {
            return onComplete(RuntimeState.DownloadingPayload(preloadedWork))
        }

        findWorkCancellable = workFinder.find(this)
    }

    private fun cancelWorkFindRequest() {
        findWorkCancellable?.cancel()
        findWorkCancellable = null
    }

    override fun onStop() {
        cancelWorkFindRequest()
    }

    override fun onRetry(throwable: Throwable) {
        cancelWorkFindRequest()
        findWork()
    }

    override fun getMaxRetries() = 3

    override fun getAction() = "Finding"

    override fun onWorkFound(work: WorkProto.Work) {
        onComplete(RuntimeState.DownloadingPayload(work))
    }

    override fun onFindWorkError(error: Throwable) {
        onError(error)
    }
}
