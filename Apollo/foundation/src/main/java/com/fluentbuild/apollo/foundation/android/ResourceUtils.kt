package com.fluentbuild.apollo.foundation.android

import android.content.ContentResolver
import android.content.Context
import android.content.res.ColorStateList
import android.net.Uri
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.createResourceUri(resourceId: Int): Uri {
    return Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(resources.getResourcePackageName(resourceId))
        .appendPath(resources.getResourceTypeName(resourceId))
        .appendPath(resources.getResourceEntryName(resourceId))
        .build()
}

fun Context.createColorStateList(@ColorRes color: Int) =
    ColorStateList.valueOf(ContextCompat.getColor(this, color))

fun Context.toPixelFromDp(value: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)