package com.fluentbuild.apollo.work.ft

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.ConditionalWatcher
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import com.fluentbuild.apollo.work.*
import io.grpc.stub.ClientResponseObserver
import com.fluentbuild.apollo.work.SendFileWrapperProto.*
import com.fluentbuild.apollo.work.FileTransferProto.*
import com.fluentbuild.apollo.work.UploadResultResponseProto.*
import com.fluentbuild.apollo.work.WorkSummaryProto.*
import com.fluentbuild.apollo.work.ft.com.fluentbuild.apollo.work.ft.FileSender
import io.grpc.Status
import io.grpc.stub.ClientCallStreamObserver
import timber.log.Timber
import java.util.concurrent.TimeoutException

class ResultsUploader(
    private val storage: Storage,
    private val work: WorkProto.Work,
    private val workFiles: WorkFiles,
    private val workService: WorkServiceGrpc.WorkServiceStub,
    private val mainThreadHandler: Handler,
    private val logger: FtLogger
) {

    @MainThread
    fun upload(_callback: FtCallback<WorkSummary>): Cancellable {
        requireMainThread()
        Timber.i("Uploading!")
        var observer: ClientCallStreamObserver<SendFileWrapper>? = null
        var callback: FtCallback<WorkSummary>? = _callback

        val transport = getTransport({ observer }, { callback })
        val fileSender = FileSender(work.key, transport, storage, getFilesMeta(), logger)
        var workSummary: WorkSummary? = null

        val reportError = { error: Throwable ->
            Timber.e(error, "Error uploading")
            mainThreadHandler.post {
                observer = null
                callback?.onFtError(error)
            }
        }

        val runSafely = { action: () -> Unit ->
            try {
                action()
            } catch (error: Throwable) {
                reportError(error)
            }
        }

        observer = workService.uploadResult(
            object: ClientResponseObserver<SendFileWrapper, UploadResultResponse> {

                override fun beforeStart(requestStream: ClientCallStreamObserver<SendFileWrapper>) {}

                override fun onNext(uploadResponse: UploadResultResponse) {
                    requireNotMainThread()
                    Timber.d("Upload response received: %s", uploadResponse)

                    when {
                        uploadResponse.isForChunkRequest() -> {
                            runSafely {
                                fileSender.handleChunkRequest(uploadResponse.chunkRequest)
                            }
                        }
                        uploadResponse.isForWorkSummary() -> {
                            workSummary = uploadResponse.workSummary
                        }
                        else -> {
                            val error = Status.INVALID_ARGUMENT
                                .withDescription("Ambiguous upload response")
                                .asException()
                            observer?.onError(error)
                            reportError(error)
                        }
                    }
                }

                override fun onError(error: Throwable) {
                    Timber.e(error, "Error received")
                    reportError(error)
                }

                override fun onCompleted() {
                    Timber.i("On completed received")
                    runSafely {
                        mainThreadHandler.post {
                            observer = null
                            callback?.onFtComplete(workSummary!!)
                        }
                    }
                }

            }
        ) as ClientCallStreamObserver

        runSafely {
            fileSender.init()
        }

        return object: Cancellable {

            override fun cancel() {
                requireMainThread()
                callback = null
                fileSender.cancel()
                observer?.cancel("Request cancelled", null)
                observer = null
            }
        }
    }

    private fun getTransport(
        observerProvider: () -> ClientCallStreamObserver<SendFileWrapper>?,
        callbackProvider: () -> FtCallback<WorkSummary>?
    ): FileSender.Transport {
        return object: FileSender.Transport {

            override fun sendManifest(manifest: Manifest) {
                observerProvider()!!.onNext(manifest.createSendFileWrapper())
            }

            override fun sendChunk(chunkResponse: ChunkResponse) {
                observerProvider()!!.onNext(chunkResponse.createSendFileWrapper())
            }

            override fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
                mainThreadHandler.post {
                    callbackProvider()?.onFtProgressUpdate(curFileIndex, progressPercent, filesCount)
                }
            }

            override fun awaitReady() {
                ConditionalWatcher(
                    { observerProvider()!!.isReady },
                    { TimeoutException("Timed out waiting for transport readiness") },
                    AWAIT_READY_TIMEOUT_MILLIS
                )
            }
        }
    }

    private fun getFilesMeta(): List<FileMeta> {
        val filesMeta = mutableListOf<FileMeta>()

        workFiles.resultsDir.listFilesOnly().forEach { file ->
            filesMeta.add(file.toProto())
        }

        return filesMeta
    }
}