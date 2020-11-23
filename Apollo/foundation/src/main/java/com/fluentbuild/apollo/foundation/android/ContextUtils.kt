package com.fluentbuild.apollo.foundation.android

import android.app.ActivityManager
import android.app.Application
import android.app.NotificationManager
import android.app.Service
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.media.projection.MediaProjectionManager
import android.os.Build
import android.os.Bundle
import android.os.health.SystemHealthManager
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import androidx.annotation.RequiresApi

fun Context.getDevicePolicyManager() = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

fun Context.getWindowManager() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

fun Context.getMediaProjectionManager() = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

fun Context.getActivityManager() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

fun Context.getAccessibilityManager() = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

fun Context.getNotificationManager() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

@RequiresApi(Build.VERSION_CODES.N)
fun Context.getSystemHealthService() = getSystemService(Context.SYSTEM_HEALTH_SERVICE) as SystemHealthManager

fun Context.requireServiceBind(intent: Intent, serviceConnection: ServiceConnection) {
    if (!bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE)) {
        throw RuntimeException("Cannot connect to: ${intent.component}")
    }
}

fun Context.requireInstrumentationStart(
    componentName: ComponentName,
    profileFilePath: String?,
    args: Bundle
) {
    if(!startInstrumentation(componentName, profileFilePath, args)) {
        throw RuntimeException("Failed to start: $componentName")
    }
}

fun Context.getApplication() = applicationContext as Application

fun Context.isPermissionGranted(permission: String): Boolean {
    return PackageManager.PERMISSION_GRANTED == checkCallingOrSelfPermission(permission)
}