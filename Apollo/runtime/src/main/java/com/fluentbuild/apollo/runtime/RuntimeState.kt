package com.fluentbuild.apollo.runtime

import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.WorkSummaryProto.*
import com.fluentbuild.apollo.work.tests.RunReportProto.*

sealed class RuntimeState {

    object Idle: RuntimeState()

    class Inspecting: RuntimeState()

    class FindingWork: RuntimeState()

    data class DownloadingPayload(
        val work: WorkProto.Work
    ): RuntimeState()

    data class UnbundlingPayload(
        val work: WorkProto.Work
    ): RuntimeState()

    data class InstallingWork(
        val work: WorkProto.Work
    ): RuntimeState()

    data class PreparingRun(
        val work: WorkProto.Work
    ): RuntimeState()

    data class RunningWork(
        val work: WorkProto.Work,
        val instrumentations: List<InstrumentationMeta>
    ): RuntimeState()

    data class FinalizingRun(
        val work: WorkProto.Work,
        val runReport: RunReport
    ): RuntimeState()

    data class BundlingResults(
        val work: WorkProto.Work,
        val runReport: RunReport
    ): RuntimeState()

    data class UploadingResults(
        val work: WorkProto.Work,
        val runReport: RunReport
    ): RuntimeState()

    data class CleaningUpWork(
        val work: WorkProto.Work,
        val runReport: RunReport,
        val workSummary: WorkSummary
    ): RuntimeState()
}
