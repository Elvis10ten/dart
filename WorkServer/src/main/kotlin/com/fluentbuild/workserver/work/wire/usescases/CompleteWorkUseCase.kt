package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.SendFileWrapperProto.SendFileWrapper
import com.fluentbuild.apollo.work.UploadResultResponseProto.UploadResultResponse
import com.fluentbuild.apollo.work.WorkSummaryProto
import com.fluentbuild.apollo.work.ft.FtLogger
import com.fluentbuild.apollo.work.ft.Storage
import com.fluentbuild.workserver.services.ft.ResultsDownloader
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.reports.ResultsProcessor
import io.grpc.stub.CallStreamObserver
import io.grpc.stub.StreamObserver
import java.io.File

class CompleteWorkUseCase(
    private val ftLogger: FtLogger,
    private val logger: Logger,
    private val storage: Storage,
    private val resultsProcessor: ResultsProcessor
) {

    fun run(
        responseObserver: StreamObserver<UploadResultResponse>
    ): StreamObserver<SendFileWrapper> {
        val onDownloadComplete = { file: File ->
            resultsProcessor.process(file)
            file.delete() // todo

            val workSummary = getWorkSummary()
            val response = UploadResultResponse.newBuilder()
                .setWorkSummary(workSummary)
                .build()
            responseObserver.onNext(response)
            responseObserver.onCompleted()
        }

        return ResultsDownloader(
            onDownloadComplete,
            storage,
            responseObserver as CallStreamObserver,
            ftLogger
        ).run()
    }

    private fun getWorkSummary(): WorkSummaryProto.WorkSummary {
        return WorkSummaryProto.WorkSummary.newBuilder()
            .setCurrencySymbol("$")
            .setDurationMinutes(2)
            .setEarnedAmount(0.002)
            .build()
    }
}