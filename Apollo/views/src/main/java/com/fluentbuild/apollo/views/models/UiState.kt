package com.fluentbuild.apollo.views.models

sealed class UiState {

    object Idle : UiState()

    object Loading : UiState()

    class Error(val message: String): UiState()
}
