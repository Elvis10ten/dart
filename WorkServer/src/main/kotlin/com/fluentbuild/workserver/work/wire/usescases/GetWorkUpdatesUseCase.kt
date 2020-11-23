package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetWorkUpdatesRequestProto.*
import com.fluentbuild.apollo.work.GetWorkUpdatesResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import com.fluentbuild.workserver.work.store.TestStore
import io.grpc.stub.StreamObserver

class GetWorkUpdatesUseCase(
    private val testStore: TestStore,
    private val logger: Logger
) {

    fun run(
        request: GetWorkUpdatesRequest,
        responseObserver: StreamObserver<GetWorkUpdatesResponse>
    ) {
        try {
            val testUpdates = testStore.getTestUpdates(DeviceWorkQuery(request.workKey, request.deviceKey))
            logger.d("Found %s updates for work: %s", testUpdates.size, request.workKey)

            val response = GetWorkUpdatesResponse.newBuilder()
                .addAllResults(testUpdates)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting work updates")
            responseObserver.onError(e)
        }
    }
}