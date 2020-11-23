package com.fluentbuild.apollo.presentation.onboarding

import com.fluentbuild.apollo.analytics.EventPublisher

class OnboardingEventLogger(
    private val publisher: EventPublisher
) {

    fun onGetStartedClicked() {
        publisher.publish("onboarding_get_started_clicked")
    }

    fun onFaqClicked() {
        publisher.publish("onboarding_faq_clicked")
    }
}
