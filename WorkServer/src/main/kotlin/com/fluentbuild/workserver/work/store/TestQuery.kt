package com.fluentbuild.workserver.work.store

data class TestQuery(
    val workKey: String,
    val deviceKey: String,
    val testKey: String
) {

    fun createDeviceWorkQuery() = DeviceWorkQuery(workKey, deviceKey)
}