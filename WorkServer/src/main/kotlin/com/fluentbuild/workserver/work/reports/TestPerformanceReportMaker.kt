package com.fluentbuild.workserver.work.reports

import com.fluentbuild.apollo.measurement.StatsFrameProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.AtomicResult
import com.fluentbuild.reports.PerformanceReportProto.PerformanceReport
import com.fluentbuild.workserver.utils.autoClose
import com.fluentbuild.workserver.work.artifacts.ArtifactStore
import com.fluentbuild.workserver.work.store.DeviceWorkQuery

class TestPerformanceReportMaker(
    private val artifactStore: ArtifactStore
) {

    fun make(query: DeviceWorkQuery, atomicResult: AtomicResult): PerformanceReport {
        val inputStream = artifactStore.openArtifact(
            query,
            atomicResult.profileFileName,
            atomicResult
        )
        val statsFrame: StatsFrame = inputStream.autoClose {
            StatsFrame.parseFrom(it)
        }

        return PerformanceReport.newBuilder()
            .addAllMemoryStats(statsFrame.memoryStatsList)
            .addAllBinderStats(statsFrame.binderStatsList)
            .addAllFileIoStats(statsFrame.fileIoStatsList)
            .addAllThreadStats(statsFrame.threadStatsList)
            .addAllGcStats(statsFrame.gcStatsList)
            .addAllUnixProcessStats(statsFrame.unixProcessStatsList)
            .addAllNetworkStats(statsFrame.networkStatsList)
            .addAllFrameStats(statsFrame.frameStatsList)
            .build()
    }
}