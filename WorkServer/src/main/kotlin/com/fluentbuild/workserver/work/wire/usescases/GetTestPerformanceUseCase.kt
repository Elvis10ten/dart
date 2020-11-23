package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetTestPerformanceRequestProto.*
import com.fluentbuild.apollo.work.GetTestPerformanceResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.TestQuery
import com.fluentbuild.workserver.work.store.TestStore
import io.grpc.stub.StreamObserver

class GetTestPerformanceUseCase(
    private val testStore: TestStore,
    private val logger: Logger
) {

    fun run(
        request: GetTestPerformanceRequest,
        responseObserver: StreamObserver<GetTestPerformanceResponse>
    ) {
        try {
            val query = TestQuery(request.workKey, request.deviceKey, request.testKey)
            val performanceReport = testStore.getTestPerformanceReport(query)
            logger.d("Found test performance report for work: %s", request.workKey)

            val response = GetTestPerformanceResponse.newBuilder()
                .setPerformanceReport(performanceReport)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting test performance report")
            responseObserver.onError(e)
        }
    }
}