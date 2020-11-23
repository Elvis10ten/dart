package com.fluentbuild.apollo.runner.client.instrumentation.lifecycle

import android.app.Application
import android.app.Instrumentation
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.measurement.ApplicationStatsProto.ApplicationStats
import java.lang.ref.WeakReference

private const val LOG_TAG = "AppMonitor"

class AppMonitor(
    private val logWrapper: LogWrapper
): Monitor<AppMonitor.Callback>() {

    private var appRef: WeakReference<Application>? = null

    private fun signalLifecycleChange(application: Application, stage: ApplicationStats.Stage) {
        logWrapper.i(LOG_TAG, "Application: $application is in stage: $stage")
        forEachCallback { callback, _ ->
            callback.onStageChanged(application, stage)
        }
    }

    fun onCallApplicationOnCreate(app: Application, action: () -> Unit) {
        appRef = WeakReference(app)
        signalLifecycleChange(app, ApplicationStats.Stage.PRE_ON_CREATE)
        action()
        signalLifecycleChange(app, ApplicationStats.Stage.CREATED)
    }

    fun getActiveApp(): Application? = appRef?.get()

    interface Callback {
        fun onStageChanged(app: Application, stage: ApplicationStats.Stage)
    }
}