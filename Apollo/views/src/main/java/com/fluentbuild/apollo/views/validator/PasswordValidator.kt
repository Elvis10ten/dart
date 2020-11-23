package com.fluentbuild.apollo.views.validator

object PasswordValidator: TextValidator {

    private val validPasswordLength = 6..30

    override fun isValid(text: String): Boolean {
        return !text.isBlank() && text.length in validPasswordLength
    }
}
