package com.fluentbuild.apollo.runner.base.app

import android.content.Context
import android.provider.Settings
import android.util.Log

private const val ACCELEROMETER_ROTATION_DISABLED = 0
private const val ACCELEROMETER_ROTATION_ENABLED = 1
private const val LOG_TAG = "ScreenRotator"

class ScreenRotator(private val appContext: Context) {

    private var initialAccelerometerRotationSettingsValue: Int
    private var initialUserRotationSettingsValue: Int
    private var hasChanges = false

    init {
        Log.i(LOG_TAG, "Captured initial rotation settings")
        initialAccelerometerRotationSettingsValue = appContext.getSettingsIntValue(Settings.System.ACCELEROMETER_ROTATION)
        initialUserRotationSettingsValue = appContext.getSettingsIntValue(Settings.System.USER_ROTATION)
    }

    fun setRotation(rotation: Int): Boolean {
        Log.i(LOG_TAG, "Setting device rotation to: $rotation")
        hasChanges = true
        return appContext.setUserRotationSetting(rotation)
    }

    fun unfreezeCurrentRotation(): Boolean {
        Log.i(LOG_TAG, "Unfreezing current rotation")
        hasChanges = true
        return appContext.setAccelerometerRotationSetting(ACCELEROMETER_ROTATION_ENABLED)
    }

    fun freezeCurrentRotation(): Boolean {
        Log.i(LOG_TAG, "Freezing current rotation")
        hasChanges = true
        return appContext.setAccelerometerRotationSetting(ACCELEROMETER_ROTATION_DISABLED)
    }

    fun restoreInitialSettings(): Boolean {
        return if(hasChanges) {
            Log.i(LOG_TAG, "Restoring initial rotation settings")
            hasChanges = false
            appContext.setAccelerometerRotationSetting(initialAccelerometerRotationSettingsValue) &&
                    appContext.setUserRotationSetting(initialUserRotationSettingsValue)
        } else {
            true
        }
    }
}

private fun Context.setAccelerometerRotationSetting(value: Int): Boolean {
    return Settings.System.putInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION, value)
}

private fun Context.setUserRotationSetting(rotation: Int): Boolean {
    return Settings.System.putInt(contentResolver, Settings.System.USER_ROTATION, rotation)
}

private fun Context.getSettingsIntValue(name: String) =
    Settings.System.getInt(contentResolver, Settings.System.ACCELEROMETER_ROTATION)