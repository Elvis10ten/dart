package com.fluentbuild.apollo.presentation.home

import com.fluentbuild.apollo.analytics.EventPublisher
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.WorkHistory

class HomeEventLogger(
    private val publisher: EventPublisher
) {

    fun onShutdownClicked(currentState: RuntimeState) {
        publisher.publish("home_shutdown_clicked")
    }

    fun onStartupClicked(currentState: RuntimeState) {
        publisher.publish("home_startup_clicked")
    }

    fun onShowShutdownConfirmation() {
        publisher.publish("home_shutdown_confirmation")
    }

    fun onShutdownConfirmed() {
        publisher.publish("home_shutdown_confirmed")
    }

    fun onShutdownNotConfirmed() {
        publisher.publish("home_shutdown_not_confirmed")
    }

    fun onHelpClicked() {
        publisher.publish("home_help_clicked")
    }

    fun onSettingsClicked() {
        publisher.publish("home_settings_clicked")
    }

    fun onProfileClicked() {
        publisher.publish("home_profile_clicked")
    }

    fun onEnableScheduleClicked() {
        publisher.publish("home_enable_schedule_clicked")
    }

    fun onHistoryClicked(history: WorkHistory) {
        publisher.publish(
            "history_clicked",
            mapOf(
                "key" to history.key
            )
        )
    }
}
