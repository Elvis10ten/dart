package com.fluentbuild.apollo.runtime.automation

import android.content.Context
import android.content.Intent
import android.provider.Settings

fun Context.openAccessibilitySettings() {
    Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).let {
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(it)
    }
}
