package com.fluentbuild.apollo.runner.client.tasks

import android.content.Context
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.client.TestConfigs

private const val LOG_TAG = "ClearDataTask"

class ClearDataTask(
    private val targetContext: Context,
    private val logWrapper: LogWrapper
): Task {

    override fun run() {
        logWrapper.v(LOG_TAG, "Deleting files dir")
        targetContext.filesDir.deleteRecursively()

        logWrapper.v(LOG_TAG, "Deleting cacheDir dir")
        targetContext.cacheDir.deleteRecursively()

        logWrapper.v(LOG_TAG, "Deleting externalMediaDirs dir")
        targetContext.externalMediaDirs.forEach { it?.deleteRecursively() }

        logWrapper.v(LOG_TAG, "Deleting codeCacheDir dir")
        targetContext.codeCacheDir.deleteRecursively()

        logWrapper.v(LOG_TAG, "Deleting externalCacheDir dir")
        targetContext.externalCacheDir?.deleteRecursively()

        logWrapper.v(LOG_TAG, "Deleting noBackupFilesDir dir")
        targetContext.noBackupFilesDir.deleteRecursively()

        logWrapper.v(LOG_TAG, "Deleting data dir")
        if(AndroidVersion.isAtLeastNougat()) {
            targetContext.dataDir.deleteRecursively()
        } else {
            targetContext.filesDir.parentFile?.deleteRecursively()
        }
    }

    override fun isCritical(): Boolean {
        return true
    }
}