package com.fluentbuild.apollo.runner.client.overlays

import android.app.Activity
import android.graphics.PixelFormat
import android.view.WindowManager
import com.fluentbuild.apollo.foundation.android.AndroidVersion

internal class WindowOverlay(activity: Activity) {

    private val overlayView = OverlayView(activity)

    init {
        activity.window.addContentView(overlayView.rootView, getWindowParams())
    }

    fun updateLabel(labelText: String) {
        overlayView.updateLabel(labelText)
    }

    fun getRoot() = overlayView.rootView

    private fun getWindowParams(): WindowManager.LayoutParams {
        val type = if(AndroidVersion.isAtLeastOreo()) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            @Suppress("DEPRECATION")
            WindowManager.LayoutParams.TYPE_PHONE
        }

        val formats = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                WindowManager.LayoutParams.FLAG_FULLSCREEN

        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            type,
            formats,
            PixelFormat.TRANSPARENT
        )
    }
}