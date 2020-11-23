package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.fluentbuild.apollo.foundation.android.hasCapableActivity
import java.io.File

private const val APK_TYPE = "application/vnd.android.package-archive"

class IntentInstallStrategy(
    private val appContext: Context,
    private val targetPackageName: String,
    private val installAppFileUriProvider: (File) -> Uri?,
    // Callback is used implicitly as a isDisposed check
    private var callback: InstallStrategy.Callback?
): InstallStrategy {

    override fun install(appFile: File) {
        val installIntent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(installAppFileUriProvider(appFile)!!, APK_TYPE)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        if(!installIntent.hasCapableActivity(appContext)) {
            callback?.onError(InstallStrategy.GenericException("No package installers"))
            return
        }

        appContext.startActivity(installIntent)
        callback?.onCompleted()
    }

    override fun uninstall() {
        val packageUri = Uri.parse("package:${targetPackageName}")
        val uninstallIntent = Intent(Intent.ACTION_DELETE, packageUri)
        uninstallIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        if(!uninstallIntent.hasCapableActivity(appContext)) {
            callback?.onError(InstallStrategy.GenericException("No package installers"))
            return
        }

        appContext.startActivity(uninstallIntent)
        callback?.onCompleted()
    }

    override fun dispose() {
        callback = null
    }
}