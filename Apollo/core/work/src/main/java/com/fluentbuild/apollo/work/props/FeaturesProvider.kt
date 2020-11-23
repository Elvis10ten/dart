package com.fluentbuild.apollo.work.props

import android.content.Context
import android.content.pm.FeatureInfo
import com.fluentbuild.apollo.foundation.android.AndroidVersion

internal class FeaturesProvider(
    private val appContext: Context
) {

    fun get(): Features {
        var openGleVersion = FeatureInfo.GL_ES_VERSION_UNDEFINED
        val featureVersionMap = mutableMapOf<String, Int>()

        for(availableFeature in appContext.packageManager.systemAvailableFeatures) {
            if(availableFeature.name == null) {
                openGleVersion = availableFeature.reqGlEsVersion
            } else {
                val version = if(AndroidVersion.isAtLeastNougat()) {
                    availableFeature.version
                } else {
                    0
                }
                featureVersionMap[availableFeature.name] = version
            }
        }

        return Features(featureVersionMap, openGleVersion)
    }
}

data class Features(
    val features: Map<FeatureName, FeatureVersion>,
    val openGleVersion: Int
)

typealias FeatureName = String
typealias FeatureVersion = Int