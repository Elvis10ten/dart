package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import android.os.Handler
import android.util.Log
import com.fluentbuild.apollo.androidtools.notifications.DndController
import com.fluentbuild.apollo.androidtools.notifications.DndPermission
import com.fluentbuild.apollo.foundation.getTrace
import com.fluentbuild.apollo.runner.base.WorkInterruptCallback
import com.fluentbuild.apollo.runner.server.*
import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.runner.server.models.ServerArgs
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.DeviceKeyProvider
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.tests.ErrorProto.*
import com.fluentbuild.apollo.work.tests.RunReportProto.*
import timber.log.Timber
import java.util.concurrent.TimeoutException

private const val RETRY_DELAY_MILLIS = 2_000L

class RunStage(
    private val appContext: Context,
    private val mainThreadHandler: Handler,
    private val clientObserver: ClientObserver,
    override val work: WorkProto.Work,
    private val resultsHolder: ResultsHolder,
    private val dndController: DndController,
    private val cancelSignal: CancelSignal,
    private val clientBootstrapper: ClientBootstrapper,
    private val instrumentations: List<InstrumentationMeta>,
    private val deviceKeyProvider: DeviceKeyProvider,
    callback: Callback
): Stage(callback) {

    private var testServer: TestServer? = null
    private var runGlobalRetries = 0
    private val retryRunnable = Runnable {
        if(isStarted) {
            startWork()
        }
    }

    override fun onStart() {
        startWork()
    }

    override fun onStop() {
        release()
    }

    override fun getMaxRetries() = work.numRetriesPerDevice

    override fun getAction() = "Running"

    override fun onRetry(throwable: Throwable) {
        Timber.i("Retrying work run!")
        if(throwable !is IncompleteWorkResultException) {
            runGlobalRetries++
        }

        release()
        mainThreadHandler.postDelayed(retryRunnable, RETRY_DELAY_MILLIS)
    }

    override fun canRetry(throwable: Throwable): Boolean {
        return runGlobalRetries < getMaxRetries() && throwable !is InterruptedException
    }

    override fun getBinder(): StageServiceBinder? {
        return StageServiceBinder(clientObserver) { onClientUnbind() }
    }

    private fun startWork() {
        updateUi(UiData(appContext.getString(R.string.runtime_running_work)))
        try {
            dndController.start()
        } catch (e: DndPermission.NotGrantedException) {
            return onRunError(e)
        }

        runTests(instrumentations)
    }

    private fun runTests(instrumentations: List<InstrumentationMeta>) {
        val serverArgs = ServerArgs(
            work,
            instrumentations,
            resultsHolder.getTestsAlreadyRan()
        )
        resultsHolder.moveRunFailedTestsFromAlreadyRanList()

        testServer = TestServer(
            appContext,
            serverArgs,
            mainThreadHandler,
            clientObserver,
            clientBootstrapper,
            object: TestServer.Callback {

                override fun onInstrumentationCompleted(error: Exception?) {
                    updateResults()
                    if(error != null) {
                        onRunError(error)
                    }
                }

                override fun onAllInstrumentationsCompleted() {
                    if(resultsHolder.isComplete()) {
                        onRunComplete()
                    } else {
                        onRunError(IncompleteWorkResultException())
                    }
                }

                override fun onTimeout() {
                    updateResults()
                    onRunError(ServerTimeoutException())
                }

                override fun onInterrupted(reason: WorkInterruptCallback.Reason) {
                    updateResults()
                    onRunComplete(WorkInterruptedException(reason))
                }

                override fun onServerError(error: Throwable) {
                    // todo: got to handle
                    Log.i("a16z", "Desc:" + (error as AtomicTestNotFoundException).testDescription)
                }
        }).apply { start() }
    }

    private fun onClientUnbind() {
        updateResults()
        onRunError(WorkClientDisconnectedException())
    }

    private fun updateResults() {
        val server = testServer!!
        resultsHolder.put(server.getCurrentInstrumentation(), server.getResults())
    }

    private fun onRunError(throwable: Throwable) {
        if(resultsHolder.isComplete()) {
            Timber.w(throwable, "Error after completion is not used!")
            onRunComplete()
        } else if(canRetry(throwable) && canRetryWork(throwable)) {
            onError(throwable)
        } else {
            // Submit result anyways if we can't retry, the server will reroute to another worker as required
            onRunComplete(throwable)
        }
    }

    private fun release() {
        mainThreadHandler.removeCallbacks(retryRunnable)
        testServer?.stop()
        testServer = null
        dndController.stop()
        cancelSignal.send()
    }

    private fun onRunComplete(runError: Throwable? = null) {
        Timber.i(runError, "On run complete: %s", resultsHolder)
        val runReportBuilder = RunReport.newBuilder()
            .setInstrumentationResult(resultsHolder.getResults())
            .setDeviceKey(deviceKeyProvider.get())

        if(runError != null) {
            val trace = if(runError is ClientCrashException){
                runError.stackTrace
            } else {
                runError.getTrace()
            }

            runReportBuilder.runError = Error.newBuilder()
                .setStackTrace(trace)
                .setSimpleName(runError::class.java.simpleName)
                .build()
        }

        onComplete(RuntimeState.FinalizingRun(work, runReportBuilder.build()))
    }

    private fun canRetryWork(error: Throwable): Boolean {
        return error !is WorkInterruptedException
    }
}

class ServerTimeoutException: TimeoutException()

class IncompleteWorkResultException: RuntimeException()

class WorkClientDisconnectedException: RuntimeException()

class WorkInterruptedException(
    reason: WorkInterruptCallback.Reason
): RuntimeException("Work interrupted because of $reason")