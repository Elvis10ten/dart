package com.fluentbuild.workserver.services.ft

import com.fluentbuild.apollo.work.FileTransferProto.*
import com.fluentbuild.apollo.work.SendFileWrapperProto.*
import com.fluentbuild.apollo.work.UploadResultResponseProto.*
import com.fluentbuild.apollo.work.WorkSummaryProto.*
import com.fluentbuild.apollo.work.ft.*
import com.fluentbuild.apollo.work.ft.isForManifest
import com.fluentbuild.workserver.Injector
import com.fluentbuild.workserver.services.work.WorkSummaryProvider
import io.grpc.Status
import io.grpc.stub.CallStreamObserver
import io.grpc.stub.StreamObserver
import java.io.File
import java.util.*

class ResultsDownloader(
    private val onDownloadComplete: (File) -> Unit,
    private val storage: Storage,
    private val responseObserver: CallStreamObserver<UploadResultResponse>,
    private val logger: FtLogger
) {

    private val resultFile = File(Injector.baseDir, "rb.b")

    fun run(): StreamObserver<SendFileWrapper> {
        val transport = object: FileReceiver.Transport {

            override fun requestFile(chunkRequest: ChunkRequest) {
                responseObserver.onNext(chunkRequest.createUploadResponse())
            }

            override fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
                logger.i { "Progress: $curFileIndex, curFileIndex: $curFileIndex, filesCount: $filesCount" }
            }

            override fun completeTransfer() {
                onDownloadComplete(resultFile)
            }
        }

        val fileReceiver = FileReceiver(storage, transport, logger)
        return object: StreamObserver<SendFileWrapper> {

            override fun onNext(sendFileWrapper: SendFileWrapper) {
                logger.i { "SendFileWrapper received: $sendFileWrapper" }
                when {
                    sendFileWrapper.isForManifest() -> {
                        fileReceiver.handleManifest(sendFileWrapper.manifest)
                    }
                    sendFileWrapper.isForChunkResponse() -> {
                        fileReceiver.handleChunkResponse(sendFileWrapper.chunkResponse)
                    }
                    else -> {
                        val error = Status.INVALID_ARGUMENT
                            .withDescription("Ambiguous SendFileWrapper")
                            .asException()
                        responseObserver.onError(error)
                    }
                }
            }

            override fun onError(t: Throwable) {
                fileReceiver.cancel()
                logger.i { "Results download error!" }
                throw t
            }

            override fun onCompleted() {
                fileReceiver.cancel()
                logger.i { "Results download completed!" }
            }
        }
    }
}

private fun ChunkRequest.createUploadResponse(): UploadResultResponse {
    return UploadResultResponse.newBuilder()
        .setChunkRequest(this)
        .build()
}