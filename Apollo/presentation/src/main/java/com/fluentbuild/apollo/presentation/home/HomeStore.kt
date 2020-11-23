package com.fluentbuild.apollo.presentation.home

import com.fluentbuild.apollo.persistence.kv.KeyValueStore

private const val CLICKED_RUNTIME_SWITCH = "HOME_CLICKED_RUNTIME_SWITCH"

class HomeStore(
    private val hostsKeyValueStore: KeyValueStore
) {

    fun saveRuntimeSwitchClicked() = hostsKeyValueStore.setBoolean(CLICKED_RUNTIME_SWITCH, true)

    fun hasClickedRuntimeSwitch() = hostsKeyValueStore.getBoolean(CLICKED_RUNTIME_SWITCH, false)
}
