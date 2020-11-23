package com.fluentbuild.apollo.runner.client.ui

import android.accessibilityservice.AccessibilityService
import android.os.RemoteException
import android.view.accessibility.AccessibilityEvent

object UiDevice {

    // Sometimes HOME and BACK key presses will generate no events if already on
    // home page or there is nothing to go back to, Set low timeouts.
    private const val KEY_PRESS_EVENT_TIMEOUT = 1 * 1000.toLong()

    /**
     * Simulates a short press on the HOME button.
     * @return true if successful, else return false
     * @since API Level 16
     */
    fun pressHome(): Boolean {
        waitForIdle()

        return InteractionController.performGlobalActionAndWaitForEvent(
            AccessibilityService.GLOBAL_ACTION_HOME,
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED,
            KEY_PRESS_EVENT_TIMEOUT
        )
    }

    /**
     * Simulates a short press on the BACK button.
     * @return true if successful, else return false
     * @since API Level 16
     */
    fun pressBack(): Boolean {
        waitForIdle()

        return InteractionController.performGlobalActionAndWaitForEvent(
            AccessibilityService.GLOBAL_ACTION_BACK,
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED,
            KEY_PRESS_EVENT_TIMEOUT
        )
    }

    /**
     * Simulates a short press on the Recent Apps button.
     *
     * @return true if successful, else return false
     * @since API Level 16
     */
    fun pressRecentApps(): Boolean {
        waitForIdle()
        return InteractionController.performGlobalAction(
            AccessibilityService.GLOBAL_ACTION_BACK
        )
    }

    /**
     * Waits for the current application to idle.
     * Default wait timeout is 10 seconds
     * @since API Level 16
     */
    fun waitForIdle() {
        QueryController.waitForIdle()
    }
}