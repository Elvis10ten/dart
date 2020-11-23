package com.fluentbuild.workserver.services.ft

import com.fluentbuild.apollo.work.FileTransferProto.*
import com.fluentbuild.apollo.work.SendFileWrapperProto.SendFileWrapper
import com.fluentbuild.apollo.work.WorkProto.Work
import com.fluentbuild.apollo.work.ft.AWAIT_READY_TIMEOUT_MILLIS
import com.fluentbuild.apollo.work.ft.FtLogger
import com.fluentbuild.apollo.work.ft.Storage
import com.fluentbuild.apollo.work.ft.com.fluentbuild.apollo.work.ft.FileSender
import com.fluentbuild.apollo.work.ft.createSendFileWrapper
import com.fluentbuild.workserver.utils.ConditionalWatcher
import io.grpc.stub.*
import java.util.concurrent.TimeoutException

class PayloadUploader(
    private val work: Work,
    private val payloadFileMeta: FileMeta,
    private val storage: Storage,
    private val responseObserver: CallStreamObserver<SendFileWrapper>,
    private val logger: FtLogger
) {

    fun run(): StreamObserver<ChunkRequest> {
        val transport = object: FileSender.Transport {

            override fun sendManifest(manifest: Manifest) {
                responseObserver.onNext(manifest.createSendFileWrapper())
            }

            override fun sendChunk(chunkResponse: ChunkResponse) {
                responseObserver.onNext(chunkResponse.createSendFileWrapper())
            }

            override fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int) {
                logger.i { "Progress: $progressPercent, curFileIndex: $curFileIndex, filesCount: $filesCount" }
            }

            override fun awaitReady() {
                ConditionalWatcher(
                    { responseObserver.isReady },
                    { TimeoutException("Timed out waiting for transport readiness") },
                    AWAIT_READY_TIMEOUT_MILLIS
                )
            }

        }

        val fileSender = FileSender(work.key, transport, storage, listOf(payloadFileMeta), logger)
        fileSender.init()

        return object: StreamObserver<ChunkRequest> {

            override fun onNext(chunkRequest: ChunkRequest) {
                logger.i { "Payload upload chunk request: $chunkRequest" }
                fileSender.handleChunkRequest(chunkRequest)
            }

            override fun onError(t: Throwable) {
                fileSender.cancel()
                logger.i { "Payload upload error!" }
                throw t
            }

            override fun onCompleted() {
                fileSender.cancel()
                logger.i { "Payload upload completed!" }
                responseObserver.onCompleted()
            }
        }
    }
}