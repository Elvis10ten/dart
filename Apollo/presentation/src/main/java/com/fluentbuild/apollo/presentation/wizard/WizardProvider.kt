package com.fluentbuild.apollo.presentation.wizard

import android.content.Context
import com.fluentbuild.apollo.container.ContainerProvisioner
import com.fluentbuild.apollo.runtime.automation.AccessibilityUtils
import com.fluentbuild.apollo.runtime.automation.AutomationService
import com.fluentbuild.apollo.presentation.R
import com.fluentbuild.apollo.runner.base.display.ScreenViewer
import com.fluentbuild.apollo.views.wizard.Wizard

class WizardProvider(
    private val appContext: Context,
    private val containerProvisioner: ContainerProvisioner,
    private val screenViewer: ScreenViewer
) {

    fun getWizards(): List<Wizard> {
        val wizards = mutableListOf<Wizard>()

        if(true) {
            return wizards
        }

        // TODO: Swap provision and automation position
        if(!AccessibilityUtils.isServiceEnabled(appContext, AutomationService::class.java)) {
            wizards += Wizard(
                R.drawable.ic_accessibility_service_512,
                appContext.getString(R.string.wizardTitleAccessibilityService),
                appContext.getString(R.string.wizardDescriptionAccessibilityService),
                appContext.getString(R.string.wizardActionAccessibilityService),
                false,
                Wizard.Action.ENABLE_AUTOMATION_SERVICE
            )
        }

        if(containerProvisioner.getState() == ContainerProvisioner.State.NOT_PROVISIONED) {
            wizards += Wizard(
                R.drawable.ic_provision_device_512,
                appContext.getString(R.string.wizardTitleProvision),
                appContext.getString(R.string.wizardDescriptionProvision),
                appContext.getString(R.string.wizardActionProvision),
                false,
                Wizard.Action.PROVISION
            )
        }

        if(!screenViewer.hasPermission()) {
            wizards += Wizard(
                R.drawable.ic_media_projection_512,
                appContext.getString(R.string.wizardTitleMediaProjection),
                appContext.getString(R.string.wizardDescriptionMediaProjection),
                appContext.getString(R.string.wizardActionMediaProjection),
                false,
                Wizard.Action.REQUEST_MEDIA_PROJECTION_PERMISSION
            )
        }

        return wizards
    }


}
