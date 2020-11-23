package com.fluentbuild.apollo.foundation.async

import android.os.Looper
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Requires that the current thread is the main thread.
 */
@MainThread
fun requireMainThread() =
    check(Looper.myLooper() == Looper.getMainLooper()) { "Not on the main thread" }

/**
 * Requires that the current thread is NOT the main thread.
 */
@WorkerThread
fun requireNotMainThread() =
    check(Looper.myLooper() != Looper.getMainLooper()) { "Currently on main thread" }

fun requireNotInterrupted() {
    if(Thread.interrupted()) {
        throw InterruptedException("Thread was interrupted")
    }
}

fun createThreadPoolExecutor(): ThreadPoolExecutor {
    val corePoolSize = Runtime.getRuntime().availableProcessors()
    val maximumPoolSize = corePoolSize * 2
    val keepAliveTimeMillis = 1L

    return ThreadPoolExecutor(
        corePoolSize,
        maximumPoolSize,
        keepAliveTimeMillis,
        TimeUnit.MILLISECONDS,
        LinkedBlockingQueue()
    )
}