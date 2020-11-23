package com.fluentbuild.apollo.work.props

import android.os.Build
import com.fluentbuild.apollo.work.HardwarePropertiesProto

internal class HardwarePropsProvider {

    fun get(): HardwarePropertiesProto.HardwareProperties {
        return HardwarePropertiesProto.HardwareProperties.newBuilder()
            .setProduct(Build.PRODUCT)
            .setDevice(Build.DEVICE)
            .setBoard(Build.BOARD)
            .setManufacturer(Build.MANUFACTURER)
            .setBrand(Build.BRAND)
            .setModel(Build.MODEL)
            .setBootloader(Build.BOOTLOADER)
            .setHardware(Build.HARDWARE)
            .addAllSupportedAbis(Build.SUPPORTED_ABIS.toList())
            .addAllSupported32BitAbis(Build.SUPPORTED_32_BIT_ABIS.toList())
            .addAllSupported64BitAbis(Build.SUPPORTED_64_BIT_ABIS.toList())
            .setRadioVersion(Build.getRadioVersion())
            .build()
    }
}