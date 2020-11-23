package com.fluentbuild.apollo.runner.client.overlays

import android.app.Activity
import androidx.annotation.MainThread
import com.fluentbuild.apollo.measurement.ActivityStatsProto.ActivityStats
import com.fluentbuild.apollo.runner.client.TestConfigs
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import java.util.*

class OverlaysManager(
    private val testConfigs: TestConfigs,
    private val activityMonitor: ActivityMonitor
): ActivityMonitor.Callback {

    private val overlays = WeakHashMap<Activity, WindowOverlay>()

    @MainThread
    fun init() {
        if(testConfigs.isObscureWindowEnabled()) {
            activityMonitor.registerCallback(this)
        }
    }

    fun updateProgressUi(text: String) {
        overlays.values.forEach { it.updateLabel(text) }
    }

    fun getOverlayRootView(activity: Activity) = overlays[activity]?.getRoot()

    override fun onStageChanged(activity: Activity, stage: ActivityStats.Stage) {
        if(stage == ActivityStats.Stage.CREATED) {
            overlays[activity] = WindowOverlay(activity)
        } else if(stage == ActivityStats.Stage.DESTROYED) {
            overlays.remove(activity)
        }
    }
}