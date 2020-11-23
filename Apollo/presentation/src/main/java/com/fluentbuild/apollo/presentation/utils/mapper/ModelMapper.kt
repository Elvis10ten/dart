package com.fluentbuild.apollo.presentation.utils.mapper

import com.fluentbuild.apollo.auth.AuthModel
import com.fluentbuild.apollo.views.models.Profile

internal fun AuthModel.toProfile() = Profile(
    photoUrl,
    firstName,
    lastName,
    email,
    phoneNumber
)
