package com.fluentbuild.apollo.presentation.utils.mapper

import android.content.Context
import com.fluentbuild.apollo.auth.exceptions.*
import com.fluentbuild.apollo.presentation.R

object AuthErrorMessage {

    fun get(appContext: Context, exception: Exception): String {
        return when(exception) {
            is InvalidPhoneNumberException -> appContext.getString(R.string.authErrorInvalidPhoneNumber)
            is IncorrectSmsCodeException -> appContext.getString(R.string.authErrorIncorrectOtp)
            is InternalAuthException -> appContext.getString(R.string.authErrorInternal)
            is UnknownAuthException -> appContext.getString(R.string.authErrorUnknown)
            else -> BaseErrorMessage.get(appContext, exception)
        }
    }
}
