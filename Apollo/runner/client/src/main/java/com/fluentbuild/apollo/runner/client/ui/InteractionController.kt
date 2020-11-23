package com.fluentbuild.apollo.runner.client.ui

import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry.getUiAutomation

/**
 * The InteractionProvider is responsible for injecting user events such as touch events
 * (includes swipes) and text key events into the system. To do so, all it needs to know about
 * are coordinates of the touch events and text for the text input events.
 * The InteractionController performs no synchronization. It will fire touch and text input events
 * as fast as it receives them. All idle synchronization is performed prior to querying the
 * hierarchy. See {@link QueryController}
 */
object InteractionController {

    fun performGlobalActionAndWaitForEvent(
        action: Int,
        eventType: Int,
        timeoutMillis: Long
    ): Boolean {
        return UiAutomatorRegistry.getUiAutomation().executeAndWaitForEvent(
            Runnable { performGlobalAction(action) },
            WaitForAnyEventPredicate(eventType),
            timeoutMillis
        ) != null
    }

    fun performGlobalAction(
        action: Int
    ): Boolean {
        return getUiAutomation().performGlobalAction(action)
    }
}