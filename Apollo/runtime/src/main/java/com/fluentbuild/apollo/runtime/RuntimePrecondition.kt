package com.fluentbuild.apollo.runtime

import android.content.Context
import com.fluentbuild.apollo.container.ContainerProvisioner
import com.fluentbuild.apollo.runtime.automation.AutomationService
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.androidtools.notifications.DndPermission
import com.fluentbuild.apollo.androidtools.packages.InstallPermission
import com.fluentbuild.apollo.runner.base.display.ScreenViewer

class RuntimePrecondition(
    private val appContext: Context,
    private val containerProvisioner: ContainerProvisioner,
    private val screenViewer: ScreenViewer,
    private val dndPermission: DndPermission,
    private val installPermission: InstallPermission
) {

    fun check(): Result<Unit> {
        val exception = try {
            when {
                !AutomationService.isEnabled(appContext) -> {
                    AutomationServiceDisabledException()
                }
                /* todo
                containerProvisioner.getState() == ContainerProvisioner.State.NOT_SUPPORTED -> {
                    ContainerUnSupportedException(appContext.getString(R.string.runtime_container_not_supported))
                }
                containerProvisioner.getState() == ContainerProvisioner.State.NOT_PROVISIONED -> {
                    ContainerNotProvisionedException(appContext.getString(R.string.runtime_container_not_provisioned))
                }
                !screenViewer.hasPermission() -> {
                    ScreenViewerNoPermissionException(appContext.getString(R.string.runtime_no_screen_viewer_permission))
                }*/
                AndroidVersion.isAtLeastMarshmallow() && !dndPermission.has() -> {
                    DndPermission.NotGrantedException()
                }
                !installPermission.has() -> {
                    InstallPermission.NotGrantedException()
                }
                else -> {
                    return Result.success(Unit)
                }
            }
        } catch (e: Exception) {
            IllegalStateException(appContext.getString(R.string.runtime_conditions_check_failed), e)
        }

        return Result.failure(exception)
    }
}

class AutomationServiceDisabledException: RuntimeException()

class ContainerNotProvisionedException: RuntimeException()

class ContainerUnSupportedException: RuntimeException()

class ScreenViewerNoPermissionException: RuntimeException()