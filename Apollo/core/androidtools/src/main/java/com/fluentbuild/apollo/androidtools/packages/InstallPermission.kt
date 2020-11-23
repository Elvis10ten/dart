package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import android.provider.Settings.Secure

class InstallPermission(
    private val appContext: Context
) {

    fun request() {
        val intent = if(AndroidVersion.isAtLeastOreo()) {
            Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES).apply {
                data = Uri.parse("package:${appContext.packageName}")
            }
        } else {
            Intent(Settings.ACTION_SECURITY_SETTINGS)
        }

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        appContext.startActivity(intent)
    }

    fun has(): Boolean {
        return if(AndroidVersion.isAtLeastOreo()) {
            appContext.packageManager.canRequestPackageInstalls()
        } else {
            @Suppress("DEPRECATION")
            Secure.getInt(appContext.contentResolver, Secure.INSTALL_NON_MARKET_APPS) == 1
        }
    }

    @Throws(NotGrantedException::class)
    internal fun require() {
        if (!has()) {
            throw NotGrantedException()
        }
    }

    class NotGrantedException: SecurityException()
}