package com.fluentbuild.apollo.runner.client.ui.permissions

import android.os.Build

/**
 * Requests a runtime permission.
 *
 * Note: This class should not be used directly, but through [GrantPermissionRule].
 */
interface PermissionGranter {

    /**
     * Adds a permission to the list of permissions which will be requested when [.requestPermissions] is called.
     *
     * Precondition: This method does nothing when called on an API level lower than [Build.VERSION_CODES.M].
     *
     * @param permissions a list of Android runtime permissions.
     */
    fun addPermissions(vararg permissions: String)

    /**
     * Request all permissions previously added using [.addPermissions]
     *
     * Precondition: This method does nothing when called on an API level lower than [ ][Build.VERSION_CODES.M].
     */
    fun requestPermissions()
}