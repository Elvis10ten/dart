package com.fluentbuild.apollo.runner.base.display

import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

class DisplayProperties(
    val width: Int,
    val height: Int,
    val densityDpi: Int
)

/**
 * Return the properties of the display that this [WindowManager] instance uses by default.
 * This is not necessarily the primary display of the system (but it is most times).
 */
fun WindowManager.getDefaultDisplayProps(): DisplayProperties {
    val metrics = DisplayMetrics().apply(defaultDisplay::getRealMetrics)
    val size = Point().apply(defaultDisplay::getRealSize)

    return DisplayProperties(
        size.x,
        size.y,
        metrics.densityDpi
    )
}
