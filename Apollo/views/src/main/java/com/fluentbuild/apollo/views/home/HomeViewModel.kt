package com.fluentbuild.apollo.views.home

import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.auth.Money
import com.fluentbuild.apollo.views.ScrollY
import com.fluentbuild.apollo.views.models.Profile

data class HomeViewModel(
    val profile: Profile,
    val balance: Money,
    val runtimeState: RuntimeState,
    val showRuntimeSwitchOnboarding: Boolean = false,
    val scrollPositionY: ScrollY? = null,
    val histories: List<WorkHistory> = emptyList(),
    val alert: HomeAlert? = null,
    val showShutdownConfirmationSheet: Boolean = false
)
