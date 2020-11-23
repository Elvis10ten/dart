package com.fluentbuild.apollo.presentation.faq

import com.fluentbuild.apollo.analytics.EventPublisher

class FaqEventLogger(
    private val publisher: EventPublisher
) {

    fun onFaqItemCollapsed() {
        publisher.publish("faq_item_collapsed")
    }

    fun onFaqItemExpanded(title: String) {
        publisher.publish(
            "faq_item_expanded",
            mapOf(
                "title" to title
            )
        )
    }

    fun onContactSupportClicked() {
        publisher.publish("faq_contact_support_clicked")
    }

    fun onBackClicked() {
        publisher.publish("faq_back_clicked")
    }
}
