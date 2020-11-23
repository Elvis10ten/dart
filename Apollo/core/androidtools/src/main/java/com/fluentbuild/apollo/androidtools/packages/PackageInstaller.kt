package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.SystemClock
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.isInstalledAndEnabled
import com.fluentbuild.apollo.foundation.async.*
import com.fluentbuild.apollo.foundation.sizeMbCeil
import timber.log.Timber
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import kotlin.math.min

private val INSTALL_TIMEOUT_INITIAL_MILLIS = TimeUnit.MINUTES.toMillis(1)
private val INSTALL_TIMEOUT_MULTIPLIER_MILLIS = TimeUnit.SECONDS.toMillis(10)
private val INSTALL_TIMEOUT_MAX_MILLIS = TimeUnit.MINUTES.toMillis(6)

class PackageInstaller(
    private val appContext: Context,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler,
    private val installPermission: InstallPermission,
    private val strategyFactory: StrategyFactory
) {

    @MainThread
    fun install(request: Request, _callback: Callback): Cancellable {
        requireMainThread()
        Timber.i("Installing: %s", request)
        var callback: Callback? = _callback

        if(!installPermission.has()) {
            callback?.onError(request, InstallPermission.NotGrantedException())
            return NoOpsCancellable()
        }

        var installFuture: Future<*>? = null
        val timeoutMillis = getTimeoutMillis(request)
        val elapsedStartTimeMillis = SystemClock.elapsedRealtime()

        val strategy = strategyFactory.create(
            request.usePrimaryStrategy,
            request.packageName,
            request.appFileUri,
            timeoutMillis,
            object: InstallStrategy.Callback {

                override fun onCompleted() {
                    requireMainThread()
                    Timber.i("Install strategy completed")

                    installFuture = executorService.submit {
                        waitForCondition(
                            { appContext.isInstalledAndEnabled(request.packageName) },
                            elapsedStartTimeMillis,
                            timeoutMillis,
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
                    Timber.e(error, "Failed to install app")
                    callback?.onError(request, error)
                }
            }
        )

        strategy.install(request.appFile)

        return object: Cancellable {

            override fun cancel() {
                requireMainThread()
                callback = null
                strategy.dispose()
                installFuture.cancelInterrupting()
                Timber.i("Install disposed")
            }
        }
    }

    private fun getTimeoutMillis(request: Request): Long {
        val timeoutForApkSize = (request.appFile.sizeMbCeil() * INSTALL_TIMEOUT_MULTIPLIER_MILLIS)
        val calculatedTimeout = INSTALL_TIMEOUT_INITIAL_MILLIS + timeoutForApkSize
        return min(calculatedTimeout, INSTALL_TIMEOUT_MAX_MILLIS)
    }

    interface Callback {

        @MainThread
        fun onSuccess(request: Request)

        @MainThread
        fun onError(request: Request, error: Throwable)
    }

    data class Request(
        val usePrimaryStrategy: Boolean,
        val appFile: File,
        val appFileUri: Uri,
        val packageName: String
    )
}