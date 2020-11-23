package com.fluentbuild.apollo.runner.server

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.Cancellables
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.work.WorkProto.Work
import com.fluentbuild.apollo.work.WorkerStateReporter
import com.fluentbuild.apollo.work.tests.AtomicResultProto.AtomicResult
import timber.log.Timber

private const val PULSE_INTERVAL_MILLIS = 30_000L
private const val MAX_ALLOWED_MISSED_CYCLE_COUNT = 3 // Actually 2, discounting the first one
private const val REPORT_RESULT_DELAY_MILLIS = 5_000L

class WorkerRetainer(
    private val mainThreadHandler: Handler,
    private val reporter: WorkerStateReporter
) {

    private var work: Work? = null
    private var workLostCallback: ((Work) -> Unit)? = null

    private var lastCompletedReportTimestamp = 0L
    private var isRetaining = false
    private var missedConsecutiveCycleCount = 0

    private val pendingResults = mutableListOf<AtomicResult>()
    private var hasPendingResultsRequest = false

    private val progressCancellables = Cancellables()
    private val pulseCancellables = Cancellables()

    private var retainerRunnable = object: Runnable {
        override fun run() {
            if(attemptRetention()) {
                Timber.i("Retaining worker")
                mainThreadHandler.postDelayed(this, PULSE_INTERVAL_MILLIS)
            }
        }
    }
    private var sendResultRunnable = object: Runnable {
        override fun run() {
            hasPendingResultsRequest = false
            if(pendingResults.isNotEmpty() && isRetaining) {
                Timber.i("Sending worker results")
                reporter.sendCheckpoint(work!!, pendingResults)
                pendingResults.clear()
            }
        }
    }

    @MainThread
    fun startRetainer(work: Work, workLostCallback: (Work) -> Unit) {
        Timber.i("Starting retainer")
        requireMainThread()
        if(isRetaining) {
            Timber.v("Already retaining worker")
            return
        }

        this.work = work
        this.workLostCallback = workLostCallback
        missedConsecutiveCycleCount = 0
        isRetaining = true

        reporter.completeCallback = {
            mainThreadHandler.post {
                missedConsecutiveCycleCount = 0
                lastCompletedReportTimestamp = System.currentTimeMillis()
            }
        }

        mainThreadHandler.postDelayed(retainerRunnable,
            PULSE_INTERVAL_MILLIS
        )
    }

    @MainThread
    fun stopRetainer() {
        Timber.i("Stopping retainer")
        requireMainThread()
        isRetaining = false
        mainThreadHandler.removeCallbacks(retainerRunnable)
        mainThreadHandler.removeCallbacks(sendResultRunnable)
        pulseCancellables.cancelAll()
        progressCancellables.cancelAll()

        workLostCallback = null
        reporter.completeCallback = null
        missedConsecutiveCycleCount = 0
        work = null
    }

    fun reportRunProgress(instrumentation: InstrumentationMeta, result: AtomicResult) {
        mainThreadHandler.post {
            pendingResults += result

            if(!hasPendingResultsRequest) {
                Timber.i("Accumulating results for reporting")
                hasPendingResultsRequest = true
                mainThreadHandler.postDelayed(sendResultRunnable, REPORT_RESULT_DELAY_MILLIS)
            }
        }
    }

    private fun attemptRetention(): Boolean {
        val currentTimestamp = System.currentTimeMillis()
        val timeSinceLastReport = (currentTimestamp - lastCompletedReportTimestamp)
        Timber.i("Time since last report: %s", timeSinceLastReport)
        if(!isRetaining) return false

        if(timeSinceLastReport > PULSE_INTERVAL_MILLIS) {
            missedConsecutiveCycleCount++
            if(missedConsecutiveCycleCount > MAX_ALLOWED_MISSED_CYCLE_COUNT) {
                workLostCallback?.invoke(work!!)
                return false
            } else {
                pulseCancellables.cancelAll()
                pulseCancellables.add(reporter.sendPulse(work!!))
            }
        }

        return true
    }
}