package com.fluentbuild.apollo.runner.base

object TestKeys {

    object Status {
        const val RUN_STARTED = "RUN_STARTED"
        const val RUN_FINISHED = "RUN_FINISHED"
        const val STARTED = "TEST_STARTED"
        const val ASSUME_FAILURE = "TEST_ASSUME_FAILURE"
        const val FINISHED = "TEST_FINISHED"
        const val FAILURE = "TEST_FAILURE"
        const val IGNORED = "IGNORED"
        const val PROCESS_CRASHED = "PROCESS_CRASHED"
        const val INSTRUMENTATION_RUN_FINISHED = "INSTRUMENTATION_RUN_FINISHED"
    }
}