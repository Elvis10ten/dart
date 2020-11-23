package com.fluentbuild.apollo.views.signup

import com.fluentbuild.apollo.views.models.UiState

data class SignupViewModel(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val state: UiState
)
