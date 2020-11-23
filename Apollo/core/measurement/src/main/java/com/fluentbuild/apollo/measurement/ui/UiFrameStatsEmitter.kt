package com.fluentbuild.apollo.measurement.ui

import android.app.Activity
import android.os.Build
import android.os.Handler
import android.view.FrameMetrics.*
import android.view.Window
import androidx.annotation.RequiresApi
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.async.Cancellable
import com.fluentbuild.apollo.foundation.async.NoOpsCancellable
import com.fluentbuild.apollo.measurement.FrameStatsProto.FrameStats

class UiFrameStatsEmitter(
    private val handler: Handler
) {

    fun start(
        activity: Activity,
        relativeTimeProvider: () -> Int,
        consumer: (FrameStats) -> Unit
    ): Cancellable {
        if(!AndroidVersion.isAtLeastNougat()) {
            return NoOpsCancellable()
        }

        val listener = Window.OnFrameMetricsAvailableListener { _, frameMetrics, _ ->
            val statsBuilder = FrameStats.newBuilder()
                .setActivityName(activity::class.java.name)
                .setAnimationDuration(frameMetrics.getMetric(ANIMATION_DURATION))
                .setCommandIssueDuration(frameMetrics.getMetric(COMMAND_ISSUE_DURATION))
                .setDrawDuration(frameMetrics.getMetric(DRAW_DURATION))
                .setFirstDrawFrame(frameMetrics.getMetric(FIRST_DRAW_FRAME) == 1L)
                .setInputHandlingDuration(frameMetrics.getMetric(INPUT_HANDLING_DURATION))
                .setLayoutMeasureDuration(frameMetrics.getMetric(LAYOUT_MEASURE_DURATION))
                .setSwapBuffersDuration(frameMetrics.getMetric(SWAP_BUFFERS_DURATION))
                .setSyncDuration(frameMetrics.getMetric(SYNC_DURATION))
                .setTotalDuration(frameMetrics.getMetric(TOTAL_DURATION))
                .setUnknownDelayDuration(frameMetrics.getMetric(UNKNOWN_DELAY_DURATION))
                .setRelativeTime(relativeTimeProvider())

            if(AndroidVersion.isAtLeastOreo()) {
                statsBuilder.intendedVSyncTimestamp =
                    frameMetrics.getMetric(INTENDED_VSYNC_TIMESTAMP)
                statsBuilder.vSyncTimestamp =
                    frameMetrics.getMetric(VSYNC_TIMESTAMP)
            }

            consumer(statsBuilder.build())
        }

        activity.window.addOnFrameMetricsAvailableListener(listener, handler)
        return object: Cancellable {

            @RequiresApi(Build.VERSION_CODES.N)
            override fun cancel() {
                activity.window.removeOnFrameMetricsAvailableListener(listener)
            }
        }
    }
}