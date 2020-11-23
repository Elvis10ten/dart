package com.fluentbuild.apollo.runner.client.instrumentation

import android.app.Instrumentation
import android.os.Bundle
import android.os.Process
import android.util.Log

private const val LOG_TAG = "InstrumentationUtils"

fun Instrumentation.finishInstrumentation(resultCode: Int, results: Bundle? = null) {
    Thread {
        try {
            Log.i(LOG_TAG, "Finishing instrumentation: $resultCode")
            finish(resultCode, results)
        } catch (t: Throwable) {
            Log.e(LOG_TAG, "Failed to finish instrumentation", t)
            Log.i(LOG_TAG, "Just killing process!")
            Process.killProcess(Process.myPid())
        }
    }.apply {
        isDaemon = true
        name = "FinisherThread"
        start()
    }
}