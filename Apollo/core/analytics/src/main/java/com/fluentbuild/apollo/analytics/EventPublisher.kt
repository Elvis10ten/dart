package com.fluentbuild.apollo.analytics

import android.content.Context
import com.crashlytics.android.core.CrashlyticsCore
import com.fluentbuild.apollo.foundation.toBundle
import com.google.firebase.analytics.FirebaseAnalytics
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class EventPublisher(appContext: Context) {

    private val firebaseAnalytics: FirebaseAnalytics
    private val crashlytics: CrashlyticsCore

    init {
        Fabric.with(appContext, CrashlyticsCore())
        firebaseAnalytics = FirebaseAnalytics.getInstance(appContext)
        crashlytics = CrashlyticsCore.getInstance()
    }

    fun initProps(userId: String) {
        firebaseAnalytics.setUserProperty("userId", userId)
        crashlytics.setUserIdentifier(userId)
    }

    fun publish(name: String, properties: Map<String, String> = emptyMap()) {
        Timber.d("Publishing event, name: %s, props: %s", name, properties)
        firebaseAnalytics.logEvent(name, properties.toBundle())
    }

    fun publish(throwable: Throwable) {
        crashlytics.logException(throwable)
    }
}
