package com.fluentbuild.apollo.foundation.android

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

fun Context.isInstalledAndEnabled(packageName: String): Boolean {
    return try {
        packageManager.getApplicationInfo(packageName, 0).enabled
    } catch (e: PackageManager.NameNotFoundException) {
        false
    }
}

/**
 * Returns true if there is an Activity that can handle this intent
 */
fun Intent.hasCapableActivity(context: Context) =
    resolveActivity(context.packageManager) != null