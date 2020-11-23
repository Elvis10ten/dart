package com.fluentbuild.apollo.runner.client.collators.profiler

import android.os.Handler
import com.fluentbuild.apollo.foundation.async.RepeatableRunnable
import com.fluentbuild.apollo.measurement.SampleFrequencyProto.*
import com.fluentbuild.apollo.measurement.StatsFrameWrapper
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor

class ProfilerSampler(
    frequencyValue: Int = 0,
    private val pid: Int,
    private val uid: Int,
    private val statsFrameWrapper: StatsFrameWrapper,
    private val profilerHandler: Handler,
    private val appMonitor: AppMonitor,
    private val activityMonitor: ActivityMonitor
) {

    private val sampleFrequency = frequencyValue.getFrequency()

    private val tightInterval = (5_00 * sampleFrequency.getIntervalMultiplier()).toLong()
    private val tightSampler = object: RepeatableRunnable(profilerHandler, tightInterval) {

        override fun onRun() {
            statsFrameWrapper.loadMemoryStats()
            statsFrameWrapper.loadUnixProcessStats(pid)
            statsFrameWrapper.loadThreadStats()
        }
    }

    private val looseInterval = (2_000 * sampleFrequency.getIntervalMultiplier()).toLong()
    private val looseSampler = object: RepeatableRunnable(profilerHandler, looseInterval) {

        override fun onRun() {
            statsFrameWrapper.loadBinderStats()
            statsFrameWrapper.loadFileIoStats(pid)
            statsFrameWrapper.loadGcStats()
            statsFrameWrapper.loadNetworkStats(uid)
            statsFrameWrapper.loadResourceUsageStats()
        }
    }

    private val uiStatsEmitter = UiStatsEmitter(
        profilerHandler,
        { statsFrameWrapper.getRelativeTime() },
        { statsFrameWrapper.addFrameStats(it) },
        { statsFrameWrapper.addAppStats(it) },
        { statsFrameWrapper.addActivityStats(it) }
    )

    fun startSampling() {
        tightSampler.startRepeating(true)
        looseSampler.startRepeating(false)

        appMonitor.unregisterCallback(uiStatsEmitter)
        activityMonitor.unregisterCallback(uiStatsEmitter)
    }

    fun stopSampling() {
        tightSampler.stopRepeating()
        looseSampler.stopRepeating()

        appMonitor.unregisterCallback(uiStatsEmitter)
        activityMonitor.unregisterCallback(uiStatsEmitter)
        uiStatsEmitter.disposeEmissions()
    }
}

private fun Int.getFrequency(): SampleFrequency {
    return when(this) {
        SampleFrequency.FREQUENT_VALUE -> SampleFrequency.FREQUENT
        SampleFrequency.REGULAR_VALUE -> SampleFrequency.REGULAR
        SampleFrequency.INFREQUENT_VALUE -> SampleFrequency.INFREQUENT
        else -> throw IllegalArgumentException("Invalid sample frequency")
    }
}

private fun SampleFrequency.getIntervalMultiplier(): Float {
    return when(this) {
        SampleFrequency.FREQUENT -> 0.5f
        SampleFrequency.REGULAR -> 1f
        SampleFrequency.INFREQUENT -> 2f
        else -> throw IllegalArgumentException("Invalid sample frequency")
    }
}