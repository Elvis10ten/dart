package com.fluentbuild.apollo.runtime.helpers

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import java.io.File

internal const val INSTALL_UNINSTALL_REPORT_DELAY_MILLIS = 1000L

class ApkHelper(
    private val appContext: Context,
    private val fileProviderAuthority: String
) {

    fun getUri(appFile: File): Uri {
        return  if(AndroidVersion.isAtLeastNougat()) {
            FileProvider.getUriForFile(appContext, fileProviderAuthority, appFile)
        } else {
            Uri.fromFile(appFile)
        }
    }
}