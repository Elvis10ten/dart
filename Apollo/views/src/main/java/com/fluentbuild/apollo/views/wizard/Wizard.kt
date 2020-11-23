package com.fluentbuild.apollo.views.wizard

import androidx.annotation.DrawableRes

data class Wizard(
    @DrawableRes
    val iconRes: Int,
    val title: String,
    val description: String,
    val primaryActionText: String,
    val skipable: Boolean = false,
    val action: Action
) {

    enum class Action {
        PROVISION,
        ENABLE_AUTOMATION_SERVICE,
        REQUEST_MEDIA_PROJECTION_PERMISSION
    }
}
