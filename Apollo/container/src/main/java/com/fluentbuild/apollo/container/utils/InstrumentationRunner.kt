package com.fluentbuild.apollo.container.utils

import android.content.ComponentName
import android.content.Context
import android.content.pm.InstrumentationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File

class InstrumentationRunner(
    private val appContext: Context,
    private val packageManager: PackageManager
) {

    fun getInstrumentations(packageName: String) = packageManager.queryInstrumentation(packageName, 0)

    fun run(instrumentationInfo: InstrumentationInfo): Boolean {
        val componentName = ComponentName(instrumentationInfo.packageName, instrumentationInfo.name)

        val args = Bundle()
        val profileFile = null
        Log.e("dart", "Profile file: " + profileFile)

        return appContext.startInstrumentation(componentName, profileFile, args)
    }
}
