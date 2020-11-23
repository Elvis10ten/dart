package com.fluentbuild.apollo.work.props

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.fluentbuild.apollo.measurement.BatteryStatsProto.BatteryStats
import com.fluentbuild.apollo.measurement.BatteryStatsProto.BatteryStats.*

internal class BatteryStatsProvider(private val appContext: Context) {

    fun getStats(): BatteryStats {
        val batteryInfo = getBatteryInfo() ?: return newBuilder().build()

        val isPresent = batteryInfo.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false)
        val technology = batteryInfo.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY)
        val voltage = batteryInfo.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)
        val temperature = batteryInfo.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)

        val level = batteryInfo.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batteryInfo.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val levelPercentage = ((level / scale.toFloat()) * 100).toInt()
        val temperatureCelsius = temperature / 10f

        return newBuilder()
            .setIsPresent(isPresent)
            .setHealth(getHealth(batteryInfo))
            .setLevelPercentage(levelPercentage)
            .setVoltage(voltage)
            .setTemperatureCelsius(temperatureCelsius)
            .setTechnology(technology)
            .setStatus(getStatus(batteryInfo))
            .setPowerSource(getPowerSource(batteryInfo))
            .build()
    }

    private fun getBatteryInfo(): Intent? {
        return appContext.registerReceiver(
            null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )
    }

    private fun getPowerSource(batteryInfo: Intent): PowerSource {
        return when(batteryInfo.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
            0 -> PowerSource.ON_BATTERY
            BatteryManager.BATTERY_PLUGGED_AC -> PowerSource.AC_CHARGER
            BatteryManager.BATTERY_PLUGGED_USB -> PowerSource.USB_PORT
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> PowerSource.WIRELESS
            else -> PowerSource.NO_SOURCE
        }
    }
    private fun getHealth(batteryInfo: Intent): Health {
        return when(batteryInfo.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)) {
            BatteryManager.BATTERY_HEALTH_GOOD -> Health.GOOD
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> Health.OVERHEAT
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> Health.OVER_VOLTAGE
            BatteryManager.BATTERY_HEALTH_COLD -> Health.COLD
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> Health.UNSPECIFIED_FAILURE
            BatteryManager.BATTERY_HEALTH_DEAD -> Health.DEAD
            else -> Health.NO_HEALTH
        }
    }

    private fun getStatus(batteryInfo: Intent): Status {
        return when(batteryInfo.getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
            BatteryManager.BATTERY_STATUS_CHARGING -> Status.CHARGING
            BatteryManager.BATTERY_STATUS_DISCHARGING -> Status.DISCHARGING
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> Status.NOT_CHARGING
            BatteryManager.BATTERY_STATUS_FULL -> Status.FULL
            else -> Status.NO_STATUS
        }
    }
}