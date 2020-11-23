package com.fluentbuild.apollo.measurement.process

import android.os.Process
import com.fluentbuild.apollo.foundation.android.AndroidVersion.isAtLeastNougat
import com.fluentbuild.apollo.foundation.android.AndroidVersion.isAtLeastMarshmallow
import com.fluentbuild.apollo.measurement.ProcessStatsProto.ProcessStats

class JavaProcessStatsProvider {

    fun getStats(): ProcessStats {
        val exclusiveCores = if(isAtLeastNougat()) Process.getExclusiveCores().toList() else emptyList()
        val startUptimeMillis = if(isAtLeastNougat()) Process.getStartUptimeMillis() else -1
        val is64Bit = if(isAtLeastMarshmallow()) Process.is64Bit() else false

        return ProcessStats.newBuilder()
            .setPid(Process.myPid())
            .setUid(Process.myUid())
            .addAllExclusiveCores(exclusiveCores)
            .setStartUptimeMillis(startUptimeMillis)
            .setIs64Bit(is64Bit)
            .build()
    }
}