package com.fluentbuild.apollo.work.props

import android.content.Context
import com.fluentbuild.apollo.work.DeviceStateProto

internal class DeviceStateProvider(appContext: Context) {

    private val storageStatsProvider = StorageStatsProvider(appContext)
    private val memoryStatProvider = RamProvider(appContext)
    private val batteryStatsProvider = BatteryStatsProvider(appContext)

    fun get(): DeviceStateProto.DeviceState {
        return DeviceStateProto.DeviceState.newBuilder()
            .setStorageInfo(storageStatsProvider.getStats())
            .setRamInfo(memoryStatProvider.get())
            .setCurrentTimeMillis(System.currentTimeMillis())
            .setBatteryInfo(batteryStatsProvider.getStats())
            .build()
    }
}