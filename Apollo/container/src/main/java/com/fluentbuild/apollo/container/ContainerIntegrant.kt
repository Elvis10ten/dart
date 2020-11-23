package com.fluentbuild.apollo.container

import android.content.Context
import com.fluentbuild.apollo.runner.base.app.ScreenRotator
import com.fluentbuild.apollo.container.utils.AppPermissioner
import com.fluentbuild.apollo.foundation.android.getDevicePolicyManager
import com.fluentbuild.apollo.foundation.android.getMediaProjectionManager
import com.fluentbuild.apollo.foundation.android.getWindowManager
import com.fluentbuild.apollo.runner.base.display.ScreenViewer

class ContainerIntegrant(
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

    fun getAdminComponent() = ContainerAdminReceiver.getComponentName(appContext)

    companion object {

        private var instance: ContainerIntegrant? = null

        fun getInstance(context: Context): ContainerIntegrant {
            instance?.let { return it }
            return ContainerIntegrant(context.applicationContext).apply {
                instance = this
            }
        }
    }
}
