package com.fluentbuild.apollo.automation

import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Handler
import android.os.Looper
import android.os.RemoteException
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import com.fluentbuild.apollo.foundation.android.LogWrapper

private const val LOG_TAG = "AutomationClient"

internal class AutomationClient(
    private val server: AutomationServer,
    private val log: LogWrapper
) {

    private val mainThreadHandler = Handler(Looper.getMainLooper())
    private var wasRotationChanged = false

    @Throws(RemoteException::class)
    fun setOnAccessibilityEventListener(listener: (UiEvent) -> Unit) {
        val accessibilityEventListener = object: OnAccessibilityEventListener.Stub() {

            override fun onAccessibilityEvent(event: UiEvent) {
                mainThreadHandler.post {
                    event.server = server
                    listener(event)
                }
            }
        }

        server.setOnAccessibilityEventListener(accessibilityEventListener)
    }

    fun restoreInitialRotation(): Boolean {
        if(!wasRotationChanged) {
            return true
        }

        return try {
            wasRotationChanged = false
            server.restoreInitialRotation()
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error restoring initial rotation")
            false
        }
    }

    fun setRotation(rotation: Int): Boolean {
        return try {
            wasRotationChanged = true
            server.setRotation(rotation)
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error setting rotation")
            false
        }
    }

    fun freezeCurrentRotation(): Boolean {
        return try {
            wasRotationChanged = true
            server.freezeCurrentRotation()
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error freezing current rotation")
            false
        }
    }

    fun unfreezeCurrentRotation(): Boolean {
        return try {
            wasRotationChanged = true
            server.unfreezeCurrentRotation()
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error unfreezing current rotation")
            false
        }
    }

    fun performGlobalAction(action: Int): Boolean {
        return try {
            server.performGlobalAction(action)
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while calling performGlobalAction")
            false
        }
    }

    fun findFocus(focus: Int): AccessibilityNodeInfo? {
        return try {
            server.findFocus(focus)
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while calling findFocus")
            null
        }
    }

    fun getServiceInfo(): AccessibilityServiceInfo? {
        return try {
            server.serviceInfo
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while calling getServiceInfo")
            null
        }
    }

    fun setServiceInfo(serviceInfo: AccessibilityServiceInfo) {
        try {
            server.serviceInfo = serviceInfo
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while setting AccessibilityServiceInfo")
        }
    }

    fun getWindows(): List<AccessibilityWindowInfo> {
        return try {
            server.windows
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while getting windows")
            emptyList()
        }
    }

    fun getRootInActiveWindow(): AccessibilityNodeInfo? {
        return try {
            server.rootInActiveWindow
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while getting root in active window")
            null
        }
    }

    fun getLastEvent(): AccessibilityEvent? {
        return try {
            server.lastEvent
        } catch (e: RemoteException) {
            log.e(LOG_TAG, e, "Error while getting last event")
            null
        }
    }

    @Throws(SecurityException::class)
    fun actionRuntimePermission(
        packageName: String,
        permission: String,
        action: PermissionAction
    ): ActionStatus {
        return try {
            server.actionRuntimePermission(
                packageName,
                permission,
                action.id
            )
        } catch (e: RemoteException) {
            throw SecurityException("Error granting runtime permission", e)
        }
    }
}
