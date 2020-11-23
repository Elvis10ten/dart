package com.fluentbuild.apollo.androidtools.packages

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.os.SystemClock
import com.fluentbuild.apollo.foundation.async.ConditionalWatcher
import timber.log.Timber

internal const val BUTTON_CLICK_DELAY_MILLIS = 500L

val SYSTEM_INSTALLERS = arrayOf(
    "com.google.android.packageinstaller",
    "com.android.packageinstaller"
)

const val INSTALLER_CLICK_FAILURE_NEEDLE = "Parse error"
const val INSTALLER_CLICK_BUTTON_VIEW_ID = "android:id/button1"

fun PackageInfo.isSystemPackage(): Boolean {
    return applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
}

internal fun waitForCondition(
    condition: () -> Boolean,
    elapsedStartTimeMillis: Long,
    timeoutMillis: Long,
    callback: (Result<Unit>) -> Unit
) {
    val timeoutLeft = timeoutMillis - (SystemClock.elapsedRealtime() - elapsedStartTimeMillis)
    if(timeoutLeft > timeoutMillis) {
        callback(Result.failure(InstallStrategy.TimeoutException(timeoutMillis)))
        return
    }

    try {
        ConditionalWatcher(
            condition,
            { InstallStrategy.TimeoutException(it) },
            timeoutLeft
        ).waitForCondition()

        callback(Result.success(Unit))
    } catch (e: Exception) {
        callback(Result.failure(e))
    }
}