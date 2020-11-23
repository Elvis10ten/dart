package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.foundation.async.Cancellables
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.runner.server.ResultsBundler
import com.fluentbuild.apollo.work.tests.RunReportProto.*

class ResultsBundleStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val runReport: RunReport,
    private val resultsBundler: ResultsBundler,
    callback: Callback
): Stage(callback), ResultsBundler.Callback {

    private val cancellables = Cancellables()

    override fun onStart() {
        bundleResults()
    }

    override fun onStop() {
        cancellables.cancelAll()
    }

    override fun onRetry(throwable: Throwable) {
        cancellables.cancelAll()
        bundleResults()
    }

    private fun bundleResults() {
        updateUi(UiData(appContext.getString(R.string.runtime_bundling_results)))
        cancellables.add(resultsBundler.bundle(this))
    }

    override fun onResultsBundled() {
        onComplete(RuntimeState.UploadingResults(work, runReport))
    }

    override fun onBundleResultsError(error: Exception) {
        onError(error)
    }

    override fun getMaxRetries() = 3

    override fun getAction() = "Bundling Results"
}
