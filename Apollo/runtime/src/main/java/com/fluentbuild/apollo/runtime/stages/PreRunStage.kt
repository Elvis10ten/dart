package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.androidtools.packages.ProcessKiller
import com.fluentbuild.apollo.androidtools.window.SystemWindows
import com.fluentbuild.apollo.runner.base.NoInstrumentationException
import com.fluentbuild.apollo.runner.server.models.getInstrumentationsMeta
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.work.WorkProto

class PreRunStage(
    private val appContext: Context,
    override val work: WorkProto.Work,
    private val systemWindows: SystemWindows,
    private val processKiller: ProcessKiller,
    callback: Callback
): Stage(callback) {

    override fun onStart() {
        conditionDevice()
    }

    override fun onRetry(throwable: Throwable) {
        conditionDevice()
    }

    override fun onStop() {}

    override fun getAction() = "Before Running"

    override fun getMaxRetries() = 3

    private fun conditionDevice() {
        updateUi(UiData(appContext.getString(R.string.runtime_preparing_run_work)))
        systemWindows.close()
        processKiller.killAll()

        val instrumentations = appContext.getInstrumentationsMeta(work.packageName)
        if(instrumentations.isEmpty()) {
            return onError(NoInstrumentationException())
        }

        onComplete(RuntimeState.RunningWork(work, instrumentations))
    }
}