package com.fluentbuild.apollo.runner.client.ui

import android.view.accessibility.AccessibilityEvent
import com.fluentbuild.apollo.automation.UiAutomation

/**
 * Predicate for waiting for any of the events specified in the mask
 */
internal class WaitForAnyEventPredicate(
    private val mask: Int
): UiAutomation.AccessibilityEventFilter {

    override fun accept(t: AccessibilityEvent): Boolean {
        // check current event in the list
        return t.eventType and mask != 0
    }
}