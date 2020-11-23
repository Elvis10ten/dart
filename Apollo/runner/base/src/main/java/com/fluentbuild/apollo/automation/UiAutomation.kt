package com.fluentbuild.apollo.automation

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.graphics.Bitmap
import android.os.ParcelFileDescriptor
import android.os.SystemClock
import android.view.InputEvent
import android.view.Surface
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityWindowInfo
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.android.isPermissionGranted
import java.util.concurrent.TimeoutException

private const val LOG_TAG = "UiAutomation"

class UiAutomation internal constructor(
    private val client: AutomationClient,
    private val logWrapper: LogWrapper,
    private val disconnector: () -> Unit
) {

    private val lock = Object()

    private var flags: Int = 0
    private var isConnected = true

    private var onAccessibilityEventListener: OnAccessibilityEventListener? = null
    private var wasRotationChanged = false

    init {
        client.setOnAccessibilityEventListener { event ->
            onAccessibilityEventListener?.onAccessibilityEvent(event)
        }
    }

    /**
     * Get the flags used to connect the [AutomationServer].
     *
     * @return The flags used to connect
     */
    fun getFlags() = flags

    fun setFlags(flags: Int?) {
        // todo
    }

    /**
     * Reports if the UiAutomation is connected to the [AutomationServer]
     */
    fun isConnected() = isConnected

    fun disconnect() {
        isConnected = false
        onAccessibilityEventListener = null
        // todo
        disconnector()
        if(wasRotationChanged) {
            client.restoreInitialRotation()
            wasRotationChanged = false
        }
    }

    private fun requireConnected() {
        check(isConnected) { "UiAutomation not connected!" }
    }

    /**
     * Sets a callback for observing the stream of [AccessibilityEvent]s.
     * The callbacks are delivered on the main application thread.
     *
     * @param listener The callback.
     */
    fun setOnAccessibilityEventListener(listener: OnAccessibilityEventListener?) {
        synchronized(lock) {
            onAccessibilityEventListener = listener
        }
    }

    /**
     * Performs a global action. Such an action can be performed at any moment
     * regardless of the current application or user location in that application.
     * For example going back, going home, opening recents, etc.
     *
     * @param action The action to perform.
     * @return Whether the action was successfully performed.
     *
     * @see android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_BACK
     * @see android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_HOME
     * @see android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS
     * @see android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_RECENTS
     */
    fun performGlobalAction(action: Int): Boolean {
        synchronized(lock) {
            requireConnected()
        }
        //todo:here

        return client.performGlobalAction(action)
    }

    /**
     * Find the view that has the specified focus type. The search is performed
     * across all windows.
     * <p>
     * **Note:** In order to access the windows you have to opt-in
     * to retrieve the interactive windows by setting the
     * [AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS] flag.
     * Otherwise, the search will be performed only in the active window.
     * </p>
     *
     * @param focus The focus to find. One of [AccessibilityNodeInfo.FOCUS_INPUT] or
     * [AccessibilityNodeInfo.FOCUS_ACCESSIBILITY].
     * @return The node info of the focused view or null.
     *
     * @see AccessibilityNodeInfo.FOCUS_INPUT
     *
     * @see AccessibilityNodeInfo.FOCUS_ACCESSIBILITY
     */
    fun findFocus(focus: Int): AccessibilityNodeInfo? {
        synchronized(lock) {
            requireConnected()
        }

        return client.findFocus(focus)
    }

    /**
     * Gets the an {@link AccessibilityServiceInfo} describing this UiAutomation.
     * This method is useful if one wants to change some of the dynamically
     * configurable properties at runtime.
     *
     * @return The accessibility service info.
     *
     * @see AccessibilityServiceInfo
     */
    fun getServiceInfo(): AccessibilityServiceInfo? {
        synchronized(lock) {
            requireConnected()
        }

        return client.getServiceInfo()
    }

    /**
     * Sets the {@link AccessibilityServiceInfo} that describes how this
     * UiAutomation will be handled by the platform accessibility layer.
     *
     * @param serviceInfo The info.
     *
     * @see AccessibilityServiceInfo
     */
    fun setServiceInfo(serviceInfo: AccessibilityServiceInfo) {
        synchronized(lock) {
            requireConnected()
        }

        client.setServiceInfo(serviceInfo)
    }

    /**
     * Gets the windows on the screen. This method returns only the windows
     * that a sighted user can interact with, as opposed to all windows.
     * For example, if there is a modal dialog shown and the user cannot touch
     * anything behind it, then only the modal window will be reported
     * (assuming it is the top one). For convenience the returned windows
     * are ordered in a descending layer order, which is the windows that
     * are higher in the Z-order are reported first.
     * <p>
     * <strong>Note:</strong> In order to access the windows you have to opt-in
     * to retrieve the interactive windows by setting the
     * {@link AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS} flag.
     * </p>
     *
     * @return The windows if there are windows such, otherwise an empty list.
     */
    fun getWindows(): List<AccessibilityWindowInfo> {
        synchronized(lock) {
            requireConnected()
        }

        return client.getWindows()
    }

    /**
     * Gets the root {@link AccessibilityNodeInfo} in the active window.
     *
     * @return The root info or null if an error occurred
     */
    fun getRootInActiveWindow(): AccessibilityNodeInfo? {
        synchronized(lock) {
            requireConnected()
        }

        return client.getRootInActiveWindow()
    }

    /**
     * A method for injecting an arbitrary input event.
     * <p>
     * <strong>Note:</strong> It is caller's responsibility to recycle the event.
     * </p>
     * @param event The event to inject.
     * @param sync Whether to inject the event synchronously.
     * @return Whether event injection succeeded.
     */
    fun injectInputEvent(event: InputEvent, sync: Boolean): Boolean {
        synchronized(lock) {
            requireConnected()
        }

        TODO("Figure out how to inject input events")
    }

    /**
     * Sets the device rotation. A client can freeze the rotation in
     * desired state or freeze the rotation to its current state or
     * unfreeze the rotation (rotating the device changes its rotation state).
     *
     * @param rotation The desired rotation.
     * @return Whether the rotation was set successfully.
     *
     * @see [ROTATION_FREEZE_0]
     * @see [ROTATION_FREEZE_90]
     * @see [ROTATION_FREEZE_180]
     * @see [ROTATION_FREEZE_270]
     * @see [ROTATION_FREEZE_CURRENT]
     * @see [ROTATION_UNFREEZE]
     */
    fun setRotation(rotation: Int): Boolean {
        synchronized(lock) {
            requireConnected()
        }

        return when (rotation) {
            ROTATION_UNFREEZE -> client.unfreezeCurrentRotation()
            ROTATION_FREEZE_CURRENT -> client.freezeCurrentRotation()
            ROTATION_FREEZE_0, ROTATION_FREEZE_90, ROTATION_FREEZE_180, ROTATION_FREEZE_270 -> client.setRotation(rotation)
            else -> throw IllegalArgumentException("Invalid rotation.")
        }
    }

    /**
     * Executes a command and waits for a specific accessibility event up to a
     * given wait timeout. To detect a sequence of events one can implement a
     * filter that keeps track of seen events of the expected sequence and
     * returns true after the last event of that sequence is received.
     * <p>
     * <strong>Note:</strong> It is caller's responsibility to recycle the returned event.
     * </p>
     * @param command The command to execute.
     * @param filter Filter that recognizes the expected event.
     * @param timeoutMillis The wait timeout in milliseconds.
     *
     * @throws TimeoutException If the expected event is not received within the timeout.
     */
    fun executeAndWaitForEvent(command: Runnable, filter: AccessibilityEventFilter, timeoutMillis: Long): AccessibilityEvent? {
        synchronized(lock) {
            requireConnected()
        }
        //todo:here
        return null
    }

    /**
     * Waits for the accessibility event stream to become idle, which is not to
     * have received an accessibility event within <code>idleTimeoutMillis</code>.
     * The total time spent to wait for an idle accessibility event stream is bounded
     * by the <code>globalTimeoutMillis</code>.
     *
     * @param idleTimeoutMillis The timeout in milliseconds between two events
     *            to consider the device idle.
     * @param globalTimeoutMillis The maximal global timeout in milliseconds in
     *            which to wait for an idle state.
     *
     * @throws TimeoutException If no idle state was detected within
     *            <code>globalTimeoutMillis.</code>
     */
    @Throws(TimeoutException::class)
    fun waitForIdle(idleTimeoutMillis: Long, globalTimeoutMillis: Long) {
        //todo:here
        synchronized(lock) {
            requireConnected()

            val startTimeMillis = SystemClock.uptimeMillis()

            while(true) {
                val currentTimeMillis = SystemClock.uptimeMillis()

                // Did we get idle state within the global timeout?
                val elapsedGlobalTimeMillis = currentTimeMillis - startTimeMillis
                val remainingGlobalTimeMillis = globalTimeoutMillis - elapsedGlobalTimeMillis
                if (remainingGlobalTimeMillis <= 0) {
                    throw TimeoutException("No idle state with idle timeout: $idleTimeoutMillis within global timeout: $globalTimeoutMillis")
                }

                val lastEventTimeMillis = client.getLastEvent()?.eventTime ?: startTimeMillis
                // Did we get an idle state within the idle timeout?
                val elapsedIdleTimeMillis = currentTimeMillis - lastEventTimeMillis
                val remainingIdleTimeMillis = idleTimeoutMillis - elapsedIdleTimeMillis
                if (remainingIdleTimeMillis <= 0) {
                    return
                }

                try {
                    lock.wait(remainingIdleTimeMillis)
                } catch (ignored: InterruptedException) {}
            }
        }
    }

    fun takeScreenshot(): Bitmap {
        synchronized(lock) {
            requireConnected()
        }

        TODO("Copy implementation")
    }

    fun broadcastMonkeyRunState(monkeyEnabled: Boolean) {
        synchronized(lock) {
            requireConnected()
        }

        TODO("Clone of setRunAsMonkey, instead of setting in the ActivityManager, send a sticky broadcast")
    }

    /**
     * Actions a runtime permission to a package.
     * @param packageName The package to which to grant.
     * @param permission The permission to grant.
     * @throws SecurityException if unable to grant the permission.
     */
    @Throws(SecurityException::class)
    fun actionRuntimePermission(
        context: Context,
        permission: String,
        action: PermissionAction
    ): ActionStatus {
        synchronized(lock) {
            requireConnected()
        }
        //todo:here

        if(context.isPermissionGranted(permission)) {
            return ActionStatus(true, "Permission already granted")
        }

        logWrapper.i(LOG_TAG, "$action runtime permission: $permission")
        return client.actionRuntimePermission(context.packageName, permission, action)
    }

    /**
     * Executes a shell command. This method returns a file descriptor that points
     * to the standard output stream. The command execution is similar to running
     * "adb shell <command>" from a host connected to the device.
     * <p>
     * <strong>Note:</strong> It is your responsibility to close the returned file
     * descriptor once you are done reading.
     * </p>
     *
     * @param command The command to execute.
     * @return A file descriptor to the standard output stream.
     *
     * @see #adoptShellPermissionIdentity()
     */
    fun executeShellCommand(command: String?): ParcelFileDescriptor {
        TODO("Copy implementation")
    }

    /**
     * Listener for observing the [AccessibilityEvent] stream.
     */
    interface OnAccessibilityEventListener {
        /**
         * Callback for receiving an [AccessibilityEvent].
         *
         * **Note:** It is responsibility of the client to recycle the received events to minimize object creation.
         *
         * @param event The received event.
         */
        fun onAccessibilityEvent(event: UiEvent)
    }

    /**
     * Listener for filtering accessibility events.
     */
    interface AccessibilityEventFilter {
        /**
         * Callback for determining whether an event is accepted or
         * it is filtered out.
         *
         * @param event The event to process.
         * @return True if the event is accepted, false to filter it out.
         */
        fun accept(event: AccessibilityEvent): Boolean
    }

    companion object {
        /** Rotation constant: Unfreeze rotation (rotating the device changes its rotation state).  */
        const val ROTATION_UNFREEZE = -2

        /** Rotation constant: Freeze rotation to its current state.  */
        const val ROTATION_FREEZE_CURRENT = -1

        /** Rotation constant: Freeze rotation to 0 degrees (natural orientation)  */
        const val ROTATION_FREEZE_0 = Surface.ROTATION_0

        /** Rotation constant: Freeze rotation to 90 degrees .  */
        const val ROTATION_FREEZE_90 = Surface.ROTATION_90

        /** Rotation constant: Freeze rotation to 180 degrees .  */
        const val ROTATION_FREEZE_180 = Surface.ROTATION_180

        /** Rotation constant: Freeze rotation to 270 degrees .  */
        const val ROTATION_FREEZE_270 = Surface.ROTATION_270

        // todo with connection logic
        /**
         * UiAutomation supresses accessibility services by default. This flag specifies that
         * existing accessibility services should continue to run, and that new ones may start.
         * This flag is set when obtaining the UiAutomation from
         * {@link Instrumentation#getUiAutomation(int)}.
         */
        const val FLAG_DONT_SUPPRESS_ACCESSIBILITY_SERVICES = 0x00000001
    }
}
