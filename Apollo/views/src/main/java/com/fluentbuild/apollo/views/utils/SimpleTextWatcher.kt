package com.fluentbuild.apollo.views.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputLayout

class SimpleTextWatcher(
    private val afterTextChangeCallback: (String) -> Unit
): TextWatcher {

    override fun afterTextChanged(s: Editable) {
        afterTextChangeCallback(s.toString())
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
}
