package com.fluentbuild.apollo.runner.server

import android.app.Activity
import android.content.Context
import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.runner.base.WorkInterruptCallback
import com.fluentbuild.apollo.runner.server.models.ServerArgs
import timber.log.Timber

class TestServer(
    private val appContext: Context,
    private val args: ServerArgs,
    private val mainThreadHandler: Handler,
    private val clientObserver: ClientObserver,
    private val clientBootstrapper: ClientBootstrapper,
    private var callback: Callback?
) {

    private val workTimeoutRunnable = Runnable { onTimeout() }
    private var currentInstrumentationIndex = 0
    private var currentInstrumentationStarter: InstrumentationStarter? = null
    private var isStarted = false

    @MainThread
    fun start() {
        requireMainThread()
        isStarted = true
        currentInstrumentationIndex = 0
        mainThreadHandler.postDelayed(workTimeoutRunnable, args.work.timeout.toLong())
        startInstrumentation()
    }

    private fun startInstrumentation() {
        Timber.i("Starting instrumentation runner!")
        currentInstrumentationStarter = InstrumentationStarter(
            appContext,
            getCurrentInstrumentation(),
            args.work,
            args.testsAlreadyRan,
            clientObserver,
            object: ClientObserver.Callback {

                override fun onClientConnected() {
                    clientBootstrapper.start()
                }

                override fun onTestRunStarted() {}

                override fun onTestRunFinished() {
                    clientBootstrapper.stop()
                    runTests()
                }

                override fun onProcessCrashed(exception: ClientCrashException) {
                    completeInstrumentation(exception)
                }

                override fun onInterrupted(reason: WorkInterruptCallback.Reason) {
                    callback?.onInterrupted(reason)
                }

                override fun onError(error: Throwable) {
                    callback?.onServerError(error)
                }
            }
        )
        runTests()
    }

    private fun completeInstrumentation(exception: Exception? = null) {
        Timber.i("Completing instrumentation")
        callback?.onInstrumentationCompleted(exception)
    }

    @MainThread
    private fun runTests() {
        requireMainThread()
        if(requireInstrumentationStarter().hasPendingTests()) {
            try {
                requireInstrumentationStarter().start()
            } catch (e: Exception) {
                completeInstrumentation(InstrumentationStartException())
            }
        } else {
            completeInstrumentation()
            if(currentInstrumentationIndex < args.instrumentations.lastIndex) {
                currentInstrumentationIndex++
                startInstrumentation()
            } else {
                Timber.i("All instrumentation completed")
                callback?.onAllInstrumentationsCompleted()
            }
        }
    }

    @MainThread
    fun stop() {
        Timber.i("Cancelling runner server!")
        requireMainThread()
        isStarted = false

        callback = null
        cancelTimeoutTimer()
        clientBootstrapper.stop()
        finishRunner(Activity.RESULT_OK)
    }

    private fun cancelTimeoutTimer() {
        mainThreadHandler.removeCallbacks(workTimeoutRunnable)
    }

    private fun finishRunner(resultCode: Int) {
        currentInstrumentationStarter?.finishTest(resultCode)
        currentInstrumentationStarter = null
    }

    private fun onTimeout() {
        Timber.d("Test server timeout")
        if(isStarted) {
            callback?.onTimeout()
        }
    }

    fun getResults() = clientObserver.getResults()

    fun getCurrentInstrumentation() = args.instrumentations[currentInstrumentationIndex]

    private fun requireInstrumentationStarter() = currentInstrumentationStarter!!

    interface Callback {

        /**
         * ...
         * If the process crashes, then this is the last callback function called until another run request is made.
         */
        fun onInstrumentationCompleted(error: Exception? = null)

        fun onAllInstrumentationsCompleted()

        fun onTimeout()

        fun onInterrupted(reason: WorkInterruptCallback.Reason)

        fun onServerError(error: Throwable)
    }
}


