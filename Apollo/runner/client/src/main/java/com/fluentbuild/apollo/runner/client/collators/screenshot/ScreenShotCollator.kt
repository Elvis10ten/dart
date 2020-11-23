package com.fluentbuild.apollo.runner.client.collators.screenshot

import android.app.Activity
import android.graphics.Bitmap
import android.os.Handler
import android.view.View
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.RepeatableRunnable
import com.fluentbuild.apollo.measurement.ActivityStatsProto.*
import com.fluentbuild.apollo.runner.base.screenshot.ScreenShotter
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor

private const val ONE_SECONDS_IN_MILLIS = 1000L
private const val LOG_TAG = "ScreenShotCollator"

class ScreenShotCollator(
    fps: Int,
    private val mainThreadHandler: Handler,
    private val activityMonitor: ActivityMonitor,
    private val screenShotNameGenerator: ScreenShotNameGenerator,
    private val screenShotter: ScreenShotter,
    private val screenShotWriter: ScreenShotWriter,
    private val logWrapper: LogWrapper,
    private val ignoredScreenShotViewProvider: (Activity) -> View?
): ActivityMonitor.Callback {

    private var currentTestScreenShotPrefix: String? = null
    private val frameInterval = ONE_SECONDS_IN_MILLIS / fps

    private val shotRunnable = object: RepeatableRunnable(mainThreadHandler, frameInterval) {
        override fun onRun() {
            currentTestScreenShotPrefix?.let { takeScreenshot(it) }
        }
    }

    fun start(screenShotNamePrefix: String) {
        currentTestScreenShotPrefix = screenShotNamePrefix
        reevaluateCollation()
    }

    fun stop() {
        currentTestScreenShotPrefix = null
        reevaluateCollation()
    }

    override fun onStageChanged(activity: Activity, stage: ActivityStats.Stage) {
        reevaluateCollation()
    }

    private fun reevaluateCollation() {
        if(currentTestScreenShotPrefix != null && activityMonitor.getActiveActivities().isNotEmpty()) {
            shotRunnable.startRepeating(true)
        } else  {
            shotRunnable.stopRepeating()
        }
    }

    private fun takeScreenshot(namePrefix: String) {
        activityMonitor.getActiveActivities().forEach { activity ->
            val screenShotFileName = screenShotNameGenerator.generate(namePrefix)
            val ignoredView = ignoredScreenShotViewProvider(activity)

            screenShotter.take(activity, ignoredView, object: ScreenShotter.Callback {

                override fun onSuccess(bitmap: Bitmap) {
                    screenShotWriter.saveScreenShot(screenShotFileName, bitmap)
                }

                override fun onError(error: Throwable) {
                    if(error is ScreenShotter.IllegalBitmapSizeException ||
                        error is ScreenShotter.NoWindowSurfaceException ||
                        error is ScreenShotter.DecorViewNullException) {
                        logWrapper.w(LOG_TAG, "Activity not ready for auto screenshot")
                    } else {
                        logWrapper.e(LOG_TAG, error, "Failed to take screenshot")
                    }
                }
            })
        }
    }
}