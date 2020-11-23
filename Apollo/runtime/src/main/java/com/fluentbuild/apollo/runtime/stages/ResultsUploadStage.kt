package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.work.tests.RunReportProto.*
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto.Work
import com.fluentbuild.apollo.work.WorkSummaryProto
import com.fluentbuild.apollo.work.ft.FtCallback
import com.fluentbuild.apollo.work.ft.ResultsUploader

class ResultsUploadStage(
    private val appContext: Context,
    override val work: Work,
    private val runReport: RunReport,
    private val resultsUploader: ResultsUploader,
    callback: Callback
): Stage(callback), FtCallback<WorkSummaryProto.WorkSummary> {

    private var uploadCancellable: Cancellable? = null

    override fun onStart() {
        uploadResults()
    }

    private fun uploadResults() {
        updateUi(UiData(appContext.getString(R.string.runtime_upload_results_started)))
        uploadCancellable = resultsUploader.upload(this)
    }

    override fun onFtProgressUpdate(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
        updateUi(UiData(appContext.getString(
            R.string.runtime_uploading_results,
            curFileIndex,
            filesCount,
            progressPercent
        )))
    }

    override fun onFtComplete(result: WorkSummaryProto.WorkSummary) {
        onComplete(RuntimeState.CleaningUpWork(
            work,
            runReport,
            result
        ))
    }

    override fun onFtError(throwable: Throwable) {
        onError(throwable)
    }

    override fun onStop() {
        cancelUpload()
    }

    override fun onRetry(throwable: Throwable) {
        cancelUpload()
        uploadResults()
    }

    override fun getMaxRetries() = 5

    override fun getAction() = "Uploading Result"

    private fun cancelUpload() {
        uploadCancellable?.cancel()
        uploadCancellable = null
    }
}
