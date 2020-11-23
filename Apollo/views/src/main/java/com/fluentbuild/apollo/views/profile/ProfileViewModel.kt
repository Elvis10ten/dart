package com.fluentbuild.apollo.views.profile

import com.fluentbuild.apollo.auth.Wallet
import com.fluentbuild.apollo.views.models.Profile

data class ProfileViewModel(
    val profile: Profile,
    val wallet: Wallet
)
