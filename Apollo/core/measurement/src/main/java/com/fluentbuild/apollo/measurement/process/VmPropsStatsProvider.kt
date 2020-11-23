package com.fluentbuild.apollo.measurement.process

import com.fluentbuild.apollo.measurement.VmPropsStatsProto.VmPropsStats

class VmPropsStatsProvider {

    fun getStats(): VmPropsStats {
        return VmPropsStats.newBuilder()
            .putAllEnvironmentVariables(getEnvironmentVariables())
            .putAllProperties(getProperties())
            .build()
    }

    private fun getProperties(): Map<String, String> {
        val systemProperties = System.getProperties()
        val filteredProperties = mutableMapOf<String, String>()

        for(property in systemProperties) {
            if(property.key != null && property.value != null) {
                filteredProperties[property.key.toString()] = property.value.toString()
            }
        }

        return filteredProperties
    }

    private fun getEnvironmentVariables(): Map<String, String> {
        return System.getenv()
    }
}
