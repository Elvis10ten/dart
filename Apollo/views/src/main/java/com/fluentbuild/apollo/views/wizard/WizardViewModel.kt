package com.fluentbuild.apollo.views.wizard

data class WizardViewModel(
    val currentIndex: Int = 0,
    val wizards: List<Wizard>
) {

    fun getCurrentWizard() = wizards[currentIndex]
}
