package com.fluentbuild.apollo.presentation.home

import android.content.Context
import android.view.ViewGroup
import com.fluentbuild.apollo.auth.AuthManager
import com.fluentbuild.apollo.foundation.async.ServiceState
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.RuntimeSwitch
import com.fluentbuild.apollo.presentation.faq.FaqHost
import com.fluentbuild.apollo.presentation.historydetail.HistoryDetailHost
import com.fluentbuild.apollo.presentation.profile.ProfileHost
import com.fluentbuild.apollo.presentation.schedule.ScheduleHost
import com.fluentbuild.apollo.presentation.settings.SettingsHost
import com.fluentbuild.apollo.presentation.utils.mapper.toProfile
import com.fluentbuild.apollo.runtime.*
import com.fluentbuild.apollo.runtime.models.UiData
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.auth.WalletService
import com.fluentbuild.apollo.runtime.store.HistoryStore
import com.fluentbuild.apollo.runtime.store.ScheduleStore
import com.fluentbuild.apollo.views.ScrollY
import com.fluentbuild.apollo.views.home.HomeAction
import com.fluentbuild.apollo.views.home.HomeAlert
import com.fluentbuild.apollo.views.home.HomeView
import com.fluentbuild.apollo.views.home.HomeViewModel
import com.fluentbuild.apollo.views.utils.MoneyFormatter
import timber.log.Timber

class HomeHost(
    private val appContext: Context,
    private val runtimeSwitch: RuntimeSwitch,
    private val homeStore: HomeStore,
    private val authManager: AuthManager,
    private val runtimeManager: RuntimeManager,
    private val moneyFormatter: MoneyFormatter,
    private val workHistoryStore: HistoryStore,
    private val walletService: WalletService,
    private val workScheduleStore: ScheduleStore,
    private val alertProvider: HomeAlertProvider,
    private val navigator: Navigator,
    private val eventLogger: HomeEventLogger,
    private val settingsHostProvider: () -> SettingsHost,
    private val profileHostProvider: () -> ProfileHost,
    private val scheduleHostProvider: () -> ScheduleHost,
    private val historyDetailHostProvider: (WorkHistory) -> HistoryDetailHost,
    private val faqHostProvider: () -> FaqHost
): Host<HomeViewModel, HomeView>(), RuntimeManager.Callback {

    override fun createViewHolder(container: ViewGroup): HomeView {
        return HomeView(
            container.context,
            moneyFormatter,
            { onRuntimeSwitchClicked(it) },
            { onAppBarActionClicked(it) },
            { onShutdownConfirmed() },
            { onShutdownNotConfirmed() },
            { onHistoryClicked(it) },
            { onProfileClicked() },
            { onScrolled(it) },
            { onRuntimeSwitchOnboardingDismissed() }
        )
    }

    private fun onRuntimeSwitchClicked(currentState: RuntimeState) {
        homeStore.saveRuntimeSwitchClicked()
        when (currentState) {
            is RuntimeState.Idle -> {
                eventLogger.onStartupClicked(currentState)
                runtimeSwitch.startup(appContext)
            }
            is RuntimeState.Inspecting, is RuntimeState.FindingWork -> {
                eventLogger.onShutdownClicked(currentState)
                runtimeSwitch.shutdown(appContext)
            }
            else -> {
                eventLogger.onShowShutdownConfirmation()
                updateViewHolder(requireViewModel().copy(showShutdownConfirmationSheet = true))
            }
        }
    }

    private fun onAppBarActionClicked(action: HomeAction) {
        when(action) {
            HomeAction.HELP -> {
                eventLogger.onHelpClicked()
                navigator.goto(faqHostProvider())
            }
            HomeAction.SETTINGS -> {
                eventLogger.onSettingsClicked()
                navigator.goto(settingsHostProvider())
            }
        }
    }

    private fun onHistoryClicked(history: WorkHistory) {
        eventLogger.onHistoryClicked(history)
        navigator.goto(historyDetailHostProvider(history))
    }

    private fun onProfileClicked() {
        eventLogger.onProfileClicked()
        navigator.goto(profileHostProvider())
    }

    private fun onShutdownConfirmed() {
        eventLogger.onShutdownConfirmed()
        runtimeSwitch.shutdown(appContext)
        updateViewHolder(requireViewModel().copy(showShutdownConfirmationSheet = false))
    }

    private fun onShutdownNotConfirmed() {
        eventLogger.onShutdownNotConfirmed()
        updateViewHolder(requireViewModel().copy(showShutdownConfirmationSheet = false))
    }

    private fun onScrolled(scrollY: ScrollY) {
        updateViewModel(requireViewModel().copy(scrollPositionY = scrollY))
    }

    private fun onRuntimeSwitchOnboardingDismissed() {
        updateViewModel(requireViewModel().copy(showRuntimeSwitchOnboarding = false))
    }

    override fun onShow(container: ViewGroup) {
         runtimeManager.addCallback(this)

        workHistoryStore.setDataCallback {
            Timber.d("Job history updated!")
            updateViewHolder(requireViewModel().copy(histories = it))
        }

        walletService.setCallback {
            if(it is ServiceState.Success) {
                Timber.d("Wallet updated!")
                updateViewHolder(requireViewModel().copy(balance = it.data.balance))
            }
        }

        workScheduleStore.setDataCallback {
            Timber.d("Job scheduling updated!")
            updateViewHolder(requireViewModel().copy(alert = getAlert()))
        }
    }

    override fun onHide(container: ViewGroup) {
        runtimeManager.removeCallback(this)
        workHistoryStore.setDataCallback(null)
        walletService.removeCallback()
        workScheduleStore.setDataCallback(null)
        requireViewHolder().destroy()
    }

    override fun onStateChanged(state: RuntimeState) {
        updateViewHolder(requireViewModel().copy(runtimeState = state))
    }

    override fun onUiUpdated(uiData: UiData) {
        // todo
    }

    override fun onError(error: Throwable) {
        // todo
    }

    override fun createInitialViewModel(): HomeViewModel {
        return HomeViewModel(
            authManager.requireAuthModel().toProfile(),
            walletService.getWallet().balance,
            runtimeManager.getCurrentState(),
            !homeStore.hasClickedRuntimeSwitch()
        )
    }

    private fun getAlert(): HomeAlert? {
        return alertProvider.getHighestPriorityAlert(
            { onEnableScheduleClicked() }
        )
    }

    private fun onEnableScheduleClicked() {
        eventLogger.onEnableScheduleClicked()
        navigator.goto(scheduleHostProvider())
    }
}
