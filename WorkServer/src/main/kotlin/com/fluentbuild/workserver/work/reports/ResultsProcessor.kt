package com.fluentbuild.workserver.work.reports

import com.fluentbuild.apollo.work.tests.RunReportProto.*
import com.fluentbuild.workserver.utils.autoClose
import com.fluentbuild.workserver.work.artifacts.ArtifactEntries
import com.fluentbuild.workserver.work.artifacts.ArtifactStore
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import java.io.File
import java.util.zip.ZipFile

private const val RUN_REPORT_FILE_NAME = "rr.b"

class ResultsProcessor(
    private val artifactStore: ArtifactStore
) {

    fun process(file: File) {
        ZipFile(file).autoClose { zipFile ->
            val reportEntry = zipFile.getEntry(RUN_REPORT_FILE_NAME)
            val runReport = RunReport.parseFrom(zipFile.getInputStream(reportEntry))

            // todo: handle retries
            val deviceWorkQuery = DeviceWorkQuery(runReport.workKey, runReport.deviceKey)
            runReport.instrumentationResult.atomicResultsList.forEach { result ->
                // todo: find a better way to get specific test artifacts
                artifactStore.add(deviceWorkQuery, result, ArtifactEntries(file))
            }
        }
    }
}