package com.fluentbuild.apollo.runtime.models

data class UiData(
    val message: String,
    val extras: Map<String, String> = emptyMap()
)
