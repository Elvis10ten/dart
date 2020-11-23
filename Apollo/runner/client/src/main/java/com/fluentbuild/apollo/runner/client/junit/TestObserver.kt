package com.fluentbuild.apollo.runner.client.junit

import android.app.Instrumentation
import android.os.Bundle
import androidx.test.internal.runner.listener.InstrumentationResultPrinter
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.base.TestKeys.Status
import com.fluentbuild.apollo.runner.client.ClientFinalizer
import com.fluentbuild.apollo.runner.client.TestConfigs
import com.fluentbuild.apollo.runner.client.TestClient
import com.fluentbuild.apollo.runner.client.collators.CollatorsManager
import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.notification.Failure
import java.io.PrintStream

private const val LOG_TAG = "TestObserver"

internal class TestObserver(
    private val testClient: TestClient,
    private val testsConfigs: TestConfigs,
    private val instrumentationResultPrinter: InstrumentationResultPrinter,
    private val clientFinalizer: ClientFinalizer,
    private val collatorsManager: CollatorsManager,
    private val logWrapper: LogWrapper,
    private val progressUiUpdater: ((String) -> Unit)
): InstrumentationResultPrinter() {

    private var startedCount = 0
    private var lastStartedTest: Description? = null

    override fun testRunStarted(description: Description) {
        progressUiUpdater("Starting verifications!")
        testClient.testRunStarted(description)
        logWrapper.i(LOG_TAG, "${Status.RUN_STARTED}:${description}")
        instrumentationResultPrinter.testRunStarted(description)
    }

    override fun testStarted(description: Description) {
        lastStartedTest = description
        startedCount++
        progressUiUpdater("Verifying $startedCount of ${testsConfigs.getTestsCount()}")
        testClient.testStarted(description, collatorsManager.getInfo())
        logWrapper.i(LOG_TAG, "${Status.STARTED}:${description}")
        instrumentationResultPrinter.testStarted(description)
    }

    override fun testAssumptionFailure(failure: Failure) {
        progressUiUpdater("Assume verification failed!")
        testClient.testAssumptionFailure(failure)
        logWrapper.i(LOG_TAG, "${Status.ASSUME_FAILURE}:${failure}")
        restartMeasurement()
        instrumentationResultPrinter.testAssumptionFailure(failure)
    }

    override fun testRunFinished(result: Result) {
        progressUiUpdater("Verifications finished!")
        testClient.testRunFinished(result)
        logWrapper.i(LOG_TAG, "${Status.RUN_FINISHED}:${result}")
        instrumentationResultPrinter.testRunFinished(result)
    }

    override fun getInstrumentation(): Instrumentation {
        return instrumentationResultPrinter.instrumentation
    }

    override fun sendString(msg: String) {
        testClient.sendString(msg)
        instrumentationResultPrinter.sendString(msg)
    }

    override fun setInstrumentation(instr: Instrumentation) {
        instrumentationResultPrinter.instrumentation = instr
    }

    override fun sendStatus(code: Int, bundle: Bundle) {
        instrumentationResultPrinter.sendStatus(code, bundle)
    }

    override fun instrumentationRunFinished(
        summaryWriter: PrintStream,
        resultBundle: Bundle,
        junitResults: Result
    ) {
        logWrapper.i(LOG_TAG, Status.INSTRUMENTATION_RUN_FINISHED)
        clientFinalizer.finalize()
        instrumentationResultPrinter.instrumentationRunFinished(summaryWriter, resultBundle, junitResults)
    }

    override fun testFailure(failure: Failure) {
        progressUiUpdater("Single verification failed!")
        testClient.testFailure(failure)
        logWrapper.i(LOG_TAG, "${Status.FAILURE}:${failure}")
        restartMeasurement()
        instrumentationResultPrinter.testFailure(failure)
    }

    override fun testFinished(description: Description) {
        progressUiUpdater("Single verification finished!")
        testClient.testFinished(description)
        logWrapper.i(LOG_TAG, "${Status.FINISHED}:${description}")
        restartMeasurement()
        instrumentationResultPrinter.testFinished(description)
    }

    override fun testIgnored(description: Description) {
        progressUiUpdater("Single verification ignored!")
        testClient.testIgnored(description)
        logWrapper.i(LOG_TAG, "${Status.IGNORED}:${description}")
        restartMeasurement()
        instrumentationResultPrinter.testIgnored(description)
    }

    override fun reportProcessCrash(throwable: Throwable) {
        testClient.processCrashed(Failure(lastStartedTest, throwable))
        logWrapper.i(LOG_TAG, "${Status.PROCESS_CRASHED}:${throwable}")
        restartMeasurement()
        instrumentationResultPrinter.reportProcessCrash(throwable)
    }

    private fun restartMeasurement() {
        collatorsManager.restart()
    }
}