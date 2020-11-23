package com.fluentbuild.apollo.analytics

import android.content.Context

class AnalyticsModule(
    private val appContext: Context
) {

    val eventPublisher by lazy { EventPublisher(appContext) }
}
