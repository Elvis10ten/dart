package com.fluentbuild.apollo.runtime.automation

import android.content.Context
import com.fluentbuild.apollo.container.utils.AppPermissioner
import com.fluentbuild.apollo.foundation.android.getDevicePolicyManager
import com.fluentbuild.apollo.foundation.android.getMediaProjectionManager
import com.fluentbuild.apollo.foundation.android.getWindowManager
import com.fluentbuild.apollo.runner.base.app.ScreenRotator
import com.fluentbuild.apollo.runner.base.display.ScreenViewer

class AutomationModule(
    private val appContext: Context
) {

    private var screenViewer: ScreenViewer? = null

    private fun getScreenRotator() =
        ScreenRotator(appContext)

    private fun getAppPermissioner() =
        AppPermissioner(appContext, appContext.getDevicePolicyManager())

    fun getScreenViewer(): ScreenViewer {
        screenViewer?.let { return it }

        return ScreenViewer(
            appContext.getWindowManager(),
            appContext.getMediaProjectionManager()
        ).apply { screenViewer = this }
    }

    fun getUiAutomationServer(): UiAutomationServer {
        return UiAutomationServer(
            getScreenRotator(),
            getScreenViewer(),
            getAppPermissioner()
        )
    }

    companion object {

        private var instance: AutomationModule? = null

        fun getInstance(context: Context): AutomationModule {
            instance?.let { return it }
            return AutomationModule(context.applicationContext).apply {
                instance = this
            }
        }
    }
}