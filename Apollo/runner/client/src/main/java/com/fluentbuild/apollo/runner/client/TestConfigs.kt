package com.fluentbuild.apollo.runner.client

import android.os.Bundle
import com.fluentbuild.apollo.runner.*

class TestConfigs(private val arguments: Bundle) {

    fun isObscureWindowEnabled() = arguments.getBoolean(ARG_OBSCURE_WINDOW_ENABLED)

    fun shouldRetrieveTestFiles() = arguments.getBoolean(ARG_RETRIEVE_TEST_FILES)

    fun shouldRetrieveAppFiles() = arguments.getBoolean(ARG_RETRIEVE_APP_FILES)

    fun getTestsCount() = arguments.getInt(ARG_TESTS_COUNT)

    fun getProfilerSampleFrequency() = arguments.getInt(ARG_PROFILER_SAMPLE_FREQUENCY)

    fun isClearDataEnabled() = arguments.getBoolean(ARG_CLEAR_DATA)

    fun isAutoScreenShotEnabled() = arguments.getBoolean(ARG_AUTO_SCREEN_SHOT_ENABLED)

    fun getAutoScreenShotFps() = arguments.getInt(ARG_AUTO_SCREEN_SHOT_FPS)

    fun getScreenShotQuality() = arguments.getInt(ARG_AUTO_SCREEN_QUALITY)
}