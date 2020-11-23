package com.fluentbuild.apollo.views.home

import com.fluentbuild.apollo.views.R

enum class HomeAction {
    HELP,
    SETTINGS;

    companion object {

        fun find(itemId: Int): HomeAction {
            return when(itemId) {
                R.id.helpAction -> HELP
                R.id.settingsAction -> SETTINGS
                else -> throw IllegalArgumentException("Item id($itemId) is not valid")
            }
        }
    }
}
