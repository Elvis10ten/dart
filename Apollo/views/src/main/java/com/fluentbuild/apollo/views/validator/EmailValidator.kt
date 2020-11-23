package com.fluentbuild.apollo.views.validator

import android.util.Patterns

object EmailValidator: TextValidator {

    override fun isValid(text: String): Boolean {
        return !text.isBlank() && Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }
}
