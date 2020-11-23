package com.fluentbuild.apollo.views.validator

class MinimumLengthValidator(
    private val requiredMinimumLength: Int
): TextValidator {

    override fun isValid(text: String): Boolean {
        return !text.isBlank() && text.length >= requiredMinimumLength
    }
}
