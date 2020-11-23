package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.os.Handler
import android.os.SystemClock
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.isInstalledAndEnabled
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.NoOpsCancellable
import com.fluentbuild.apollo.foundation.async.cancelInterrupting
import com.fluentbuild.apollo.foundation.async.requireMainThread
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

private val UNINSTALL_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(3)

class PackageRemover(
    private val appContext: Context,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler,
    private val installPermission: InstallPermission,
    private val strategyFactory: StrategyFactory
) {

    @MainThread
    fun uninstall(request: Request, _callback: Callback): Cancellable {
        requireMainThread()
        Timber.i("Uninstalling: %s", request)
        var callback: Callback? = _callback

        if(!appContext.isInstalledAndEnabled(request.packageName)) {
            callback?.onSuccess(request)
            return NoOpsCancellable()
        }

        if(!installPermission.has()) {
            callback?.onError(request, InstallPermission.NotGrantedException())
            return NoOpsCancellable()
        }

        var uninstallFuture: Future<*>? = null
        val elapsedStartTimeMillis = SystemClock.elapsedRealtime()

        val strategy = strategyFactory.create(
            request.usePrimaryStrategy,
            request.packageName,
            null,
            UNINSTALL_TIMEOUT_MILLIS,
            object: InstallStrategy.Callback {

                override fun onCompleted() {
                    requireMainThread()
                    Timber.i("Uninstall strategy completed")

                    uninstallFuture = executorService.submit {
                        waitForCondition(
                            { !appContext.isInstalledAndEnabled(request.packageName) },
                            elapsedStartTimeMillis,
                            UNINSTALL_TIMEOUT_MILLIS,
                            { result ->
                                mainThreadHandler.post {
                                    result.fold(
                                        { callback?.onSuccess(request) },
                                        { callback?.onError(request, it) }
                                    )
                                }
                            }
                        )
                    }
                }

                override fun onError(error: Throwable) {
                    Timber.e(error, "Failed to uninstall app")
                    callback?.onError(request, error)
                }
            }
        )

        strategy.uninstall()

        return object: Cancellable {

            override fun cancel() {
                requireMainThread()
                callback = null
                strategy.dispose()
                uninstallFuture.cancelInterrupting()
                Timber.i("Remover disposed")
            }
        }
    }

    data class Request(
        val usePrimaryStrategy: Boolean,
        val packageName: String
    )

    interface Callback {

        @MainThread
        fun onSuccess(request: Request)

        @MainThread
        fun onError(request: Request, error: Throwable)
    }
}