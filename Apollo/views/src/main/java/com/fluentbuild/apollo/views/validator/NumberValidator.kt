package com.fluentbuild.apollo.views.validator

object NumberValidator: TextValidator {

    override fun isValid(text: String): Boolean {
        return !text.isBlank() && (text.toIntOrNull() != null)
    }
}
