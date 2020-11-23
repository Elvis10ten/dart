package com.fluentbuild.apollo.runtime.automation

import android.accessibilityservice.AccessibilityServiceInfo
import android.graphics.Bitmap
import android.os.Binder
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import com.fluentbuild.apollo.androidtools.SystemButtonClicker
import com.fluentbuild.apollo.automation.*
import com.fluentbuild.apollo.container.utils.AppPermissioner
import com.fluentbuild.apollo.runner.base.app.ScreenRotator
import com.fluentbuild.apollo.runner.base.display.ScreenViewer
import timber.log.Timber
import kotlin.Exception

// todo: inspect AccessibilityInteractionClient, more work to be done
class UiAutomationServer(
    private val screenRotator: ScreenRotator,
    private val screenViewer: ScreenViewer,
    private val appPermissioner: AppPermissioner
): AutomationServer.Stub() {

    var lastAccessibilityEvent: AccessibilityEvent? = null
    var accessibilityEventListener: OnAccessibilityEventListener? = null
    private var internalAccessibilityEventListener: UiAutomation.OnAccessibilityEventListener? = null

    private val uiEventCache = mutableMapOf<Long, UiEvent>()
    private val uiNodeInfoCache = mutableMapOf<Long, UiNodeInfo>()

    fun onAccessibilityEvent(event: AccessibilityEvent) {
        lastAccessibilityEvent = event

        val uiEvent = addUiEvent(event)
        uiEvent.server = this
        internalAccessibilityEventListener?.onAccessibilityEvent(uiEvent)
        accessibilityEventListener?.onAccessibilityEvent(uiEvent)
    }

    override fun setOnAccessibilityEventListener(listener: OnAccessibilityEventListener?) {
        accessibilityEventListener = listener
    }

    override fun findFocus(focus: Int) =
        runWithOriginalIdentity { AutomationService.INSTANCE?.findFocus(focus) }

    override fun performGlobalAction(action: Int) =
        runWithOriginalIdentity { AutomationService.INSTANCE?.performGlobalAction(action) ?: false }

    override fun getLastEvent() = lastAccessibilityEvent

    override fun setRotation(rotation: Int) =
        runWithOriginalIdentity { screenRotator.setRotation(rotation) }

    override fun unfreezeCurrentRotation() =
        runWithOriginalIdentity { screenRotator.unfreezeCurrentRotation() }

    override fun freezeCurrentRotation() =
        runWithOriginalIdentity { screenRotator.freezeCurrentRotation() }


    override fun restoreInitialRotation() =
        runWithOriginalIdentity { screenRotator.restoreInitialSettings() }

    override fun getWindows(): List<AccessibilityWindowInfo> =
        runWithOriginalIdentity { AutomationService.INSTANCE?.windows ?: emptyList() }

    override fun findAccessibilityNodeInfosByText(nodeInfo: UiNodeInfo, text: String): List<UiNodeInfo> {
        return try {
            nodeInfo.accessibilityNodeInfo.findAccessibilityNodeInfosByText(text).map {
                addUiNodeInfo(it)
            }
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }

    override fun findAccessibilityNodeInfosByViewId(nodeInfo: UiNodeInfo, viewId: String): List<UiNodeInfo> {
        return try {
            nodeInfo.accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(viewId).map {
                addUiNodeInfo(it)
            }
        } catch (e: Exception) {
            Timber.e(e)
            emptyList()
        }
    }

    override fun performNodeAction(nodeInfo: UiNodeInfo, action: Int): Boolean {
        return nodeInfo.accessibilityNodeInfo.performAction(action)
    }

    override fun getUiEventSource(event: UiEvent): UiNodeInfo? {
        return event.accessibilityEvent.source?.let { addUiNodeInfo(it) }
    }

    override fun getRootInActiveWindow() =
        runWithOriginalIdentity { AutomationService.INSTANCE?.rootInActiveWindow }

    override fun getServiceInfo() =
        runWithOriginalIdentity { AutomationService.INSTANCE?.serviceInfo }

    override fun setServiceInfo(serviceInfo: AccessibilityServiceInfo): Boolean {
        return runWithOriginalIdentity {
            AutomationService.INSTANCE?.let {
                // TODO: Security on ServiceInfo from clients. This maybe should be validated/restricted.
                it.serviceInfo = serviceInfo
                return@runWithOriginalIdentity true
            }

            return@runWithOriginalIdentity false
        }
    }

    private val handler = Handler()

    override fun actionRuntimePermission(
        packageName: String?,
        permission: String?,
        actionId: Int
    ): ActionStatus {
        internalAccessibilityEventListener = SystemButtonClicker(
            PERMISSION_REQUESTER_PACKAGES,
            PERMISSION_BUTTON_ID,
            null,
            { true },
            { }
        )

        handler.postDelayed({
            internalAccessibilityEventListener = null
        }, 60_000)
        return ActionStatus(true, "fafaf")
        /*return runWithOriginalIdentity {
            return@runWithOriginalIdentity try {
                appPermissioner.grantRuntimePermissionAsUser(packageName, permission, userHandle)
                com.fluentbuild.apollo.automation.ActionStatus(true)
            } catch (e: Exception) {
                Timber.e(e, "Error granting runtime permission as user")
                com.fluentbuild.apollo.automation.ActionStatus(false, e.message)
            }
        }*/
    }

    override fun takeScreenshot(): Bitmap? {
        return try {
            screenViewer.capture()
        } catch (e: Exception) {
            Timber.e(e, "Failed to take screenshot")
            null
        }
    }

    private fun addUiEvent(accessibilityEvent: AccessibilityEvent): UiEvent {
        val id = SystemClock.elapsedRealtimeNanos()
        val uiEvent = UiEvent(id, AccessibilityEvent.obtain(accessibilityEvent))
        uiEventCache[id] = uiEvent
        return uiEvent
    }

    private fun addUiNodeInfo(accessibilityNodeInfo: AccessibilityNodeInfo): UiNodeInfo {
        val id = SystemClock.elapsedRealtimeNanos()
        val uiNodeInfo = UiNodeInfo(id, AccessibilityNodeInfo.obtain(accessibilityNodeInfo))
        uiNodeInfoCache[id] = uiNodeInfo
        return uiNodeInfo
    }

    override fun recycleNodeInfo(nodeInfo: UiNodeInfo) {
        // todo
        uiNodeInfoCache.remove(nodeInfo.id)
    }

    override fun recycleEvent(event: UiEvent) {
        // todo
        uiNodeInfoCache.remove(event.id)
    }
}

inline fun <R> runWithOriginalIdentity(action: () -> R): R {
    Binder.clearCallingIdentity()
    val identity = Binder.clearCallingIdentity()
    try {
        return action()
    } finally {
        Binder.restoreCallingIdentity(identity)
    }
}
