package com.fluentbuild.apollo.container.utils

import android.annotation.TargetApi
import android.app.admin.DevicePolicyManager
import android.app.admin.DevicePolicyManager.PERMISSION_GRANT_STATE_DEFAULT
import android.app.admin.DevicePolicyManager.PERMISSION_GRANT_STATE_GRANTED
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.os.UserHandle

class AppPermissioner(
    private val appContext: Context,
    private val devicePolicyManager: DevicePolicyManager
    //private val adminComponent: ComponentName
) {

    @TargetApi(Build.VERSION_CODES.M)
    fun grantRuntimePermissionAsUser(packageName: String, permission: String, userHandle: UserHandle) {
        /*devicePolicyManager.setPermissionGrantState(
            adminComponent,
            packageName,
            permission,
            PERMISSION_GRANT_STATE_GRANTED
        )*/
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun revokeRuntimePermissionAsUser(packageName: String, permission: String, userHandle: UserHandle) {
        /*devicePolicyManager.setPermissionGrantState(
            adminComponent,
            packageName,
            permission,
            PERMISSION_GRANT_STATE_DEFAULT
        )*/
    }
}
