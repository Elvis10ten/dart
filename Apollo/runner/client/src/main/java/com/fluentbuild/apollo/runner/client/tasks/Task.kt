package com.fluentbuild.apollo.runner.client.tasks

interface Task {

    @Throws(Throwable::class)
    fun run()

    fun isCritical(): Boolean
}