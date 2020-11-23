package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.FileTransferProto
import com.fluentbuild.apollo.work.SendFileWrapperProto.*
import com.fluentbuild.apollo.work.WorkProto.*
import com.fluentbuild.apollo.work.ft.FtLogger
import com.fluentbuild.apollo.work.ft.Storage
import com.fluentbuild.apollo.work.ft.toProto
import com.fluentbuild.workserver.services.ft.PayloadUploader
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.WorkStore
import io.grpc.stub.CallStreamObserver
import io.grpc.stub.StreamObserver
import java.io.File

class DownloadPayloadUseCase(
    private val storage: Storage,
    private val ftLogger: FtLogger,
    private val workStore: WorkStore,
    private val logger: Logger
) {

    fun run(
        work: Work,
        responseObserver: StreamObserver<SendFileWrapper>
    ): StreamObserver<FileTransferProto.ChunkRequest> {
        val fileMeta = File(work.payload.url).toProto()
        return PayloadUploader(
            work,
            fileMeta,
            storage,
            responseObserver as CallStreamObserver,
            ftLogger
        ).run()
    }
}