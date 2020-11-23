package com.fluentbuild.apollo.measurement.process

import android.content.Context
import android.os.Build
import android.os.health.HealthStats
import android.os.health.UidHealthStats.*
import androidx.annotation.RequiresApi
import com.fluentbuild.apollo.foundation.android.getSystemHealthService
import com.fluentbuild.apollo.measurement.ResourceUsageStatsProto.ResourceUsageStats

class ResourceUsageStatsProvider(private val appContext: Context) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun getStats(relativeTime: Int): ResourceUsageStats {
        val shot = appContext.getSystemHealthService().takeMyUidSnapshot()
        val statsBuilder = ResourceUsageStats.newBuilder()

        statsBuilder.audioCount = shot.getCountSafe(TIMER_AUDIO)
        statsBuilder.audioTimeMillis = shot.getTimeSafe(TIMER_AUDIO)
        statsBuilder.videoCount = shot.getCountSafe(TIMER_VIDEO)
        statsBuilder.videoTimeMillis = shot.getTimeSafe(TIMER_VIDEO)
        statsBuilder.cameraCount = shot.getCountSafe(TIMER_CAMERA)
        statsBuilder.cameraTimeMillis = shot.getTimeSafe(TIMER_CAMERA)
        statsBuilder.flashlightCount = shot.getCountSafe(TIMER_FLASHLIGHT)
        statsBuilder.flashlightTimeMillis = shot.getTimeSafe(TIMER_FLASHLIGHT)

        statsBuilder.vibratorCount = shot.getCountSafe(TIMER_VIBRATOR)
        statsBuilder.vibratorTimeMillis = shot.getTimeSafe(TIMER_VIBRATOR)
        statsBuilder.gpsSensorCount = shot.getCountSafe(TIMER_GPS_SENSOR)
        statsBuilder.gpsSensorTimeMillis = shot.getTimeSafe(TIMER_GPS_SENSOR)

        statsBuilder.bluetoothCount = shot.getCountSafe(TIMER_BLUETOOTH_SCAN)
        statsBuilder.bluetoothTimeMillis = shot.getTimeSafe(TIMER_BLUETOOTH_SCAN)
        statsBuilder.wifiScanCount = shot.getCountSafe(TIMER_WIFI_SCAN)
        statsBuilder.wifiScanTimeMillis = shot.getTimeSafe(TIMER_WIFI_SCAN)
        statsBuilder.mobileRadioActiveCount = shot.getCountSafe(TIMER_MOBILE_RADIO_ACTIVE)
        statsBuilder.mobileRadioActiveTimeMillis = shot.getTimeSafe(TIMER_MOBILE_RADIO_ACTIVE)

        statsBuilder.wifiMultiCastMillis = shot.getMeasurementSafe(MEASUREMENT_WIFI_MULTICAST_MS)
        statsBuilder.bluetoothRxBytes  = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_RX_BYTES)
        statsBuilder.bluetoothTxBytes  = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_TX_BYTES)
        statsBuilder.bluetoothRxPackets = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_RX_PACKETS)
        statsBuilder.bluetoothTxPackets = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_TX_PACKETS)

        statsBuilder.wifiIdleMillis = shot.getMeasurementSafe(MEASUREMENT_WIFI_IDLE_MS)
        statsBuilder.bluetoothIdleMillis = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_IDLE_MS)
        statsBuilder.mobileIdleMillis = shot.getMeasurementSafe(MEASUREMENT_WIFI_IDLE_MS)

        statsBuilder.wifiPowerMams = shot.getMeasurementSafe(MEASUREMENT_WIFI_POWER_MAMS)
        statsBuilder.bluetoothPowerMams = shot.getMeasurementSafe(MEASUREMENT_BLUETOOTH_POWER_MAMS)
        statsBuilder.mobilePowerMams = shot.getMeasurementSafe(MEASUREMENT_MOBILE_POWER_MAMS)

        statsBuilder.wifiRunningMs = shot.getMeasurementSafe(MEASUREMENT_WIFI_RUNNING_MS)
        statsBuilder.wifiFullLockMs = shot.getMeasurementSafe(MEASUREMENT_WIFI_FULL_LOCK_MS)

        statsBuilder.putAllJobs(shot.getTimersSafe(TIMERS_JOBS))
        statsBuilder.putAllSensors(shot.getTimersSafe(TIMERS_SENSORS))
        statsBuilder.putAllSyncs(shot.getTimersSafe(TIMERS_SYNCS))
        statsBuilder.putAllWakeLocksPartial(shot.getTimersSafe(TIMERS_WAKELOCKS_PARTIAL))
        statsBuilder.putAllWakeLocksWindow(shot.getTimersSafe(TIMERS_WAKELOCKS_WINDOW))
        statsBuilder.putAllWakeLocksFull(shot.getTimersSafe(TIMERS_WAKELOCKS_FULL))
        statsBuilder.putAllWakeLocksDraw(shot.getTimersSafe(TIMERS_WAKELOCKS_DRAW))

        statsBuilder.relativeTime = relativeTime
        return statsBuilder.build()
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun HealthStats.getTimeSafe(key: Int): Long {
    return if(hasTimer(key)) {
        getTimerTime(key)
    } else {
        -1
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun HealthStats.getCountSafe(key: Int): Int {
    return if(hasTimer(key)) {
        getTimerCount(key)
    } else {
        -1
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun HealthStats.getMeasurementSafe(key: Int): Long {
    return if(hasMeasurement(key)) {
        getMeasurement(key)
    } else {
        -1
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun HealthStats.getTimersSafe(key: Int): Map<String, ResourceUsageStats.Timer> {
    return if(hasTimers(key)) {
        getTimers(key).mapValues {
            ResourceUsageStats.Timer.newBuilder()
                .setCount(it.value.count)
                .setTimeMillis(it.value.time)
                .build()
        }
    } else {
        emptyMap()
    }
}