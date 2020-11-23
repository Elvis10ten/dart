package com.fluentbuild.apollo.presentation.settings

import android.view.ViewGroup
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.views.settings.SettingsView
import com.fluentbuild.apollo.views.settings.SettingsViewModel

class SettingsHost(
    private val navigator: Navigator
): Host<SettingsViewModel, SettingsView>() {
    override fun createViewHolder(container: ViewGroup): SettingsView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInitialViewModel(): SettingsViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
