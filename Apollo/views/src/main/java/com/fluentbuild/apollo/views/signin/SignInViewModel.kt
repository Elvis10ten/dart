package com.fluentbuild.apollo.views.signin

import com.fluentbuild.apollo.views.models.UiState

data class SignInViewModel(
    val fullPhoneNumber: String? = null,
    val smsCode: String? = null,
    val phoneNumberError: String? = null,
    val smsCodeError: String? = null,
    val hasSmsCodeBeenSent: Boolean,
    val state: UiState
)
