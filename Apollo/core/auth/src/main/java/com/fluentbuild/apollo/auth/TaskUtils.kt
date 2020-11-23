package com.fluentbuild.apollo.auth

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import timber.log.Timber
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <Result> Task<Result>.await(timeoutMillis: Int): Result {
    try {
        return Tasks.await(this, timeoutMillis.toLong(), TimeUnit.MILLISECONDS)
    } catch (e: Exception) {
        throw getTaskException(e)
    }
}

private fun getTaskException(e: Exception): Throwable {
    Timber.e(e, "Error running task")
    return when (e) {
        is InterruptedException -> {
            TimeoutException("Request has timed out")
        }
        is ExecutionException -> {
            val actualException = e.cause ?: e
            actualException
        }
        else -> {
            e
        }
    }
}
