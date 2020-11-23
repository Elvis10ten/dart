package com.fluentbuild.apollo.views.validator

object NameValidator: TextValidator {

    override fun isValid(text: String): Boolean {
        return !text.isBlank()
    }
}
