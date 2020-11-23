package com.fluentbuild.apollo.measurement.memory

import android.content.Context
import android.os.Environment.*
import android.os.StatFs
import com.fluentbuild.apollo.measurement.StorageStatsProto.StorageStats
import java.io.File

class StorageStatsProvider(private val appContext: Context) {

    fun getStats(): StorageStats {
        return StorageStats.newBuilder()
            .setInternalStorage(getInternalStorageStats())
            .addAllExternalStorage(getExternalStorageStats())
            .build()
    }

    private fun getInternalStorageStats() = appContext.filesDir.getStorageStats()

    private fun getExternalStorageStats(): List<StorageStats.Info> {
        return appContext.getExternalFilesDirs(null)
            .filter { it != null && it.isExternalStorage() }
            .map { it.getStorageStats() }
    }
}

private fun File.isExternalStorage() =
    getExternalStorageState(this) == MEDIA_MOUNTED && !isExternalStorageEmulated(this)

private fun File.getStorageStats(): StorageStats.Info {
    return with(StatFs(path)) {
        StorageStats.Info.newBuilder()
            .setTotalSizeBytes(totalBytes)
            .setAvailableSizeBytes(availableBytes)
            .build()
    }
}