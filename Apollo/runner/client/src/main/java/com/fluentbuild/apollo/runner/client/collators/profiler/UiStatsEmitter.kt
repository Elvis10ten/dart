package com.fluentbuild.apollo.runner.client.collators.profiler

import android.app.Activity
import android.app.Application
import android.os.Handler
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.measurement.ApplicationStatsProto.ApplicationStats
import com.fluentbuild.apollo.measurement.ActivityStatsProto.ActivityStats
import com.fluentbuild.apollo.measurement.FrameStatsProto.FrameStats
import com.fluentbuild.apollo.measurement.ui.UiFrameStatsEmitter
import com.fluentbuild.apollo.measurement.ui.UiStatsFactory
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor
import java.util.*

class UiStatsEmitter(
    private val profilerHandler: Handler,
    private val relativeTimeProvider: () -> Int,
    private val frameStatsConsumer: (FrameStats) -> Unit,
    private val appStatsConsumer: (ApplicationStats) -> Unit,
    private val activityStatsConsumer: (ActivityStats) -> Unit
): ActivityMonitor.Callback, AppMonitor.Callback {

    private val uiFrameStatsEmitter = UiFrameStatsEmitter(profilerHandler)
    private val frameStatsEmission = WeakHashMap<Activity, Cancellable>()

    override fun onStageChanged(activity: Activity, stage: ActivityStats.Stage) {
        profilerHandler.post {
            activityStatsConsumer(UiStatsFactory.createActivityStats(
                activity,
                stage,
                relativeTimeProvider()
            ))
        }

        when(stage) {
            ActivityStats.Stage.PRE_ON_CREATE -> {
                frameStatsEmission[activity] = uiFrameStatsEmitter.start(
                    activity,
                    relativeTimeProvider
                ) { frameStatsConsumer(it) }
            }
            ActivityStats.Stage.DESTROYED -> {
                frameStatsEmission[activity]?.cancel()
                frameStatsEmission.remove(activity)
            }
        }
    }

    override fun onStageChanged(app: Application, stage: ApplicationStats.Stage) {
        profilerHandler.post {
            appStatsConsumer(UiStatsFactory.createAppStats(
                app,
                stage,
                relativeTimeProvider()
            ))
        }
    }

    fun disposeEmissions() {
        frameStatsEmission.values.forEach { it.cancel() }
        frameStatsEmission.clear()
    }
}