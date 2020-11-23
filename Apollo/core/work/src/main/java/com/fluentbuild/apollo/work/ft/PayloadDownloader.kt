package com.fluentbuild.apollo.work.ft

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import com.fluentbuild.apollo.work.*
import io.grpc.stub.ClientResponseObserver
import com.fluentbuild.apollo.work.SendFileWrapperProto.*
import com.fluentbuild.apollo.work.FileTransferProto.*
import io.grpc.Status
import io.grpc.stub.ClientCallStreamObserver
import timber.log.Timber

class PayloadDownloader(
    private val storage: Storage,
    private val workService: WorkServiceGrpc.WorkServiceStub,
    private val mainThreadHandler: Handler,
    private val logger: FtLogger
) {

    @MainThread
    fun download(_callback: FtCallback<Unit>): Cancellable {
        requireMainThread()
        Timber.i("Downloading!")
        var observer: ClientCallStreamObserver<ChunkRequest>? = null
        var callback: FtCallback<Unit>? = _callback

        val transport = object: FileReceiver.Transport {

            override fun requestFile(chunkRequest: ChunkRequest) {
                observer!!.onNext(chunkRequest)
            }

            override fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
                mainThreadHandler.post {
                    callback?.onFtProgressUpdate(curFileIndex, progressPercent, filesCount)
                }
            }

            override fun completeTransfer() {
                observer!!.onCompleted()
            }
        }
        val fileReceiver = FileReceiver(storage, transport, logger)

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

        observer = workService.downloadPayload(
            object: ClientResponseObserver<ChunkRequest, SendFileWrapper> {

                override fun beforeStart(requestStream: ClientCallStreamObserver<ChunkRequest>) {}

                override fun onNext(wrapper: SendFileWrapper) {
                    requireNotMainThread()
                    when {
                        wrapper.isForManifest() -> {
                            runSafely {
                                Timber.i("Manifest received: %s", wrapper.manifest)
                                fileReceiver.handleManifest(wrapper.manifest)
                            }
                        }
                        wrapper.isForChunkResponse() -> {
                            runSafely {
                                Timber.i("Chunk received: %s", wrapper.chunkResponse.range)
                                fileReceiver.handleChunkResponse(wrapper.chunkResponse)
                            }
                        }
                        else -> {
                            val error = Status.INVALID_ARGUMENT
                                .withDescription("Ambiguous SendFileWrapper")
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
                    mainThreadHandler.post {
                        observer = null
                        callback?.onFtComplete(Unit)
                    }
                }

            }) as ClientCallStreamObserver

        return object: Cancellable {

            override fun cancel() {
                requireMainThread()
                callback = null
                fileReceiver.cancel()
                observer?.cancel("Request cancelled", null)
                observer = null
            }
        }
    }
}