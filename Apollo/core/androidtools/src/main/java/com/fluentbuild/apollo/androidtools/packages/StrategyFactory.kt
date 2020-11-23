package com.fluentbuild.apollo.androidtools.packages

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Handler
import com.fluentbuild.apollo.foundation.android.getActivityManager
import java.util.concurrent.ExecutorService

class StrategyFactory(
    private val appContext: Context,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler
) {

    fun create(
        usePrimary: Boolean,
        packageName: String,
        appFileUri: Uri?,
        timeoutMillis: Long,
        callback: InstallStrategy.Callback
    ): InstallStrategy {
        val iconSize = appContext.getActivityManager().launcherLargeIconSize
        val installAppIcon = Bitmap.createBitmap(iconSize, iconSize, Bitmap.Config.RGB_565)

        return if(usePrimary) {
            PmInstallStrategy(
                appContext,
                mainThreadHandler,
                executorService,
                packageName,
                installAppIcon,
                timeoutMillis,
                callback
            )
        } else {
            IntentInstallStrategy(
                appContext,
                packageName,
                { appFileUri },
                callback
            )
        }
    }
}