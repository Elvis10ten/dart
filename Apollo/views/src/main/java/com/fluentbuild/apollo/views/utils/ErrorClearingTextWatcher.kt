package com.fluentbuild.apollo.views.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputLayout

class ErrorClearingTextWatcher(
    private val input: TextInputLayout
): TextWatcher {

    override fun afterTextChanged(s: Editable) {
        if(input.error != null) {
            input.error = null
        }
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
}
