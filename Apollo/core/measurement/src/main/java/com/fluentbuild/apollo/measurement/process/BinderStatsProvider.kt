package com.fluentbuild.apollo.measurement.process

import android.os.Debug
import com.fluentbuild.apollo.measurement.BinderStatsProto.BinderStats

class BinderStatsProvider {

    fun getStats(relativeTime: Int): BinderStats {
        return BinderStats.newBuilder()
            .setDeathObjectCount(Debug.getBinderDeathObjectCount())
            .setLocalObjectCount(Debug.getBinderLocalObjectCount())
            .setProxyObjectCount(Debug.getBinderProxyObjectCount())
            .setReceivedTransactions(Debug.getBinderReceivedTransactions())
            .setSentTransactions(Debug.getBinderSentTransactions())
            .setRelativeTime(relativeTime)
            .build()
    }
}