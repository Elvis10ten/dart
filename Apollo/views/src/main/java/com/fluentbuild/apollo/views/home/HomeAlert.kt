package com.fluentbuild.apollo.views.home

import androidx.annotation.DrawableRes
import com.fluentbuild.apollo.views.R

data class HomeAlert(
    val text: String,
    val actionText: String,
    val actionClickCallback: () -> Unit,
    val type: Type
) {

    enum class Type(
        @DrawableRes
        val background: Int
    ) {
        NORMAL(R.drawable.bg_home_alert_normal),
        ERROR(R.drawable.bg_home_alert_error);
    }
}
