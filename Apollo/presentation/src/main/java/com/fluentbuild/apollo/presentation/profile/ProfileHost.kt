package com.fluentbuild.apollo.presentation.profile

import android.view.ViewGroup
import com.fluentbuild.apollo.auth.AuthManager
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.utils.mapper.toProfile
import com.fluentbuild.apollo.auth.WalletService
import com.fluentbuild.apollo.views.profile.ProfileView
import com.fluentbuild.apollo.views.profile.ProfileViewModel
import com.fluentbuild.apollo.views.utils.MoneyFormatter

class ProfileHost(
    private val authManager: AuthManager,
    private val walletService: WalletService,
    private val moneyFormatter: MoneyFormatter,
    private val eventLogger: ProfileEventLogger,
    private val navigator: Navigator
): Host<ProfileViewModel, ProfileView>() {

    override fun createViewHolder(container: ViewGroup): ProfileView {
        return ProfileView(
            container.context,
            moneyFormatter,
            { onBackClicked() },
            { onLogoutClicked() },
            { onManageWalletClicked() }
        )
    }

    private fun onManageWalletClicked() {
        eventLogger.onManageWalletClicked()
        // TODO
    }

    private fun onLogoutClicked() {
        eventLogger.onLogoutClicked()
        // TODO
    }

    private fun onBackClicked() {
        eventLogger.onBackClicked()
        navigator.onBackPressed()
    }

    override fun createInitialViewModel(): ProfileViewModel {
        return ProfileViewModel(
            authManager.requireAuthModel().toProfile(),
            walletService.getWallet()
        )
    }
}
