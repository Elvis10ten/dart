package com.fluentbuild.apollo.presentation.wizard

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.fluentbuild.apollo.container.ContainerProvisioner
import com.fluentbuild.apollo.runtime.automation.openAccessibilitySettings
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.R
import com.fluentbuild.apollo.presentation.splash.SplashHost
import com.fluentbuild.apollo.runner.base.display.ScreenViewer
import com.fluentbuild.apollo.views.wizard.Wizard
import com.fluentbuild.apollo.views.wizard.WizardView
import com.fluentbuild.apollo.views.wizard.WizardViewModel
import timber.log.Timber

// TODO: Handle the actions properly
class WizardHost(
    private val appContext: Context,
    private val containerProvisioner: ContainerProvisioner,
    private val screenViewer: ScreenViewer,
    private val navigator: Navigator,
    private val wizardProvider: WizardProvider,
    private val splashHostProvider: () -> SplashHost
): Host<WizardViewModel, WizardView>() {

    override fun createViewHolder(container: ViewGroup): WizardView {
        return WizardView(
            container.context,
            { performAction(container.context as FragmentActivity) },
            { gotoNextWizard() }
        )
    }

    private fun performAction(activity: FragmentActivity) {
        when(requireViewModel().getCurrentWizard().action) {
            Wizard.Action.PROVISION -> {
                startDeviceProvisioning(ContainerProvisioner.Params(
                    R.drawable.ic_logo,
                    R.color.colorPrimary,
                    R.string.companyName,
                    R.raw.provision_disclaimer,
                    activity
                ))
            }
            Wizard.Action.ENABLE_AUTOMATION_SERVICE -> enableAutomationService()
            Wizard.Action.REQUEST_MEDIA_PROJECTION_PERMISSION -> requestMediaProjectionPermission(activity)
        }
    }

    private fun startDeviceProvisioning(params: ContainerProvisioner.Params) {
        containerProvisioner.provision(
            params,
            object: ContainerProvisioner.ProvisionCallback {

                override fun onProvisioned() {
                    Timber.i("Device is provisioned!")
                    // todo
                }

                override fun onProvisioningCancelled() {
                    Timber.i("Device provisioning cancelled!")
                    Toast.makeText(appContext, R.string.wizardDeviceProvisioningCancelled, Toast.LENGTH_LONG).show()
                }

                override fun onProvisionFailed(exception: Exception) {
                    Timber.e(exception,"Device provisioning failed!")
                    // TODO
                }
            }
        )
    }

    private fun enableAutomationService() {
        appContext.openAccessibilitySettings()
    }

    private fun requestMediaProjectionPermission(activity: FragmentActivity) {
        screenViewer.requestPermission(activity)
    }

    private fun gotoNextWizard() {
        if(requireViewModel().currentIndex > requireViewModel().wizards.lastIndex) {
            navigator.goto(splashHostProvider())
        } else {
            updateViewHolder(requireViewModel().copy(currentIndex = (requireViewModel().currentIndex + 1)))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if(containerProvisioner.onActivityResult(requestCode, resultCode)) {
            return true
        }

        if(screenViewer.onRequestPermissionResult(requestCode, resultCode, data)) {
            return true
        }

        return false
    }

    override fun createInitialViewModel(): WizardViewModel {
        return WizardViewModel(0, wizardProvider.getWizards())
    }
}
