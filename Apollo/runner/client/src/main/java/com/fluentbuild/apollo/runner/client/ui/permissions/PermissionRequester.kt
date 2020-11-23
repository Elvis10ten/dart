package com.fluentbuild.apollo.runner.client.ui.permissions

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.Log
import com.fluentbuild.apollo.automation.PermissionAction
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry.getLogWrapper
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry.getUiAutomation
import org.junit.Assert

private const val LOG_TAG = "PermissionRequester"

/**
 * Requests a runtime permission on devices running Android M (API 23) and above.
 *
 *
 * This class is usually used to grant runtime permissions to avoid the permission dialog from
 * showing up and blocking the App's Ui. This is especially helpful for Ui-Testing to avoid loosing
 * control over your application under test.
 *
 *
 * The requested permissions will be granted for all test methods in the test class. Use [.addPermissions] to add a permission to the permission list. To request all
 * permissions use the [.requestPermissions] method.
 *
 *
 * Note: Usually this class would not be used directly, but through [ ].
 *
 *
 * **This API is currently in beta.**
 */
@TargetApi(value = Build.VERSION_CODES.M)
class PermissionRequester(
    private val targetContext: Context
): PermissionGranter {

    private val requestedPermissions = mutableSetOf<String>()

    /**
     * Adds a permission to the list of permissions which will be requested when [.requestPermissions] is called.
     *
     * Precondition: This method does nothing when called on an API level lower than [ ][Build.VERSION_CODES.M].
     *
     * @param permissions a list of Android runtime permissions.
     */
    override fun addPermissions(vararg permissions: String) {
        if (deviceSupportsRuntimePermissions()) {
            for(permission in permissions) {
                check(requestedPermissions.add(permission))
            }
        }
    }

    /**
     * Request all permissions previously added using [.addPermissions]
     *
     * Precondition: This method does nothing when called on an API level lower than [Build.VERSION_CODES.M].
     */
    override fun requestPermissions() {
        if (deviceSupportsRuntimePermissions()) {
            for (permission in requestedPermissions) {
                val actionStatus = getUiAutomation().actionRuntimePermission(
                    targetContext,
                    permission,
                    PermissionAction.GRANT
                )

                if(!actionStatus.wasSuccessful) {
                    Assert.fail("Failed to grant permissions: ${actionStatus.errorText}")
                    return
                }
            }
        }
    }

    private fun deviceSupportsRuntimePermissions(): Boolean {
        val supportsRuntimePermissions = Build.VERSION.SDK_INT >= 23
        if (!supportsRuntimePermissions) {
            getLogWrapper().w(
                LOG_TAG,
                "Ignored! Runtime permissions used on Android API 23 or higher."
            )
        }
        return supportsRuntimePermissions
    }
}
