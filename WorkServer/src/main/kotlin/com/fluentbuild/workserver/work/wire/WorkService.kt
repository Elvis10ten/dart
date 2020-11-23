package com.fluentbuild.workserver.work.wire

import com.fluentbuild.apollo.work.*
import com.fluentbuild.workserver.Injector
import com.fluentbuild.workserver.work.store.TestStore
import io.grpc.stub.StreamObserver

class WorkService(
    private val useCaseProvider: UseCaseProvider,
    private val testStore: TestStore
): WorkServiceGrpc.WorkServiceImplBase() {

    override fun getWorkDevices(
        request: GetWorkDevicesRequestProto.GetWorkDevicesRequest,
        responseObserver: StreamObserver<GetWorkDevicesResponseProto.GetWorkDevicesResponse>
    ) {
        useCaseProvider.provideGetWorkDevicesUseCase().run(request, responseObserver)
    }

    override fun getWorkUpdates(
        request: GetWorkUpdatesRequestProto.GetWorkUpdatesRequest,
        responseObserver: StreamObserver<GetWorkUpdatesResponseProto.GetWorkUpdatesResponse>
    ) {
        useCaseProvider.provideGetWorkUpdatesUseCase().run(request, responseObserver)
    }

    override fun getWork(
        request: GetWorkRequestProto.GetWorkRequest,
        responseObserver: StreamObserver<GetWorkResponseProto.GetWorkResponse>
    ) {
        useCaseProvider.provideGetWorkUseCase().run(request, responseObserver)
    }

    override fun getTestDetails(
        request: GetTestDetailsRequestProto.GetTestDetailsRequest,
        responseObserver: StreamObserver<GetTestDetailsResponseProto.GetTestDetailsResponse>
    ) {
        useCaseProvider.provideGetTestDetailsUseCase().run(request, responseObserver)
    }

    override fun getTestPerformance(
        request: GetTestPerformanceRequestProto.GetTestPerformanceRequest,
        responseObserver: StreamObserver<GetTestPerformanceResponseProto.GetTestPerformanceResponse>
    ) {
        useCaseProvider.provideGetTestPerformanceUseCase().run(request, responseObserver)
    }

    override fun getTestLogs(
        request: GetTestLogsRequestProto.GetTestLogsRequest,
        responseObserver: StreamObserver<GetTestLogsResponseProto.GetTestLogsResponse>
    ) {
        useCaseProvider.provideGetTestLogsUseCase().run(request, responseObserver)
    }

    override fun downloadPayload(
        responseObserver: StreamObserver<SendFileWrapperProto.SendFileWrapper>
    ): StreamObserver<FileTransferProto.ChunkRequest> {
        return useCaseProvider.provideDownloadPayloadUseCase().run(work, responseObserver)
    }

    override fun uploadResult(
        responseObserver: StreamObserver<UploadResultResponseProto.UploadResultResponse>
    ): StreamObserver<SendFileWrapperProto.SendFileWrapper> {
        return useCaseProvider.provideCompleteWorkUseCase().run(responseObserver)
    }

    override fun delineate(
        request: DelineateWorkRequestProto.DelineateWorkRequest,
        responseObserver: StreamObserver<DelineateWorkResponseProto.DelineateWorkResponse>
    ) {
        if(request.type == DelineateWorkRequestProto.DelineateWorkRequest.Type.CHECK_POINT) {
            useCaseProvider.provideUpsertTestUpdatesUseCase().run(request)
        } else {
            println("Sent progress: " + request.pulse.toString())
        }

        val workUpdates = WorkUpdatesProto.WorkUpdates.newBuilder()
            .build()
        val response = DelineateWorkResponseProto.DelineateWorkResponse.newBuilder()
            .setWorkUpdates(workUpdates)
            .build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    private lateinit var work: WorkProto.Work

    override fun find(
        request: FindWorkRequestProto.FindWorkRequest,
        responseObserver: StreamObserver<FindWorkResponseProto.FindWorkResponse>
    ) {
        work = useCaseProvider.provideFindWorkUseCase().run(request, responseObserver)
    }
}