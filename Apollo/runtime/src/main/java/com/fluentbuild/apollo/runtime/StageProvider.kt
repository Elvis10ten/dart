package com.fluentbuild.apollo.runtime

import com.fluentbuild.apollo.runtime.stages.Stage

class StageProvider(
    private val runtimeModule: RuntimeModule
) {

    fun get(state: RuntimeState, callback: Stage.Callback): Stage {
        return when(state) {
            is RuntimeState.Inspecting -> {
                runtimeModule.getInspectingStage(callback)
            }
            is RuntimeState.FindingWork -> {
                runtimeModule.getFindingWorkStage(callback)
            }
            is RuntimeState.DownloadingPayload -> {
                runtimeModule.getDownloadPayloadStage(state.work, callback)
            }
            is RuntimeState.UnbundlingPayload -> {
                runtimeModule.getUnbundlingPayloadStage(state.work, callback)
            }
            is RuntimeState.InstallingWork -> {
                runtimeModule.getInstallingWorkStage(state.work, callback)
            }
            is RuntimeState.PreparingRun -> {
                runtimeModule.getPreparingRunStage(state.work, callback)
            }
            is RuntimeState.RunningWork -> {
                runtimeModule.getRunningWorkStage(
                    state.work,
                    state.instrumentations,
                    callback
                )
            }
            is RuntimeState.FinalizingRun -> {
                runtimeModule.getFinalizingRunStage(
                    state.work,
                    state.runReport,
                    callback
                )
            }
            is RuntimeState.BundlingResults -> {
                runtimeModule.getBundlingResultsStage(
                    state.work,
                    state.runReport,
                    callback
                )
            }
            is RuntimeState.UploadingResults -> {
                runtimeModule.getUploadingResultsStage(
                    state.work,
                    state.runReport,
                    callback
                )
            }
            is RuntimeState.CleaningUpWork -> {
                runtimeModule.getCleaningWorkStage(
                    state.work,
                    state.workSummary,
                    state.runReport,
                    callback
                )
            }
            RuntimeState.Idle -> {
                runtimeModule.getIdleStage(callback)
            }
        }
    }
}
