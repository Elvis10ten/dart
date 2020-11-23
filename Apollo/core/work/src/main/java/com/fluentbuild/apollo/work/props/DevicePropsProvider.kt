package com.fluentbuild.apollo.work.props

import android.content.Context
import com.fluentbuild.apollo.work.DeviceKeyProvider
import com.fluentbuild.apollo.work.DevicePropertiesProto

class DevicePropsProvider(
    appContext: Context,
    private val deviceKeyProvider: DeviceKeyProvider
) {

    private val deviceStateProvider = DeviceStateProvider(appContext)
    private val featuresProvider = FeaturesProvider(appContext)
    private val hardwarePropsProvider = HardwarePropsProvider()
    private val osPropsProvider = OsPropsProvider()

    fun get(): DevicePropertiesProto.DeviceProperties {
        val features = featuresProvider.get()
        return DevicePropertiesProto.DeviceProperties.newBuilder()
            .setHardwareProperties(hardwarePropsProvider.get())
            .setOsProperties(osPropsProvider.get())
            .putAllAvailableFeatures(features.features)
            .setOpenGleVersion(features.openGleVersion)
            .setCurrentState(deviceStateProvider.get())
            .setDeviceKey(deviceKeyProvider.get())
            .build()
    }
}
