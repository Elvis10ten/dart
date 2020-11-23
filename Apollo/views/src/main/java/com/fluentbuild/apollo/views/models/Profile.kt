package com.fluentbuild.apollo.views.models

data class Profile(
    val photoUrl: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String
) {

    fun getFullName() = "$firstName $lastName"
}
