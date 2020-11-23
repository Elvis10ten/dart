package com.fluentbuild.apollo.foundation.android

import android.graphics.Color
import android.graphics.Point
import android.view.View

fun View.setAutoFillHintsCompat(vararg autoFillHints: String) {
    if(AndroidVersion.isAtLeastOreo()) {
        setAutofillHints(*autoFillHints)
    }
}

fun View.setPadding(paddingDp: Float) {
    context.toPixelFromDp(paddingDp).toInt().let { paddingPixel ->
        setPadding(paddingPixel, paddingPixel, paddingPixel, paddingPixel)
    }
}

fun View.setBackgroundColor(colorHex: String) {
    setBackgroundColor(Color.parseColor(colorHex))
}

fun View.getStartCoordinates(): Point {
    val coordinates = IntArray(2)
    getLocationOnScreen(coordinates)
    return Point(coordinates[0], coordinates[1])
}