package com.fluentbuild.apollo.runtime.models

import com.fluentbuild.apollo.auth.Money

data class WorkHistory(
    val key: String,
    val status: Status,
    val earned: Money,
    val duration: Minute,
    val lastUpdated: Long
) {

    enum class Status {
        PENDING,
        SUCCESS,
        FAILED
    }
}
