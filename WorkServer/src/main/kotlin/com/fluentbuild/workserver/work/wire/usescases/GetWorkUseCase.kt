package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetWorkRequestProto.*
import com.fluentbuild.apollo.work.GetWorkResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import com.fluentbuild.workserver.work.store.WorkStore
import io.grpc.stub.StreamObserver

class GetWorkUseCase(
    private val workStore: WorkStore,
    private val logger: Logger
) {

    fun run(
        request: GetWorkRequest,
        responseObserver: StreamObserver<GetWorkResponse>
    ) {
        try {
            val work = workStore.getWork(request.workKey)
            logger.d("Found work for key: %s", request.workKey)

            val response = GetWorkResponse.newBuilder()
                .setWork(work)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting work")
            responseObserver.onError(e)
        }
    }
}