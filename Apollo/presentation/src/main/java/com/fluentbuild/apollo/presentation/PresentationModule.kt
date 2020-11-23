package com.fluentbuild.apollo.presentation

import com.fluentbuild.apollo.persistence.kv.SharedPrefKeyValueStore
import com.fluentbuild.apollo.presentation.faq.FaqEventLogger
import com.fluentbuild.apollo.presentation.faq.FaqHost
import com.fluentbuild.apollo.presentation.historydetail.HistoryDetailHost
import com.fluentbuild.apollo.presentation.home.HomeAlertProvider
import com.fluentbuild.apollo.presentation.home.HomeEventLogger
import com.fluentbuild.apollo.presentation.home.HomeHost
import com.fluentbuild.apollo.presentation.home.HomeStore
import com.fluentbuild.apollo.presentation.onboarding.OnboardingEventLogger
import com.fluentbuild.apollo.presentation.onboarding.OnboardingHost
import com.fluentbuild.apollo.presentation.profile.ProfileEventLogger
import com.fluentbuild.apollo.presentation.profile.ProfileHost
import com.fluentbuild.apollo.presentation.schedule.ScheduleHost
import com.fluentbuild.apollo.presentation.settings.SettingsHost
import com.fluentbuild.apollo.presentation.signin.SigninHost
import com.fluentbuild.apollo.presentation.signup.SignupHost
import com.fluentbuild.apollo.presentation.splash.SplashHost
import com.fluentbuild.apollo.presentation.wizard.WizardHost
import com.fluentbuild.apollo.presentation.wizard.WizardProvider
import com.fluentbuild.apollo.runtime.RuntimeModule
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.utils.MoneyFormatter
import java.util.*

class PresentationModule(
    val runtimeModule: RuntimeModule,
    val runtimeSwitch: RuntimeSwitch
) {

    val navigator = Navigator()

    private val wizardProvider by lazy { with(runtimeModule) {
        WizardProvider(appContext, containerModule.containerProvisioner, runnerServerModule.screenViewer)
    }}

    private val hostsKeyValueStore by lazy { SharedPrefKeyValueStore(runtimeModule.appContext, "hosts") }

    val authModule get() = runtimeModule.authModule

    fun getSplashHost() = SplashHost(navigator, this, wizardProvider)

    fun getWizardHost() = with(runtimeModule) {
        WizardHost(
            appContext,
            containerModule.containerProvisioner,
            runnerServerModule.screenViewer,
            navigator,
            wizardProvider
        ) { getSplashHost() }
    }

    fun getSignupHost() = SignupHost(navigator, this)

    fun getSigninHost() = SigninHost(navigator, this)

    fun getOnboardingHost() = with(runtimeModule) {
        OnboardingHost(
            getOnboardingEventLogger(),
            navigator,
            { getSigninHost() },
            { getFaqHost() }
        )
    }

    fun getHomeHost() = with(runtimeModule) {
        HomeHost(
            appContext,
            this@PresentationModule.runtimeSwitch,
            getHomeStore(),
            authModule.authManager,
            runtimeManager,
            getMoneyFormatter(),
            historyStore,
            walletService,
            workScheduleStore,
            getHomeAlertProvider(),
            navigator,
            getHomeEventLogger(),
            { getSettingsHost() },
            { getProfileHost() },
            { getScheduleHost() },
            { getHistoryDetailHost(it) },
            { getFaqHost() }
        )
    }

    fun getSettingsHost() = with(runtimeModule) {
        SettingsHost(
            navigator
        )
    }

    fun getProfileHost() = with(runtimeModule) {
        ProfileHost(
            authModule.authManager,
            walletService,
            getMoneyFormatter(),
            getProfileEventLogger(),
            navigator
        )
    }

    fun getScheduleHost() = with(runtimeModule) {
        ScheduleHost(
            navigator
        )
    }

    fun getHistoryDetailHost(history: WorkHistory) = with(runtimeModule) {
        HistoryDetailHost(
            history,
            navigator
        )
    }

    fun getFaqHost() = with(runtimeModule) {
        FaqHost(
            appContext,
            getFaqEventLogger(),
            navigator
        )
    }

    private fun getMoneyFormatter() = MoneyFormatter(Locale.getDefault())

    private fun getHomeAlertProvider() = HomeAlertProvider(runtimeModule.appContext, runtimeModule.workScheduleStore)

    private fun getHomeEventLogger() = HomeEventLogger(runtimeModule.analyticsModule.eventPublisher)

    private fun getHomeStore() = HomeStore(hostsKeyValueStore)

    private fun getFaqEventLogger() = FaqEventLogger(runtimeModule.analyticsModule.eventPublisher)

    private fun getOnboardingEventLogger() = OnboardingEventLogger(runtimeModule.analyticsModule.eventPublisher)

    private fun getProfileEventLogger() = ProfileEventLogger(runtimeModule.analyticsModule.eventPublisher)
}
