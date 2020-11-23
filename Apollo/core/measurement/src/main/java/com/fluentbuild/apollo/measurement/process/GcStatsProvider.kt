package com.fluentbuild.apollo.measurement.process

import android.os.Build
import android.os.Debug
import androidx.annotation.RequiresApi
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.measurement.GcStatsProto.GcStats

class GcStatsProvider {

    /**
     * Returns the supported GC runtime statistics.
     * Only available on Marshmallow and newer devices. On older devices, the values are null.
     */
    fun getStats(relativeTime: Int): GcStats {
        return if(AndroidVersion.isAtLeastMarshmallow()) {
            GcStats.newBuilder()
                .setRunCount(getInt("art.gc.gc-count"))
                .setRunTotalDuration(getInt("art.gc.gc-time"))
                .setTotalBytesAllocated(getLong("art.gc.bytes-allocated"))
                .setTotalBytesFreed(getLong("art.gc.bytes-freed"))
                .setBlockingRunCount(getInt("art.gc.blocking-gc-count"))
                .setBlockingRunTotalDuration(getInt("art.gc.blocking-gc-time"))
                .setRelativeTime(relativeTime)
                .build()
        } else {
            GcStats.newBuilder().build()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getInt(statName: String): Int {
        return Debug.getRuntimeStat(statName).toIntOrNull() ?: -1
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getLong(statName: String): Long {
        return Debug.getRuntimeStat(statName).toLongOrNull() ?: -1
    }
}