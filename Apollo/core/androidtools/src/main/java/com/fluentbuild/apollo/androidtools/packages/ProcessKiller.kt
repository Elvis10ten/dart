package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.content.pm.PackageInfo
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.android.getActivityManager
import com.fluentbuild.apollo.foundation.async.requireMainThread
import timber.log.Timber

class ProcessKiller(
    private val appContext: Context
) {

    @MainThread
    fun killAll() {
        requireMainThread()
        val myPackageName = appContext.packageName
        val activityManager = appContext.getActivityManager()

        appContext.packageManager.getInstalledPackages(0).forEach { packageInfo ->
            if(packageInfo.canKill(myPackageName)) {
                Timber.d("Killing package: %s", packageInfo)
                activityManager.killBackgroundProcesses(packageInfo.packageName)
            }
        }
    }
}

private fun PackageInfo.canKill(myPackageName: String) =
    !isSystemPackage() && packageName != myPackageName