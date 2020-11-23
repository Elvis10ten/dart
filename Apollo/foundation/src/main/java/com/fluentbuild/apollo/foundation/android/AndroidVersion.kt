package com.fluentbuild.apollo.foundation.android

import android.os.Build

/**
 * Utility to check Android versions
 */
object AndroidVersion {

    @JvmStatic
    fun isAtLeastMarshmallow() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    @JvmStatic
    fun isAtLeastNougat() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

    @JvmStatic
    fun isAtLeastOreo() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    @JvmStatic
    fun isAtLeastPie() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    @JvmStatic
    fun isAtLeastTen() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
}
