package com.fluentbuild.apollo.presentation.splash

import android.content.Context
import android.os.Handler
import android.view.ViewGroup
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.PresentationModule
import com.fluentbuild.apollo.presentation.R
import com.fluentbuild.apollo.presentation.wizard.WizardProvider
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.splash.SplashView
import com.fluentbuild.apollo.views.splash.SplashViewModel

private const val SPLASH_DURATION_MS = 600

class SplashHost(
    private val navigator: Navigator,
    private val module: PresentationModule,
    private val wizardProvider: WizardProvider
): Host<SplashViewModel, SplashView>() {

    private val handler = Handler()
    private var splashRunnable: Runnable? = null

    override fun createViewHolder(container: ViewGroup): SplashView {
        return SplashView(container.context)
    }

    override fun createInitialViewModel(): SplashViewModel {
        return SplashViewModel(module.runtimeModule.appContext.getString(R.string.companyName))
    }

    override fun onShow(container: ViewGroup) {
        splashRunnable = Runnable {
            navigator.clearAndGoto(getHostToShow(container.context))
        }.apply {
            handler.postDelayed(this, SPLASH_DURATION_MS.toLong())
        }
    }

    @WorkerThread
    private fun getHostToShow(context: Context): Host<Any, ViewHolder<Any>> {
        return when {
            module.authModule.authManager.isSignedIn() -> getAuthenticatedHostToShow(context)
            else -> module.getOnboardingHost() as Host<Any, ViewHolder<Any>>
        }
    }

    private fun getAuthenticatedHostToShow(context: Context): Host<Any, ViewHolder<Any>> {
        return when {
            !module.authModule.authManager.hasProfile() -> module.getSignupHost()
            wizardProvider.getWizards().isNotEmpty() -> module.getWizardHost()
            else -> module.getHomeHost()
        } as Host<Any, ViewHolder<Any>>
    }

    override fun onHide(container: ViewGroup) {
        splashRunnable?.let { handler.removeCallbacks(it) }
        splashRunnable = null
    }
}
