package com.fluentbuild.apollo.work

import android.os.Handler
import com.fluentbuild.apollo.foundation.async.Cancellable
import io.grpc.stub.ClientCallStreamObserver
import io.grpc.stub.ClientResponseObserver
import timber.log.Timber
import com.fluentbuild.apollo.work.DelineateWorkRequestProto.DelineateWorkRequest
import com.fluentbuild.apollo.work.DelineateWorkResponseProto.DelineateWorkResponse
import com.fluentbuild.apollo.work.WorkCheckpointProto.WorkCheckpoint
import com.fluentbuild.apollo.work.tests.AtomicResultProto.AtomicResult

class WorkerStateReporter(
    private val mainThreadHandler: Handler,
    private val workService: WorkServiceGrpc.WorkServiceStub,
    private val deviceKeyProvider: DeviceKeyProvider
) {

    var completeCallback: (() -> Unit)? = null

    fun sendPulse(work: WorkProto.Work): Cancellable {
        val workPulse = WorkPulseProto.WorkPulse.newBuilder()
            .build()
        val sendPulseRequest = DelineateWorkRequest.newBuilder()
            .setType(DelineateWorkRequest.Type.PULSE)
            .setWorkKey(work.key)
            .setDeviceKey(deviceKeyProvider.get())
            .setPulse(workPulse)
            .build()
        return report(sendPulseRequest)
    }

    fun sendCheckpoint(work: WorkProto.Work, results: List<AtomicResult>): Cancellable {
        val checkpoint = WorkCheckpoint.newBuilder()
            .addAllResults(results)
            .build()
        val sendResultsRequest = DelineateWorkRequest.newBuilder()
            .setType(DelineateWorkRequest.Type.CHECK_POINT)
            .setWorkKey(work.key)
            .setDeviceKey(deviceKeyProvider.get())
            .setCheckpoint(checkpoint)
            .build()
        return report(sendResultsRequest)
    }

    private fun report(request: DelineateWorkRequest): Cancellable {
        var isCancelled = false
        var callObserver: ClientCallStreamObserver<DelineateWorkRequest>? = null

        workService.delineate(
            request,
            object: ClientResponseObserver<DelineateWorkRequest, DelineateWorkResponse> {

                override fun beforeStart(requestStream: ClientCallStreamObserver<DelineateWorkRequest>) {
                    mainThreadHandler.post {
                        if(isCancelled) {
                            requestStream.cancel("Request already cancelled", null)
                        } else {
                            callObserver = requestStream
                        }
                    }
                }

                override fun onNext(value: DelineateWorkResponse) {}

                override fun onError(t: Throwable) {
                    Timber.e(t, "Error reporting worker state")
                }

                override fun onCompleted() {
                    completeCallback?.invoke()
                }
            })

        return object: Cancellable {

            override fun cancel() {
                isCancelled = true
                callObserver?.cancel("Cancelled work state report request", null)
                callObserver = null
            }
        }
    }
}