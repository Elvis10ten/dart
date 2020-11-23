package com.fluentbuild.apollo.presentation.utils.mapper

import android.content.Context
import com.fluentbuild.apollo.presentation.R

object BaseErrorMessage {

    fun get(appContext: Context, exception: Exception): String {
        return when(exception) {
            else -> appContext.getString(R.string.baseErrorUnknown)
        }
    }
}
