package com.fluentbuild.apollo.androidtools

import android.view.accessibility.AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
import android.view.accessibility.AccessibilityNodeInfo.ACTION_CLICK
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.automation.UiEvent
import com.fluentbuild.apollo.automation.UiNodeInfo
import timber.log.Timber

class SystemButtonClicker(
    private val packages: Array<String>,
    private val buttonViewId: String,
    private val failureNeedle: String? = null,
    private val clickCondition: () -> Boolean,
    private val onFailed: (Throwable) -> Unit
): UiAutomation.OnAccessibilityEventListener {

    override fun onAccessibilityEvent(event: UiEvent) {
        Timber.v("Received event: %s", event)
        if(event.getEventType() != TYPE_WINDOW_STATE_CHANGED) return
        if(!packages.contains(event.getPackageName())) return

        val source = event.getSource() ?: return
        Timber.v("Event source: %s", source)

        try {
            handleSource(source)
        } catch (e: Exception) {
            Timber.e(e, "Error attempting click")
        } finally {
            source.recycleSafely()
        }
    }

    private fun handleSource(source: UiNodeInfo) {
        source.findAccessibilityNodeInfosByViewId(buttonViewId).forEach { nodeInfo ->
            Timber.v("Node info: %s", nodeInfo)
            if(nodeInfo.isClickable() && nodeInfo.isEnabled()) {
                if(clickCondition()) {
                    Timber.i("Clicking on button: %s", buttonViewId)
                    nodeInfo.performAction(ACTION_CLICK)
                    nodeInfo.recycleSafely()
                }
            }
        }

        if(failureNeedle != null) {
            if (source.findAccessibilityNodeInfosByText(failureNeedle).isNotEmpty()) {
                if (clickCondition()) {
                    onFailed(ParsePackageException())
                }
            }
        }
    }
}

class ParsePackageException: RuntimeException()