package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.os.Handler
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.automation.UiEvent
import com.fluentbuild.apollo.foundation.android.isInstalledAndEnabled
import timber.log.Timber

class UninstallClicker(
    private val appContext: Context,
    private val mainThreadHandler: Handler,
    private val packageName: String
): UiAutomation.OnAccessibilityEventListener {

    private val runnables = mutableListOf<Runnable>()

    override fun onAccessibilityEvent(event: UiEvent) {
        Timber.i("Event: %s", event)
        if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
            SYSTEM_INSTALLERS.contains(event.getPackageName())) {
            Timber.i("Event source: " + event.getSource())
            event.getSource()?.findAccessibilityNodeInfosByViewId("android:id/button1")?.forEach { nodeInfo ->
                if(nodeInfo.isClickable() && nodeInfo.isEnabled()) {
                    Timber.e("Boom: " + nodeInfo)

                    val runnable = object: Runnable {

                        override fun run() {
                            if(appContext.isInstalledAndEnabled(packageName)) {
                                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                            } else {
                                runnables.forEach { mainThreadHandler.removeCallbacks(it) }
                            }
                        }
                    }

                    runnables += runnable
                    mainThreadHandler.postDelayed(runnable, BUTTON_CLICK_DELAY_MILLIS)
                }
            }
        }
    }
}