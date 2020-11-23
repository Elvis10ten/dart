package com.fluentbuild.apollo.work.props

import android.os.Build
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.work.OsPropertiesProto

internal class OsPropsProvider {

    fun get(): OsPropertiesProto.OsProperties {
        val previewSdkNumber = if(AndroidVersion.isAtLeastMarshmallow()) Build.VERSION.PREVIEW_SDK_INT else 0
        val securityPatch = if(AndroidVersion.isAtLeastMarshmallow()) Build.VERSION.SECURITY_PATCH else ""

        return OsPropertiesProto.OsProperties.newBuilder()
            .setSdkNumber(Build.VERSION.SDK_INT)
            .setPreviewSdkNumber(previewSdkNumber)
            .setSecurityPatch(securityPatch)
            .setIncremental(Build.VERSION.INCREMENTAL)
            .setCodeName(Build.VERSION.CODENAME)
            .setRelease(Build.VERSION.RELEASE)
            .build()
    }
}