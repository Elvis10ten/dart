package com.fluentbuild.apollo.runner.client.collators

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.view.View
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.base.screenshot.ScreenShotterFactory
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.FileDescriptorProvider
import com.fluentbuild.apollo.runner.client.TestConfigs
import com.fluentbuild.apollo.runner.client.collators.screenshot.ScreenShotCollator
import com.fluentbuild.apollo.runner.client.collators.screenshot.ScreenShotNameGenerator
import com.fluentbuild.apollo.runner.client.collators.screenshot.ScreenShotWriter
import com.fluentbuild.apollo.runner.client.collators.logs.Logger
import com.fluentbuild.apollo.runner.client.collators.profiler.ProfilerFrameCollator
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor
import java.util.*

private const val LOG_FILE_EXTENSION = "l"
private const val STATS_FILE_EXTENSION = "s"

class CollatorsManager(
    private val targetContext: Context,
    private val mainThreadHandler: Handler,
    private val testConfigs: TestConfigs,
    private val screenShotHandler: Handler,
    private val activityMonitor: ActivityMonitor,
    private val appMonitor: AppMonitor,
    private val fileProvider: FileDescriptorProvider,
    private val profilerHandler: Handler,
    private val logWrapper: LogWrapper,
    private val ignoredScreenShotViewProvider: (Activity) -> View?
) {

    private var logFileName: String? = null
    private var profilerFileName: String? = null
    private var screenShotNamePrefix: String? = null
    private var nameCounter = 0

    private val screenShotCollator = ScreenShotCollator(
        testConfigs.getAutoScreenShotFps(),
        mainThreadHandler,
        activityMonitor,
        ScreenShotNameGenerator(),
        ScreenShotterFactory(screenShotHandler).createBestShotter(),
        ScreenShotWriter(testConfigs.getScreenShotQuality(), fileProvider, logWrapper),
        logWrapper,
        ignoredScreenShotViewProvider
    )

    private val logger = Logger(fileProvider, logWrapper)

    private val profileCollator = ProfilerFrameCollator(
        testConfigs.getProfilerSampleFrequency(),
        targetContext,
        fileProvider,
        profilerHandler,
        logWrapper,
        appMonitor,
        activityMonitor
    )

    fun start() {
        logFileName = generateUniqueFileName(LOG_FILE_EXTENSION).apply {
            logger.startLogging(this)
        }
        profilerFileName = generateUniqueFileName(STATS_FILE_EXTENSION).apply {
            profileCollator.start(this)
        }
        screenShotNamePrefix = generateUniqueName().apply {
            if(testConfigs.isAutoScreenShotEnabled()) {
                activityMonitor.registerCallback(screenShotCollator)
                screenShotCollator.start(this)
            }
        }
    }

    fun stop() {
        activityMonitor.unregisterCallback(screenShotCollator)
        screenShotCollator.stop()

        logger.stopLogging()
        profileCollator.stop()

        logFileName = null
        profilerFileName = null
        screenShotNamePrefix = null
    }

    fun restart() {
        stop()
        start()
    }

    private fun generateUniqueFileName(extension: String) =
        "${generateUniqueName()}.${extension}"

    private fun generateUniqueName(): String {
        nameCounter++
        return "${UUID.randomUUID()}${nameCounter}"
    }

    fun getInfo() = CollateInfo(logFileName!!, profilerFileName!!, screenShotNamePrefix!!)
}

data class CollateInfo(
    val logFileName: String,
    val profilerFileName: String,
    val screenShotNamePrefix: String
)