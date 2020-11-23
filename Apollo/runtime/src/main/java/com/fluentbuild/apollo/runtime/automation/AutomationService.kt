package com.fluentbuild.apollo.runtime.automation

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
import android.content.Context
import android.view.accessibility.AccessibilityEvent

class AutomationService: AccessibilityService() {

    internal var onAccessibilityEventListener: ((AccessibilityEvent) -> Unit)? = null

    override fun onServiceConnected() {
        serviceInfo = serviceInfo.apply {
            flags = flags or FLAG_RETRIEVE_INTERACTIVE_WINDOWS
        }

        super.onServiceConnected()
        INSTANCE = this
        onConnectCallback?.invoke()
    }

    override fun onDestroy() {
        super.onDestroy()
        INSTANCE = null
    }

    override fun onInterrupt() {

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        onAccessibilityEventListener?.invoke(event)
    }

    companion object {

        internal var INSTANCE: AutomationService? = null
        internal var onConnectCallback: (() -> Unit)? = null

        fun isEnabled(context: Context) = AccessibilityUtils.isServiceEnabled(context, AutomationService::class.java)
    }
}
