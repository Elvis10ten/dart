package com.fluentbuild.apollo.runtime.stages

import android.content.Context
import com.fluentbuild.apollo.runtime.startup.Igniter
import com.fluentbuild.apollo.runtime.R
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.UiData

class IdleStage(
    private val appContext: Context,
    private val igniter: Igniter,
    callback: Callback
): Stage(callback), Igniter.Callback {

    override fun onStart() {
        updateUi(UiData(appContext.getString(R.string.runtime_idle)))
        igniter.addCallback(this)
    }

    override fun onStop() {
        igniter.removeCallback(this)
    }

    override fun getMaxRetries() = 0

    override fun getAction() = "Idling"

    override fun onEvent(event: Igniter.Event) {
        if(event.shouldRun()) {
            igniter.removeCallback(this)
            onComplete(RuntimeState.Inspecting())
        }
    }
}
