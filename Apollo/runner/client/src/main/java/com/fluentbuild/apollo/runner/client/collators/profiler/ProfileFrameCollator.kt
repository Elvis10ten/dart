package com.fluentbuild.apollo.runner.client.collators.profiler

import android.content.Context
import android.os.Handler
import android.os.Process
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.RepeatableRunnable
import com.fluentbuild.apollo.foundation.autoCloseOutputStream
import com.fluentbuild.apollo.measurement.StatsFrameWrapper
import com.fluentbuild.apollo.runner.base.SimpleActivityLifecycleCallbacks
import com.fluentbuild.apollo.runner.client.FileDescriptorProvider
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor

private const val PROFILE_FRAME_MILLIS = 20_000L
private const val LOG_TAG = "ProfilerFrameCollator"

// todo: Cumulative values contract should be honoured: data should be discarded
class ProfilerFrameCollator(
    frequencyValue: Int,
    targetContext: Context,
    private val fileProvider: FileDescriptorProvider,
    private val profilerHandler: Handler,
    private val logWrapper: LogWrapper,
    appMonitor: AppMonitor,
    activityMonitor: ActivityMonitor
): SimpleActivityLifecycleCallbacks() {

    private var profilerFileName: String? = null
    private val pid = Process.myPid()
    private val uid = Process.myUid()

    private val statsFrameWrapper = StatsFrameWrapper(targetContext, logWrapper)
    private val profilerSampler = ProfilerSampler(
        frequencyValue,
        pid,
        uid,
        statsFrameWrapper,
        profilerHandler,
        appMonitor,
        activityMonitor
    )

    private val saveRunnable = object: RepeatableRunnable(profilerHandler, PROFILE_FRAME_MILLIS) {
        override fun onRun() {
            saveFrame()
        }
    }

    @MainThread
    fun start(fileName: String) {
        profilerFileName = fileName
        statsFrameWrapper.reset()

        statsFrameWrapper.setStartValues(uid, pid)

        profilerSampler.startSampling()
        saveRunnable.startRepeating(false)
    }

    @MainThread
    fun stop() {
        saveRunnable.stopRepeating()
        profilerSampler.stopSampling()

        statsFrameWrapper.setEndValues(uid, pid)
        saveFrame()

        profilerFileName = null
    }

    private fun saveFrame() {
        val name = profilerFileName ?: return

        try {
            fileProvider.getAppendableDescriptor(name).autoCloseOutputStream {
                statsFrameWrapper.writeTo(it)
                it.flush()
                // todo: don't reset time: see chart
                statsFrameWrapper.reset()
            }
        } catch (e: Exception) {
            logWrapper.e(LOG_TAG, e, "Failed to save profiler frame")
        }
    }
}