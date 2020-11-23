package com.fluentbuild.apollo.runner.server

import android.app.Activity
import android.os.DeadObjectException
import android.os.Handler
import android.os.SystemClock
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.runner.*
import com.fluentbuild.apollo.runner.base.WorkInterruptCallback
import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.work.WorkProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.apollo.work.tests.AtomicTestProto.*
import timber.log.Timber

class ClientObserver(
    private val mainThreadHandler: Handler,
    private val cancelSignal: CancelSignal,
    private val workerRetainer: WorkerRetainer
): TestCallback.Stub() {

    private var serverCallback: Callback? = null
    private var instrumentationMeta: InstrumentationMeta? = null
    private var clientFinisher: Finisher? = null

    private var work: Work? = null

    private var curTestResultBuilder: AtomicResult.Builder? = null
    private val resultsBuilders = mutableMapOf<AtomicTest, AtomicResult.Builder>()

    @MainThread
    internal fun init(
        instrumentationMeta: InstrumentationMeta,
        work: Work,
        callback: Callback
    ) {
        Timber.i("Initializing observer")
        requireMainThread()
        cleanup()
        this.instrumentationMeta = instrumentationMeta
        this.serverCallback = callback
        this.work = work
    }

    @MainThread
    internal fun cleanup() {
        Timber.i("Cleaning up ClientObserver")
        requireMainThread()
        instrumentationMeta = null
        serverCallback = null
        work = null

        clientFinisher = null
        curTestResultBuilder = null
        resultsBuilders.clear()
    }

    @MainThread
    private fun reportResult(resultBuilder: AtomicResult.Builder) {
        requireMainThread()
        instrumentationMeta?.let {
            workerRetainer.reportRunProgress(it, resultBuilder.build())
        }
    }

    @MainThread
    fun finishClient(resultCode: Int) {
        requireMainThread()
        Timber.i("Finishing client: %s", resultCode)

        val cachedFinisher = clientFinisher
        cleanup()

        try {
            cachedFinisher?.finish(resultCode)
        } catch (e: DeadObjectException) {
            Timber.e(e, "Couldn't directly finish client. Maybe already finished.")
        }
    }

    @MainThread
    fun getResults(): Set<AtomicResult> {
        requireMainThread()
        return resultsBuilders.values.map { it.build() }.toSet()
    }

    override fun onInterrupted(reasonId: Int) {
        runOnMainThread({ _, callback ->
            Timber.w("Test is interrupted")
            callback.onInterrupted(WorkInterruptCallback.Reason.of(reasonId))
        })
    }

    // todo: If failure happens, then only onTestFailure is called without calling onTestStarted
    private fun getOrSetInitialResultsBuilder(atomicTest: AtomicTest): AtomicResult.Builder {
        return resultsBuilders.getOrPut(atomicTest, {
            AtomicResult.newBuilder()
                .setAtomicTest(atomicTest)
                /*.setLogFileName(logFileName)
                .setAutoScreenShotNamePrefix(autoScreenShotNamePrefix)
                .setProfileFileName(profileFileName)*/
                .setStatus(Status.STARTED)
                .apply {
                    curTestResultBuilder = this
                }
        })
    }

    override fun onTestStarted(
        description: TestDescription,
        logFileName: String,
        profileFileName: String,
        autoScreenShotNamePrefix: String
    ) {
        runOnMainThread({ _, callback ->
            Timber.i("On test started: %s", description)
            useAtomicTest(description, callback) { atomicTest ->
                resultsBuilders[atomicTest] = AtomicResult.newBuilder()
                    .setAtomicTest(atomicTest)
                    .setLogFileName(logFileName)
                    .setAutoScreenShotNamePrefix(autoScreenShotNamePrefix)
                    .setProfileFileName(profileFileName)
                    .setStatus(Status.STARTED)
                    .apply {
                        curTestResultBuilder = this
                    }
            }
        })
    }

    override fun onTestFinished(description: TestDescription) {
        runOnMainThread({ _, callback ->
            Timber.i("On test finished: %s", description)
            useAtomicTest(description, callback) { atomicTest ->
                resultsBuilders[atomicTest]?.apply {
                    if(status == Status.STARTED) {
                        status = Status.PASSED
                    }

                    timeFinished = SystemClock.elapsedRealtime()
                    reportResult(this)
                }
            }
        })
    }

    override fun onTestIgnored(description: TestDescription) {
        runOnMainThread({ _, callback ->
            Timber.i("On test ignored: %s", description)
            useAtomicTest(description, callback) { atomicTest ->
                resultsBuilders.getValue(atomicTest).apply {
                    status = Status.IGNORED
                    reportResult(this)
                }
            }
        })
    }

    override fun sendString(message: String?) {
        runOnMainThread ({ _, _ ->
            Timber.i("Send string: %s", message)
            message?.let {
                curTestResultBuilder?.addRuntimeLogs(it)
            }
        })
    }

    override fun onTestFailure(failure: TestFailure) {
        runOnMainThread({ _, callback ->
            Timber.i("On test failure: %s", failure)
            useAtomicTest(failure.description, callback) { atomicTest ->
                resultsBuilders.getValue(atomicTest).apply {
                    status = Status.FAILURE
                    stackTrace = failure.trace
                    reportResult(this)
                }
            }
        })
    }

    override fun onProcessCrashed(description: TestDescription?, stackTrace: String) {
        runOnMainThread({ _, callback ->
            Timber.i("On process crashed: %s", stackTrace)

            curTestResultBuilder?.apply {
                status = Status.ERROR
                reportResult(this)
            }

            callback.onProcessCrashed(ClientCrashException(stackTrace))
        })
    }

    override fun onTestAssumptionFailure(failure: TestFailure) {
        runOnMainThread({ _, callback ->
            Timber.i("On test assumption failure: %s", failure)
            useAtomicTest(failure.description, callback) { atomicTest ->
                resultsBuilders.getValue(atomicTest).apply {
                    status = Status.ASSUMPTION_FAILURE
                    stackTrace = failure.trace
                    reportResult(this)
                }
            }
        })
    }

    override fun onTestRunStarted(description: TestDescription) {
        runOnMainThread({ _, callback ->
            Timber.i("On test run started: %s", description)
            callback.onTestRunStarted()
        })
    }

    override fun onTestRunFinished(result: TestResult) {
        runOnMainThread({ _, callback ->
            Timber.i("On test run finished: %s", result)
            callback.onTestRunFinished()
        })
    }

    override fun onClientConnected(finisher: Finisher) {
        runOnMainThread({ _, callback ->
            Timber.i("On client connected")
            clientFinisher = finisher
            callback.onClientConnected()
        }, {
            Timber.e("Finishing uninitialized observer client")
            finisher.finish(Activity.RESULT_CANCELED)
        })
    }

    private val defaultUninitializedAction = {
        Timber.e("Observer is not initialized")
        cancelSignal.send()
        cleanup()
    }

    private fun runOnMainThread(
        initializedAction: (InstrumentationMeta, Callback) -> Unit,
        unInitializedAction: (() -> Unit) = defaultUninitializedAction
    ) {
        mainThreadHandler.post {
            val callback = serverCallback ?: return@post unInitializedAction()
            val instrumentation = instrumentationMeta ?: return@post unInitializedAction()
            initializedAction(instrumentation, callback)
        }
    }

    private fun useAtomicTest(
        description: TestDescription,
        callback: Callback,
        action: (AtomicTest) -> Unit
    ) {
        val atomicTest = work!!.findTest(description)
        if(atomicTest == null) {
            callback.onError(AtomicTestNotFoundException(description))
        } else {
            action(atomicTest)
        }
    }

    interface Callback {

        @MainThread
        fun onClientConnected()

        @MainThread
        fun onTestRunStarted()

        @MainThread
        fun onTestRunFinished()

        @MainThread
        fun onProcessCrashed(exception: ClientCrashException)

        @MainThread
        fun onInterrupted(reason: WorkInterruptCallback.Reason)

        @MainThread
        fun onError(error: Throwable)
    }
}

class AtomicTestNotFoundException(
    val testDescription: TestDescription
): RuntimeException()