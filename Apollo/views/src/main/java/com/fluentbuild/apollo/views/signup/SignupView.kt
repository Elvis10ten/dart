package com.fluentbuild.apollo.views.signup

import android.content.Context
import androidx.autofill.HintConstants
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.foundation.android.setAutoFillHintsCompat
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.SignupBinding
import com.fluentbuild.apollo.views.utils.SimpleTextWatcher

class SignupView(
    private val context: Context,
    private val signupClickCallback: (SignupFormInput) -> Unit,
    private val firstNameInputChangedCallback: (String) -> Unit,
    private val lastNameInputChangedCallback: (String) -> Unit,
    private val emailInputChangedCallback: (String) -> Unit,
    private val passwordInputChangedCallback: (String) -> Unit
): ViewHolder<SignupViewModel> {

    private lateinit var binding: SignupBinding
    private val firstNameWatcher = SimpleTextWatcher { firstNameInputChangedCallback(it) }
    private val lastNameWatcher = SimpleTextWatcher { lastNameInputChangedCallback(it) }
    private val emailWatcher = SimpleTextWatcher { emailInputChangedCallback(it) }
    private val passwordWatcher = SimpleTextWatcher { passwordInputChangedCallback(it) }

    override fun create() {
        binding = SignupBinding.inflate(context.getLayoutInflater())

        binding.firstNameInput.editText!!.addTextChangedListener(firstNameWatcher)
        binding.lastNameInput.editText!!.addTextChangedListener(lastNameWatcher)
        binding.emailInput.editText!!.addTextChangedListener(emailWatcher)
        binding.passwordInput.editText!!.addTextChangedListener(passwordWatcher)

        binding.firstNameInput.setAutoFillHintsCompat(HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN)
        binding.lastNameInput.setAutoFillHintsCompat(HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY)
        binding.emailInput.setAutoFillHintsCompat(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS)
        binding.passwordInput.setAutoFillHintsCompat(HintConstants.AUTOFILL_HINT_NEW_PASSWORD)

        binding.signupButton.setOnClickListener { signupClickCallback(getSignupFormInput()) }
    }

    override fun destroy() {
        binding.firstNameInput.editText!!.removeTextChangedListener(firstNameWatcher)
        binding.lastNameInput.editText!!.removeTextChangedListener(lastNameWatcher)
        binding.emailInput.editText!!.removeTextChangedListener(emailWatcher)
        binding.passwordInput.editText!!.removeTextChangedListener(passwordWatcher)
        binding.signupButton.setOnClickListener(null)
    }

    private fun getSignupFormInput(): SignupFormInput {
        return SignupFormInput(
            binding.firstNameInput.editText!!.text.toString(),
            binding.lastNameInput.editText!!.text.toString(),
            binding.passwordInput.editText!!.text.toString(),
            binding.emailInput.editText!!.text.toString()
        )
    }

    override fun setViewModel(viewModel: SignupViewModel) {
        binding.model = viewModel
    }

    override fun getRoot() = binding.root
}
