package com.fluentbuild.apollo.presentation.onboarding

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.faq.FaqHost
import com.fluentbuild.apollo.presentation.signin.SigninHost
import com.fluentbuild.apollo.views.onboarding.OnboardingView
import com.fluentbuild.apollo.views.onboarding.OnboardingViewModel

class OnboardingHost(
    private val eventLogger: OnboardingEventLogger,
    private val navigator: Navigator,
    private val signinHostProvider: () -> SigninHost,
    private val faqHostProvider: () -> FaqHost
): Host<OnboardingViewModel, OnboardingView>() {

    override fun createViewHolder(container: ViewGroup): OnboardingView {
        return OnboardingView(
            container.context as FragmentActivity,
            { onGetStartedClicked() },
            { onFaqClicked() }
        )
    }

    private fun onGetStartedClicked() {
        eventLogger.onGetStartedClicked()
        navigator.goto(signinHostProvider())
    }

    private fun onFaqClicked() {
        eventLogger.onFaqClicked()
        navigator.goto(faqHostProvider())
    }

    override fun createInitialViewModel(): OnboardingViewModel {
        return OnboardingViewModel()
    }
}
