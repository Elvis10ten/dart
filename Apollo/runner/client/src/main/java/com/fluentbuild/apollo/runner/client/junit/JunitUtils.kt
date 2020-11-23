package com.fluentbuild.apollo.runner.client.junit

import android.util.Log
import com.fluentbuild.apollo.runner.TestDescription
import com.fluentbuild.apollo.runner.TestFailure
import com.fluentbuild.apollo.runner.TestResult
import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.notification.Failure

private const val MAX_TRACE_SIZE = 64 * 1024
private const val LOG_TAG = "JunitUtils"

internal fun Description.createTestModel(): TestDescription {
    return TestDescription(className, methodName, displayName)
}

internal fun Failure.createTestModel(): TestFailure {
    var stackTrace = trace

    if (stackTrace.length > MAX_TRACE_SIZE) {
        // Since we report failures back to the runtime via a binder IPC, we need to make sure that
        // we don't exceed the Binder transaction limit - which is 1MB per process.
        Log.w(LOG_TAG, "Stack trace too long, trimmed to first $MAX_TRACE_SIZE characters.")
        stackTrace = trace.substring(0, MAX_TRACE_SIZE) + "\n"
    }

    return TestFailure(description.createTestModel(), stackTrace)
}

internal fun Result.createTestModel(): TestResult {
    return TestResult(runTime, ignoreCount, failures.map { it.createTestModel() })
}