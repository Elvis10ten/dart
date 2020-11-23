package com.fluentbuild.apollo.presentation.signup

import android.content.Context
import android.view.ViewGroup
import com.fluentbuild.apollo.auth.SignupRequest
import com.fluentbuild.apollo.foundation.async.ServiceState
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.PresentationModule
import com.fluentbuild.apollo.presentation.utils.mapper.AuthErrorMessage
import com.fluentbuild.apollo.views.R
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.models.UiState
import com.fluentbuild.apollo.views.signup.SignupFormInput
import com.fluentbuild.apollo.views.signup.SignupView
import com.fluentbuild.apollo.views.signup.SignupViewModel
import com.fluentbuild.apollo.views.validator.EmailValidator
import com.fluentbuild.apollo.views.validator.NameValidator
import com.fluentbuild.apollo.views.validator.PasswordValidator

class SignupHost(
    private val navigator: Navigator,
    private val module: PresentationModule
): Host<SignupViewModel, SignupView>() {

    override fun createViewHolder(container: ViewGroup): SignupView {
        return SignupView(
            container.context,
            { onSignupClicked(container.context, it) },
            { onFirstNameInputChanged(it) },
            { onLastNameInputChanged(it) },
            { onEmailInputChanged(it) },
            { onPasswordInputChanged(it) }
        )
    }

    private fun onSignupClicked(context: Context, formInput: SignupFormInput) {
        var isFormValid = true

        if(!NameValidator.isValid(formInput.firstName)) {
            isFormValid = false
            updateViewHolder(requireViewModel().copy(
                firstNameError = context.getString(R.string.signupFirstNameInvalid)
            ))
        }

        if(!NameValidator.isValid(formInput.lastName)) {
            isFormValid = false
            updateViewHolder(requireViewModel().copy(
                lastNameError = context.getString(R.string.signupLastNameInvalid)
            ))
        }

        if(!EmailValidator.isValid(formInput.email)) {
            isFormValid = false
            updateViewHolder(requireViewModel().copy(
                emailError = context.getString(R.string.signupEmailInvalid)
            ))
        }

        if(!PasswordValidator.isValid(formInput.password)) {
            isFormValid = false
            updateViewHolder(requireViewModel().copy(
                passwordError = context.getString(R.string.signupPasswordInvalid)
            ))
        }

        if(isFormValid) {
            signup(formInput)
        }
    }

    private fun onFirstNameInputChanged(firstName: String) {
        updateViewModel(requireViewModel().copy(firstName = firstName))
        if(requireViewModel().firstNameError != null && NameValidator.isValid(firstName)) {
            updateViewHolder(requireViewModel().copy(firstNameError = null))
        }
    }

    private fun onLastNameInputChanged(lastName: String) {
        updateViewModel(requireViewModel().copy(lastName = lastName))
        if(requireViewModel().lastNameError != null && NameValidator.isValid(lastName)) {
            updateViewHolder(requireViewModel().copy(lastNameError = null))
        }
    }

    private fun onEmailInputChanged(email: String) {
        updateViewModel(requireViewModel().copy(email = email))
        if(requireViewModel().emailError != null && EmailValidator.isValid(email)) {
            updateViewHolder(requireViewModel().copy(emailError = null))
        }
    }

    private fun onPasswordInputChanged(password: String) {
        updateViewModel(requireViewModel().copy(password = password))
        if(requireViewModel().passwordError != null && PasswordValidator.isValid(password)) {
            updateViewHolder(requireViewModel().copy(passwordError = null))
        }
    }

    override fun createInitialViewModel(): SignupViewModel {
        return SignupViewModel(
            firstName = null,
            lastName = null,
            email = null,
            password = null,
            firstNameError = null,
            lastNameError = null,
            emailError = null,
            passwordError = null,
            state = UiState.Idle
        )
    }

    override fun onInit() {
        module.authModule.signupService.cleanup()
    }

    override fun onShow(container: ViewGroup) {
        module.authModule.signupService.setCallback { state ->
            val uiState = when(state) {
                is ServiceState.Idle -> UiState.Idle
                is ServiceState.Loading -> UiState.Loading
                is ServiceState.Error -> UiState.Error(AuthErrorMessage.get(container.context, state.exception))
                is ServiceState.Success -> UiState.Loading
            }
            updateViewHolder(requireViewModel().copy(state = uiState))

            if(state is ServiceState.Success) {
                navigator.goto(module.getSplashHost())
            }
        }
    }

    override fun onHide(container: ViewGroup) {
        module.authModule.signupService.removeCallback()
    }

    private fun signup(formInput: SignupFormInput) {
        val request = with(formInput) {
            SignupRequest(
                email,
                password,
                firstName,
                lastName
            )
        }
        module.authModule.signupService.signup(request)
    }
}
