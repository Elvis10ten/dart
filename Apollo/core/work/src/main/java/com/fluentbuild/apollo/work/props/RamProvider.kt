package com.fluentbuild.apollo.work.props

import android.app.ActivityManager
import android.content.Context
import com.fluentbuild.apollo.foundation.android.getActivityManager
import com.fluentbuild.apollo.work.DeviceStateProto.*

internal class RamProvider(private val appContext: Context) {

    fun get(): RamInfo {
        val memoryInfo = ActivityManager.MemoryInfo()
        appContext.getActivityManager().getMemoryInfo(memoryInfo)

        return RamInfo.newBuilder()
            .setSystemTotalSizeBytes(memoryInfo.totalMem)
            .setSystemAvailableSizeBytes(memoryInfo.availMem)
            .setSystemThresholdSizeBytes(memoryInfo.threshold)
            .build()
    }
}