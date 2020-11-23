package com.fluentbuild.apollo.runner.client.interrupts

import android.os.Build
import android.view.*
import android.view.accessibility.AccessibilityEvent
import androidx.annotation.RequiresApi

/**
 * A simple decorator stub for Window.Callback that passes through any calls
 * to the wrapped instance as a base implementation. Call super.foo() to call into
 * the wrapped callback for any subclasses.
 *
 */
open class WindowCallbackWrapper(
    private val wrapped: Window.Callback
): Window.Callback {

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return wrapped.dispatchKeyEvent(event)
    }

    override fun dispatchKeyShortcutEvent(event: KeyEvent): Boolean {
        return wrapped.dispatchKeyShortcutEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        return wrapped.dispatchTouchEvent(event)
    }

    override fun dispatchTrackballEvent(event: MotionEvent): Boolean {
        return wrapped.dispatchTrackballEvent(event)
    }

    override fun dispatchGenericMotionEvent(event: MotionEvent): Boolean {
        return wrapped.dispatchGenericMotionEvent(event)
    }

    override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent): Boolean {
        return wrapped.dispatchPopulateAccessibilityEvent(event)
    }

    override fun onCreatePanelView(featureId: Int): View? {
        return wrapped.onCreatePanelView(featureId)
    }

    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
        return wrapped.onCreatePanelMenu(featureId, menu)
    }

    override fun onPreparePanel(
        featureId: Int,
        view: View,
        menu: Menu
    ): Boolean {
        return wrapped.onPreparePanel(featureId, view, menu)
    }

    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
        return wrapped.onMenuOpened(featureId, menu)
    }

    override fun onMenuItemSelected(
        featureId: Int,
        item: MenuItem
    ): Boolean {
        return wrapped.onMenuItemSelected(featureId, item)
    }

    override fun onWindowAttributesChanged(attrs: WindowManager.LayoutParams) {
        wrapped.onWindowAttributesChanged(attrs)
    }

    override fun onContentChanged() {
        wrapped.onContentChanged()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        wrapped.onWindowFocusChanged(hasFocus)
    }

    override fun onAttachedToWindow() {
        wrapped.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        wrapped.onDetachedFromWindow()
    }

    override fun onPanelClosed(featureId: Int, menu: Menu) {
        wrapped.onPanelClosed(featureId, menu)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSearchRequested(searchEvent: SearchEvent): Boolean {
        return wrapped.onSearchRequested(searchEvent)
    }

    override fun onSearchRequested(): Boolean {
        return wrapped.onSearchRequested()
    }

    override fun onWindowStartingActionMode(callback: ActionMode.Callback): ActionMode? {
        return wrapped.onWindowStartingActionMode(callback)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onWindowStartingActionMode(
        callback: ActionMode.Callback,
        type: Int
    ): ActionMode? {
        return wrapped.onWindowStartingActionMode(callback, type)
    }

    override fun onActionModeStarted(mode: ActionMode) {
        wrapped.onActionModeStarted(mode)
    }

    override fun onActionModeFinished(mode: ActionMode) {
        wrapped.onActionModeFinished(mode)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onProvideKeyboardShortcuts(
        data: List<KeyboardShortcutGroup>,
        menu: Menu?,
        deviceId: Int
    ) {
        wrapped.onProvideKeyboardShortcuts(data, menu, deviceId)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onPointerCaptureChanged(hasCapture: Boolean) {
        wrapped.onPointerCaptureChanged(hasCapture)
    }
}