package com.fluentbuild.apollo.measurement.process

import com.fluentbuild.apollo.foundation.autoClose
import com.fluentbuild.apollo.foundation.readText
import com.fluentbuild.apollo.measurement.MATCH_SPACES_REGEX
import com.fluentbuild.apollo.measurement.UnixProcessStatsProto.UnixProcessStats
import java.io.FileInputStream
import java.io.IOException

class UnixProcessStatsProvider {

    @Throws(IOException::class, NumberFormatException::class)
    fun getStats(pid: Int, relativeTime: Int): UnixProcessStats {
        val fileName = "/proc/$pid/stat"
        val fields = FileInputStream(fileName).autoClose {
            it.readText().split(MATCH_SPACES_REGEX)
        }

        return UnixProcessStats.newBuilder()
            .setState(fields[2])
            .setNumMinorFaults(fields[9].toLong())
            .setNumChildMinorFaults(fields[10].toLong())
            .setNumMajorFaults(fields[11].toLong())
            .setNumChildMajorFaults(fields[12].toLong())
            .setUserTime(fields[13].toLong())
            .setSystemTime(fields[14].toLong())
            .setChildUserTime(fields[15].toLong())
            .setSystemTime(fields[16].toLong())
            .setVirtualMemorySize(fields[22].toLong())
            .setRss(fields[23].toLong())
            .setAggregatedBlockIoDelaysInTicks(fields[31].toLong())
            .setLastCpuExecutedNumber(fields[38].toInt())
            .setAggregatedBlockIoDelaysInTicks(fields[41].toLong())
            .setRelativeTime(relativeTime)
            .build()
    }
}