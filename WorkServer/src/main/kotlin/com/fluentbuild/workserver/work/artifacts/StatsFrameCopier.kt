package com.fluentbuild.workserver.work.artifacts

import com.fluentbuild.apollo.measurement.StatsFrameProto.*
import com.fluentbuild.reports.PerformanceReportProto
import java.io.InputStream
import java.io.OutputStream

object StatsFrameCopier {

    fun copy(sourceInputStream: InputStream, destOutputStream: OutputStream) {
        val mergedStatsFrameBuilder = StatsFrame.newBuilder()

        var statsFrame = StatsFrame.parseDelimitedFrom(sourceInputStream)
        while(statsFrame != null) {
            mergedStatsFrameBuilder.mergeFrom(statsFrame)
            statsFrame = StatsFrame.parseDelimitedFrom(sourceInputStream)
        }

        val mergedStatsFrame = mergedStatsFrameBuilder.build()
        mergedStatsFrame.writeTo(destOutputStream)
    }
}