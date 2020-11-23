package com.fluentbuild.apollo.presentation.profile

import com.fluentbuild.apollo.analytics.EventPublisher

class ProfileEventLogger(
    private val publisher: EventPublisher
) {

    fun onBackClicked() {
        publisher.publish("profile_back_clicked")
    }

    fun onLogoutClicked() {
        publisher.publish("profile_logout_clicked")
    }

    fun onManageWalletClicked() {
        publisher.publish("profile_manage_wallet_clicked")
    }
}
