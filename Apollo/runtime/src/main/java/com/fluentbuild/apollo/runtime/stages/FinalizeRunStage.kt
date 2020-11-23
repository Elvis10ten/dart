package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import android.content.Intent
import com.fluentbuild.apollo.work.tests.RunReportProto.*
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.startup.Igniter
import com.fluentbuild.apollo.work.WorkProto

/** An intent action to notify BootstrapActivity in AndroidX to be finished.  */
private const val FINISH_BOOTSTRAP_ACTIVITY = "androidx.test.core.app.InstrumentationActivityInvoker.FINISH_BOOTSTRAP_ACTIVITY"

/**
 * An intent action to notify EmptyActivity and EmptyFloatingActivity in AndroidX to be finished.
 */
private const val FINISH_EMPTY_ACTIVITIES = "androidx.test.core.app.InstrumentationActivityInvoker.FINISH_EMPTY_ACTIVITIES"

class FinalizeRunStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val runReport: RunReport,
    private val igniter: Igniter,
    callback: Callback
): Stage(callback) {

    override fun onStart() {
        finalizeWork()
    }

    override fun onRetry(throwable: Throwable) {
        finalizeWork()
    }

    override fun onStop() {}

    override fun getAction() = "Finalizing Run"

    override fun getMaxRetries() = 3

    private fun finalizeWork() {
        updateUi(UiData(appContext.getString(R.string.runtime_finalizing_run_work)))
        if(runReport.runError?.simpleName == WorkInterruptedException::class.java.simpleName) {
            igniter.onEvent(Igniter.Event.MANUAL_STOP)
        }

        appContext.sendBroadcast(Intent(FINISH_BOOTSTRAP_ACTIVITY))
        appContext.sendBroadcast(Intent(FINISH_EMPTY_ACTIVITIES))

        onComplete(RuntimeState.BundlingResults(work, runReport))
    }
}