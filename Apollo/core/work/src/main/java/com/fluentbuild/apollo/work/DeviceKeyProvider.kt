package com.fluentbuild.apollo.work

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.fluentbuild.apollo.persistence.kv.KeyValueStore
import java.util.*

private const val KEY_DEVICE_KEY = "kdk"

class DeviceKeyProvider(
    private val appContext: Context,
    private val kvStore: KeyValueStore
) {

    fun get(): String {
        var deviceKey = kvStore.getString(KEY_DEVICE_KEY, null)

        if(deviceKey == null) {
            deviceKey = generateDeviceKey()
            kvStore.setString(KEY_DEVICE_KEY, deviceKey)
        }

        return deviceKey
    }

    private fun generateDeviceKey(): String {
        return getDeviceId()
    }

    private fun getDeviceId(): String {
        return getAndroidId() ?: getAlternativeAndroidId()
    }

    @SuppressLint("HardwareIds")
    private fun getAndroidId(): String? {
        return Settings.Secure.getString(appContext.contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun getAlternativeAndroidId(): String {
        return UUID.randomUUID().toString()
    }
}