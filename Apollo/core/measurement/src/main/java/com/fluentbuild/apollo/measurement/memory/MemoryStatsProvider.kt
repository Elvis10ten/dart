package com.fluentbuild.apollo.measurement.memory

import android.app.ActivityManager
import android.content.Context
import android.os.Debug
import com.fluentbuild.apollo.foundation.android.getActivityManager
import com.fluentbuild.apollo.measurement.MemoryStatsProto.MemoryStats

class MemoryStatsProvider(private val appContext: Context) {

    fun getStats(relativeTime: Int): MemoryStats {
        val statsBuilder = MemoryStats.newBuilder()
            .setRelativeTime(relativeTime)

        setAppMemory(statsBuilder)
        setSystemMemoryStats(statsBuilder)
        return statsBuilder.build()
    }

    private fun setAppMemory(memoryStatsBuilder: MemoryStats.Builder) {
        val memoryInfo = Debug.MemoryInfo()
        Debug.getMemoryInfo(memoryInfo)

        memoryStatsBuilder
            .setAppDalvikPrivateDirty(memoryInfo.dalvikPrivateDirty)
            .setAppDalvikPss(memoryInfo.dalvikPss)
            .setAppDalvikSharedDirty(memoryInfo.dalvikSharedDirty)
            .setAppNativePrivateDirty(memoryInfo.nativePrivateDirty)
            .setAppNativePss(memoryInfo.nativePss)
            .setAppNativeSharedDirty(memoryInfo.nativeSharedDirty)
            .setAppOtherPrivateDirty(memoryInfo.otherPrivateDirty)
            .setAppOtherPss(memoryInfo.otherPss)
            .setAppOtherSharedDirty(memoryInfo.totalPrivateClean)
    }

    /**
     * Return general information about the memory state of the system.
     */
    private fun setSystemMemoryStats(memoryStatsBuilder: MemoryStats.Builder) {
        val memoryInfo = ActivityManager.MemoryInfo()
        appContext.getActivityManager().getMemoryInfo(memoryInfo)

        memoryStatsBuilder
            .setSystemTotalSizeBytes(memoryInfo.totalMem)
            .setSystemAvailableSizeBytes(memoryInfo.availMem)
            .setSystemThresholdSizeBytes(memoryInfo.threshold)
    }
}