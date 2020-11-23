package com.fluentbuild.apollo.presentation.signin

import android.view.ViewGroup
import com.fluentbuild.apollo.auth.PhoneAuthenticator
import com.fluentbuild.apollo.auth.exceptions.AuthException
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.PresentationModule
import com.fluentbuild.apollo.presentation.utils.mapper.AuthErrorMessage
import com.fluentbuild.apollo.views.R
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.models.UiState
import com.fluentbuild.apollo.views.signin.PhoneNumber
import com.fluentbuild.apollo.views.signin.SignInView
import com.fluentbuild.apollo.views.signin.SignInViewModel
import com.fluentbuild.apollo.views.signin.SmsCode
import com.fluentbuild.apollo.views.validator.MinimumLengthValidator
import com.fluentbuild.apollo.views.validator.NumberValidator

private const val SMS_CODE_MINIMUM_LENGTH = 4

class SigninHost(
    private val navigator: Navigator,
    private val module: PresentationModule
): Host<SignInViewModel, SignInView>() {

    override fun createViewHolder(container: ViewGroup): SignInView {
        return SignInView(
            container.context,
            { onSignInClicked(it) },
            { onManualVerifyClicked(it) },
            { onPhoneNumberInputChanged(it) },
            { onSmsCodeInputChanged(it) }
        )
    }

    private fun onSignInClicked(fullPhoneNumber: PhoneNumber) {
        if(requireSignInView().isPhoneNumberValid()) {
            module.authModule.phoneAuthenticator.verify(fullPhoneNumber)
        } else {
            updateViewHolder(requireViewModel().copy(phoneNumberError = module.runtimeModule.appContext.getString(R.string.phoneNumberInvalid)))
        }
    }

    private fun onManualVerifyClicked(smsCode: SmsCode) {
        if(isSmsCodeValid(smsCode)) {
            updateViewHolder(requireViewModel().copy(state = UiState.Loading))
            module.authModule.phoneAuthenticator.submitCodeManually(smsCode)
        } else {
            updateViewHolder(requireViewModel().copy(smsCodeError = module.runtimeModule.appContext.getString(R.string.otpInvalid)))
        }
    }

    private fun onPhoneNumberInputChanged(fullPhoneNumber: PhoneNumber) {
        updateViewModel(requireViewModel().copy(fullPhoneNumber = fullPhoneNumber))
        if(requireViewModel().phoneNumberError != null && requireSignInView().isPhoneNumberValid()) {
            updateViewHolder(requireViewModel().copy(phoneNumberError = null))
        }
    }

    private fun onSmsCodeInputChanged(smsCode: SmsCode) {
        updateViewModel(requireViewModel().copy(smsCode = smsCode))
        if(requireViewModel().smsCodeError != null && isSmsCodeValid(smsCode)) {
            updateViewHolder(requireViewModel().copy(smsCodeError = null))
        }
    }

    override fun onShow(container: ViewGroup) {
        module.authModule.phoneAuthenticator.setCallback(object: PhoneAuthenticator.Callback {

            override fun onVerificationStarted() {
                updateViewHolder(requireViewModel().copy(
                    state = UiState.Loading
                ))
            }

            override fun onSmsCodeSent() {
                updateViewHolder(requireViewModel().copy(
                    hasSmsCodeBeenSent = true,
                    state = UiState.Idle
                ))
            }

            override fun onSignedIn() {
                val splashHost = module.getSplashHost()
                navigator.clearAndGoto(splashHost)
            }

            override fun onVerificationFailed(exception: AuthException) {
                updateViewHolder(requireViewModel().copy(
                    state = UiState.Error(AuthErrorMessage.get(container.context, exception))
                ))
            }
        })
    }

    override fun onHide(container: ViewGroup) {
        module.authModule.phoneAuthenticator.removeCallback()
    }

    override fun onDestroy() {
        module.authModule.phoneAuthenticator.clearAll()
    }

    override fun createInitialViewModel(): SignInViewModel {
        return SignInViewModel(null, null, null, null, false, UiState.Idle)
    }

    private fun isSmsCodeValid(otp: String) = NumberValidator.isValid(otp) && MinimumLengthValidator(SMS_CODE_MINIMUM_LENGTH).isValid(otp)

    private fun requireSignInView() = (requireViewHolder() as SignInView)
}
