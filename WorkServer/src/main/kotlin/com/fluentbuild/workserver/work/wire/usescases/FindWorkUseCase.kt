package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.FindWorkRequestProto.*
import com.fluentbuild.apollo.work.FindWorkResponseProto.*
import com.fluentbuild.apollo.work.WorkProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.WorkStore
import io.grpc.stub.StreamObserver

class FindWorkUseCase(
    private val workStore: WorkStore,
    private val logger: Logger
) {

    fun run(
        request: FindWorkRequest,
        responseObserver: StreamObserver<FindWorkResponse>
    ): Work {
        val work = workStore.getAvailableWork()!!
        Thread.sleep(5000)
        logger.d("Found work: %s", work)

        workStore.upsertWorkDevices(work.key, listOf(request.deviceProperties))
        val response = FindWorkResponse.newBuilder()
            .setWork(work)
            .build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
        return work
    }
}