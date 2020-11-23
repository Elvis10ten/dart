package com.fluentbuild.apollo.runner.base.display

import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.projection.MediaProjection
import android.os.Handler
import android.util.Log
import android.view.Surface

private const val FLAGS = DisplayManager.VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY or DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC
private const val LOG_TAG = "VirtualDisplayUtils"

internal fun MediaProjection.createVirtualDisplay(
    name: String,
    displayProps: DisplayProperties,
    surface: Surface,
    handler: Handler?,
    stoppedCallback: () -> Unit
): VirtualDisplay {
    return createVirtualDisplay(
        name,
        displayProps.width,
        displayProps.height,
        displayProps.densityDpi,
        FLAGS,
        surface,
        object: VirtualDisplay.Callback() {

            override fun onPaused() {
                Log.v(LOG_TAG, "Virtual display paused")
            }

            override fun onResumed() {
                Log.v(LOG_TAG, "Virtual display resumed")
            }

            override fun onStopped() {
                Log.i(LOG_TAG, "Virtual display stopped")
                stoppedCallback()
            }
        },
        handler
    )
}
