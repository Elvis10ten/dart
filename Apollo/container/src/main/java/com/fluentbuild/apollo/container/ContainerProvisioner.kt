package com.fluentbuild.apollo.container

import android.annotation.SuppressLint
import android.app.Activity
import android.app.admin.DevicePolicyManager.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.android.getDevicePolicyManager
import com.fluentbuild.apollo.foundation.android.createResourceUri

private const val PROVISION_REQUEST_CODE = 9090

class ContainerProvisioner(
    private val appContext: Context
) {

    private val devicePolicyManager = appContext.getDevicePolicyManager()
    private val packageManager = appContext.packageManager
    private var callback: ProvisionCallback? = null

    fun provision(params: Params, callback: ProvisionCallback) {
        when(getState()) {
            State.NOT_SUPPORTED -> callback.onProvisionFailed(UnsupportedOperationException("Managed profile not supported on device"))
            State.PROVISIONED -> callback.onProvisioned()
            State.NOT_PROVISIONED -> startProvisioning(params, callback)
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int): Boolean {
        if(requestCode == PROVISION_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    callback?.onProvisioned()
                }
                Activity.RESULT_CANCELED -> {
                    // TODO: Cancelled when another profile is deleted
                    callback?.onProvisioningCancelled()
                }
                else -> {
                    callback?.onProvisionFailed(UnsupportedOperationException("Managed profile not supported on device")) // todo
                }
            }

            callback = null
            return true
        }

        return false
    }

    private fun startProvisioning(params: Params, callback: ProvisionCallback) {
        val intent = Intent(ACTION_PROVISION_MANAGED_PROFILE).apply {
            @Suppress("DEPRECATION")
            putExtra(EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME, appContext.packageName)

            if(AndroidVersion.isAtLeastMarshmallow()) {
                putExtra(EXTRA_PROVISIONING_SKIP_ENCRYPTION, true)
                putExtra(EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME, ContainerAdminReceiver.getComponentName(appContext))
            }

            if(AndroidVersion.isAtLeastNougat()) {
                putExtra(EXTRA_PROVISIONING_LOGO_URI, appContext.createResourceUri(params.logoResId))
                putExtra(EXTRA_PROVISIONING_MAIN_COLOR, ContextCompat.getColor(appContext, params.colorResId))
            }

            if(AndroidVersion.isAtLeastOreo()) {
                putExtra(EXTRA_PROVISIONING_SKIP_USER_CONSENT, true)

                val organizationDisclaimer = Bundle().apply {
                    putString(EXTRA_PROVISIONING_DISCLAIMER_HEADER, appContext.getString(params.disclaimerTitle))
                    putParcelable(EXTRA_PROVISIONING_DISCLAIMER_CONTENT, appContext.createResourceUri(params.disclaimerContent))
                }
                putExtra(EXTRA_PROVISIONING_DISCLAIMERS, arrayOf(organizationDisclaimer))
            }
        }

        if (intent.resolveActivity(appContext.packageManager) != null) {
            this.callback = callback
            params.activity.startActivityForResult(intent, PROVISION_REQUEST_CODE)
        } else {
            callback.onProvisionFailed(UnsupportedOperationException("Managed profile not supported on device"))
        }
    }

    fun getState() = when {
        !isContainerSupported() -> State.NOT_SUPPORTED
        !isProvisioned() -> State.NOT_PROVISIONED
        else -> State.PROVISIONED
    }

    @SuppressLint("NewApi")
    private fun isContainerSupported(): Boolean {
        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_MANAGED_USERS)) {
            return false
        }

        return if(AndroidVersion.isAtLeastNougat()) {
            devicePolicyManager.isProvisioningAllowed(ACTION_PROVISION_MANAGED_PROFILE)
        } else {
            true
        }
    }

    private fun isProvisioned() = devicePolicyManager.isProfileOwnerApp(appContext.packageName)

    data class Params(
        @DrawableRes
        val logoResId: Int,
        @ColorRes
        val colorResId: Int,
        @StringRes
        val disclaimerTitle: Int,
        @RawRes
        val disclaimerContent: Int,
        val activity: Activity
    )

    enum class State {
        NOT_SUPPORTED,
        NOT_PROVISIONED,
        PROVISIONED
    }

    interface ProvisionCallback {

        fun onProvisioned()

        fun onProvisioningCancelled()

        fun onProvisionFailed(exception: Exception)
    }
}
