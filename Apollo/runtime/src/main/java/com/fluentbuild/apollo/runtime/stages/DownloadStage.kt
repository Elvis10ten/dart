package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.ft.FtCallback
import com.fluentbuild.apollo.work.ft.PayloadDownloader

class DownloadStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val downloader: PayloadDownloader,
    callback: Callback
): Stage(callback), FtCallback<Unit> {

    private var downloadCancellable: Cancellable? = null

    override fun onStart() {
        downloadPayload()
    }

    override fun onRetry(throwable: Throwable) {
        cancelDownloadRequest()
        downloadPayload()
    }

    private fun downloadPayload() {
        updateUi(UiData(appContext.getString(R.string.runtime_download_work_payload_started)))
        downloadCancellable = downloader.download(this)
    }

    private fun cancelDownloadRequest() {
        downloadCancellable?.cancel()
        downloadCancellable = null
    }

    override fun onFtProgressUpdate(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
        updateUi(UiData(appContext.getString(
            R.string.runtime_downloading_work_payload,
            curFileIndex,
            filesCount,
            progressPercent
        )))
    }

    override fun onFtError(throwable: Throwable) {
        onError(throwable)
    }

    override fun onFtComplete(result: Unit) {
        onComplete(RuntimeState.UnbundlingPayload(work))
    }

    override fun onStop() {
        cancelDownloadRequest()
    }

    override fun getAction() = "Downloading"

    override fun getMaxRetries() = 3
}
