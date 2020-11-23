package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetTestLogsRequestProto.*
import com.fluentbuild.apollo.work.GetTestLogsResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.TestQuery
import com.fluentbuild.workserver.work.store.TestStore
import io.grpc.stub.StreamObserver

class GetTestLogsUseCase(
    private val testStore: TestStore,
    private val logger: Logger
) {

    fun run(
        request: GetTestLogsRequest,
        responseObserver: StreamObserver<GetTestLogsResponse>
    ) {
        try {
            val query = TestQuery(request.workKey, request.deviceKey, request.testKey)
            val testLogs = testStore.getTestLogs(query, request.offset)
            logger.d("Found test logs for work: %s", request.workKey)

            val response = GetTestLogsResponse.newBuilder()
                .addAllLines(testLogs.lines)
                .setNextOffset(testLogs.nextOffset)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting test logs")
            responseObserver.onError(e)
        }
    }
}