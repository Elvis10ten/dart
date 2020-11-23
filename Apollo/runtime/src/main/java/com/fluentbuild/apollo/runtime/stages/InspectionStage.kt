package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.RuntimePrecondition

class InspectionStage(
    private val appContext: Context,
    private val runtimePrecondition: RuntimePrecondition,
    callback: Callback
): Stage(callback) {

    override fun onStart() {
        updateUi(UiData(appContext.getString(R.string.runtime_checking_conditions)))
        runtimePrecondition.check().fold(
            { onComplete(RuntimeState.FindingWork()) },
            { onError(it) }
        )
    }

    override fun onStop() {}

    override fun getMaxRetries() = 0

    override fun getAction() = "Inspecting"
}
