package com.fluentbuild.apollo.measurement.device

import android.net.TrafficStats
import com.fluentbuild.apollo.measurement.NetworkStatsProto.NetworkStats

class NetworkStatsProvider {

    fun getStats(uid: Int, relativeTime: Int): NetworkStats {
        return NetworkStats.newBuilder()
            .setRxBytes(TrafficStats.getUidRxBytes(uid))
            .setRxPackets(TrafficStats.getUidRxPackets(uid))
            .setTxBytes(TrafficStats.getUidTxBytes(uid))
            .setTxPackets(TrafficStats.getUidTxPackets(uid))
            .setRelativeTime(relativeTime)
            .build()
    }
}