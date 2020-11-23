package com.fluentbuild.apollo.measurement.device

import com.fluentbuild.apollo.foundation.autoClose
import com.fluentbuild.apollo.measurement.FileIoStatsProto.FileIoStats
import com.fluentbuild.apollo.measurement.MATCH_SPACES_REGEX
import java.io.FileInputStream
import java.io.IOException

class FileIoStatsProvider {

    @Throws(IOException::class, NumberFormatException::class)
    fun getStats(pid: Int, relativeTime: Int): FileIoStats {
        val fileName = "/proc/$pid/io"
        return FileInputStream(fileName).bufferedReader().autoClose { reader ->
            FileIoStats.newBuilder()
                .setCharsReadBytes(getLong(reader.readLine()))
                .setCharsWriteBytes(getLong(reader.readLine()))
                .setNumSysReadCalls(getLong(reader.readLine()))
                .setNumSysWriteCalls(getLong(reader.readLine()))
                .setReadBytes(getLong(reader.readLine()))
                .setWriteBytes(getLong(reader.readLine()))
                .setCancelledWriteBytes(getLong(reader.readLine()))
                .setRelativeTime(relativeTime)
                .build()
        }
    }

    private fun getLong(line: String): Long {
        return line.split(MATCH_SPACES_REGEX)[1].toLong()
    }
}