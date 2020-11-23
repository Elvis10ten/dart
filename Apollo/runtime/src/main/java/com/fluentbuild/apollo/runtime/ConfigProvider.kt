package com.fluentbuild.apollo.runtime

class ConfigProvider {

    fun getFindWorkTimeoutSeconds() = 60 * 10

    fun getHostName() = "192.168.7.21"

    fun getPort() = 5050
}