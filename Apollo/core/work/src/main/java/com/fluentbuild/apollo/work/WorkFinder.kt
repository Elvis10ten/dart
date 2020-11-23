package com.fluentbuild.apollo.work

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.work.props.DevicePropsProvider
import com.fluentbuild.apollo.work.FindWorkRequestProto.*
import com.fluentbuild.apollo.work.WorkProto.*
import io.grpc.Deadline
import io.grpc.stub.ClientCallStreamObserver
import io.grpc.stub.ClientResponseObserver
import timber.log.Timber
import java.util.concurrent.TimeUnit

class WorkFinder(
    timeoutSeconds: Int,
    private val mainThreadHandler: Handler,
    private val workService: WorkServiceGrpc.WorkServiceStub,
    private val devicePropsProvider: DevicePropsProvider
) {

    private val deadline = Deadline.after(timeoutSeconds.toLong(), TimeUnit.SECONDS)

    @MainThread
    fun find(callback: Callback): Cancellable {
        requireMainThread()

        val request = FindWorkRequest.newBuilder()
            .setDeviceProperties(devicePropsProvider.get())
            .build()

        var findCallback: Callback? = callback
        val findCallbackProvider = { findCallback }
        var observer: ClientCallStreamObserver<FindWorkRequest>? = null

        Timber.i("Finding work, request: %s", request)
        find(request, findCallbackProvider, {
            if(findCallback == null) {
                it?.cancel("Request already cancelled", null)
            } else {
                observer = it
            }
        })

        return object: Cancellable {

            override fun cancel() {
                findCallback = null
                observer?.cancel("Request cancelled", null)
                observer = null
                Timber.i("Cancelling find work request")
            }
        }
    }

    private fun find(
        request: FindWorkRequest,
        callbackProvider: () -> Callback?,
        observerSetter: (ClientCallStreamObserver<FindWorkRequest>?) -> Unit
    ) {
        workService.withDeadline(deadline).find(
            request,
            object: ClientResponseObserver<FindWorkRequest, FindWorkResponseProto.FindWorkResponse> {

                override fun beforeStart(requestStream: ClientCallStreamObserver<FindWorkRequest>) {
                    mainThreadHandler.post { observerSetter(requestStream) }
                }

                override fun onNext(response: FindWorkResponseProto.FindWorkResponse) {
                    Timber.d("On work found: %s", response)
                    mainThreadHandler.post {
                        observerSetter(null)
                        callbackProvider()?.onWorkFound(response.work)
                    }
                }

                override fun onError(error: Throwable) {
                    Timber.e(error,"Find work error")
                    mainThreadHandler.post {
                        observerSetter(null)
                        callbackProvider()?.onFindWorkError(error)
                    }
                }

                override fun onCompleted() {
                    Timber.d("Find work request completed")
                }
            }
        )
    }

    interface Callback {

        fun onWorkFound(work: Work)

        fun onFindWorkError(error: Throwable)
    }
}
