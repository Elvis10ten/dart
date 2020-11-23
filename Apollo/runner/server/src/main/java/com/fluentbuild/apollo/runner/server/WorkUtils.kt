package com.fluentbuild.apollo.runner.server

import com.fluentbuild.apollo.runner.TestDescription
import com.fluentbuild.apollo.work.WorkProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.apollo.work.tests.AtomicTestProto.*

fun Work.findTest(description: TestDescription): AtomicTest? {
    return testsList.firstOrNull() { test ->
        test.methodName == description.methodName &&
                test.className == description.className
    }
}

fun AtomicTest.getFullName() = "$className#$methodName"

fun AtomicResult.isRunFailed() =
    status == Status.ERROR || status == Status.FAILURE