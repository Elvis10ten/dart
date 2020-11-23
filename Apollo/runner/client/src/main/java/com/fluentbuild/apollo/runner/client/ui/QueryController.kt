package com.fluentbuild.apollo.runner.client.ui

import android.util.Log
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry.getLogWrapper
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry.getUiAutomation
import java.util.concurrent.TimeoutException

private const val LOG_TAG = "QueryController"

/**
 * The QueryController main purpose is to translate a {@link UiSelector} selectors to
 * {@link AccessibilityNodeInfo}. This is all this controller does.
 */
object QueryController {

    /**
     * This value has the greatest bearing on the appearance of test execution speeds.
     * This value is used as the minimum time to wait before considering the UI idle after
     * each action.
     */
    private const val QUIET_TIME_TO_BE_CONSIDERED_IDLE_STATE: Long = 500 //ms

    /**
     * Waits for the current application to idle.
     * Default wait timeout is 10 seconds
     */
    fun waitForIdle() {
        waitForIdle(Configurator.waitForIdleTimeout)
    }

    /**
     * Waits for the current application to idle.
     * @param timeout in milliseconds
     */
    fun waitForIdle(timeout: Long) {
        try {
            getUiAutomation().waitForIdle(QUIET_TIME_TO_BE_CONSIDERED_IDLE_STATE, timeout)
        } catch (e: TimeoutException) {
            getLogWrapper().w(LOG_TAG, "Could not detect idle state.")
        }
    }
}