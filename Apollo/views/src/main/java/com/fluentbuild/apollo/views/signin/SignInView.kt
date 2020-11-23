package com.fluentbuild.apollo.views.signin

import android.content.Context
import androidx.autofill.HintConstants
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.foundation.android.setAutoFillHintsCompat
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.SigninBinding
import com.fluentbuild.apollo.views.utils.SimpleTextWatcher
import com.fluentbuild.apollo.views.utils.showLinks

class SignInView(
    private val context: Context,
    private val signInClickCallback: (PhoneNumber) -> Unit,
    private val manualVerifyClickCallback: (SmsCode) -> Unit,
    private val phoneNumberInputChangedCallback: (PhoneNumber) -> Unit,
    private val smsCodeInputChangedCallback: (SmsCode) -> Unit
): ViewHolder<SignInViewModel> {

    private lateinit var binding: SigninBinding
    private val phoneNumberInputWatcher = SimpleTextWatcher { phoneNumberInputChangedCallback(it) }
    private val smsCodeInputWatcher = SimpleTextWatcher { smsCodeInputChangedCallback(it) }
    private var hasRegisteredPhoneNumberEditText = false

    override fun create() {
        binding = SigninBinding.inflate(context.getLayoutInflater())

        binding.phoneNumberInput.editText!!.addTextChangedListener(SimpleTextWatcher { phoneNumberInputChangedCallback(getPhoneNumber()) })
        binding.smsCodeInput.editText!!.addTextChangedListener(SimpleTextWatcher { smsCodeInputChangedCallback(it) })
        binding.phoneNumberInput.setAutoFillHintsCompat(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)

        binding.signInButton.setOnClickListener {
            val model = binding.model ?: return@setOnClickListener
            if(model.hasSmsCodeBeenSent) {
                manualVerifyClickCallback(binding.smsCodeInput.editText!!.text.toString())
            } else {
                signInClickCallback(getPhoneNumber())
            }
        }

        binding.termsAndPrivacyText.showLinks()
    }

    fun isPhoneNumberValid() = binding.countryCodePicker.isValidFullNumber

    override fun destroy() {
        binding.phoneNumberInput.editText!!.removeTextChangedListener(phoneNumberInputWatcher)
        binding.smsCodeInput.editText!!.removeTextChangedListener(smsCodeInputWatcher)
        binding.countryCodePicker.deregisterCarrierNumberEditText()
        binding.signInButton.setOnClickListener(null)
    }

    override fun setViewModel(viewModel: SignInViewModel) {
        if(!hasRegisteredPhoneNumberEditText) {
            binding.countryCodePicker.registerCarrierNumberEditText(binding.phoneNumberInput.editText!!)
            hasRegisteredPhoneNumberEditText = true
        }

        binding.model = viewModel
    }

    override fun getRoot() = binding.root

    private fun getPhoneNumber() = binding.countryCodePicker.fullNumberWithPlus
}

typealias PhoneNumber = String
typealias SmsCode = String
