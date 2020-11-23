package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.GetWorkDevicesRequestProto.*
import com.fluentbuild.apollo.work.GetWorkDevicesResponseProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.WorkStore
import io.grpc.stub.StreamObserver

class GetWorkDevicesUseCase(
    private val workStore: WorkStore,
    private val logger: Logger
) {

    fun run(
        request: GetWorkDevicesRequest,
        responseObserver: StreamObserver<GetWorkDevicesResponse>
    ) {
        try {
            val devices = workStore.getWorkDevices(request.workKey)
            logger.d("Found %s devices for work: %s", devices.size, request.workKey)

            val response = GetWorkDevicesResponse.newBuilder()
                .addAllDevices(devices)
                .build()

            responseObserver.onNext(response)
            responseObserver.onCompleted()
        } catch (e: Exception) {
            logger.e(e, "Error getting work devices")
            responseObserver.onError(e)
        }
    }
}