package com.fluentbuild.apollo.runner.client.instrumentation.lifecycle

import android.app.Activity
import android.app.Instrumentation
import android.os.Bundle
import android.os.PersistableBundle
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.measurement.ActivityStatsProto.ActivityStats
import java.lang.ref.WeakReference
import java.util.*

private const val LOG_TAG = "ActivityMonitor"

class ActivityMonitor(
    private val logWrapper: LogWrapper
): Monitor<ActivityMonitor.Callback>() {

    private val activeActivities = WeakHashMap<Activity, ActivityStats.Stage>()

    private fun signalLifecycleChange(activity: Activity, stage: ActivityStats.Stage) {
        logWrapper.i(LOG_TAG, "Activity: $activity is in stage: $stage")
        activeActivities[activity] = stage
        forEachCallback { callback, _ ->
            callback.onStageChanged(activity, stage)
        }
    }

    fun onCallActivityOnDestroy(activity: Activity, action: () -> Unit) {
        signalLifecycleChange(activity, ActivityStats.Stage.DESTROYED)
        action()
        activeActivities.remove(activity)
    }

    fun onCallActivityOnRestart(activity: Activity, action: () -> Unit) {
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.RESTARTED)
    }

    fun onCallActivityOnCreate(activity: Activity, bundle: Bundle?, action: () -> Unit) {
        signalLifecycleChange(activity, ActivityStats.Stage.PRE_ON_CREATE)
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.CREATED)
    }

    fun onCallActivityOnCreate(
        activity: Activity,
        bundle: Bundle?,
        persistentState: PersistableBundle,
        action: () -> Unit
    ) {
        signalLifecycleChange(activity, ActivityStats.Stage.PRE_ON_CREATE)
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.CREATED)
    }

    fun onCallActivityOnStart(activity: Activity, action: () -> Unit) {
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.STARTED)
    }

    fun onCallActivityOnStop(activity: Activity, action: () -> Unit) {
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.STOPPED)
    }

    fun onCallActivityOnResume(activity: Activity, action: () -> Unit) {
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.RESUMED)
    }

    fun onCallActivityOnPause(activity: Activity, action: () -> Unit) {
        action()
        signalLifecycleChange(activity, ActivityStats.Stage.PAUSED)
    }
    
    fun getActiveActivities(): Set<Activity>  {
        return activeActivities.keys
    }

    interface Callback {
        fun onStageChanged(activity: Activity, stage: ActivityStats.Stage)
    }
}