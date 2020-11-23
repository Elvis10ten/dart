package com.fluentbuild.apollo.auth

data class SignupRequest(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
