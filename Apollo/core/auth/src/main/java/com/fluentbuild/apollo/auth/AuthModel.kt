package com.fluentbuild.apollo.auth

data class AuthModel(
    val uuid: String,
    val email: String,
    val phoneNumber: String,
    val photoUrl: String,
    val firstName: String,
    val lastName: String
)
