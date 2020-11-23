package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetTestDetailsRequestProto.*
import com.fluentbuild.apollo.work.GetTestDetailsResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.TestQuery
import com.fluentbuild.workserver.work.store.TestStore
import io.grpc.stub.StreamObserver

class GetTestDetailsUseCase(
    private val testStore: TestStore,
    private val logger: Logger
) {

    fun run(
        request: GetTestDetailsRequest,
        responseObserver: StreamObserver<GetTestDetailsResponse>
    ) {
        try {
            val query = TestQuery(request.workKey, request.deviceKey, request.testKey)
            val testDetails = testStore.getTestDetails(query)
            logger.d("Found test details for work: %s", request.workKey)

            val response = GetTestDetailsResponse.newBuilder()
                .setDetails(testDetails)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting test details")
            responseObserver.onError(e)
        }
    }
}