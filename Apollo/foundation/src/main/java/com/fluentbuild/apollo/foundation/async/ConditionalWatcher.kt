package com.fluentbuild.apollo.foundation.async

import java.util.concurrent.TimeoutException

private const val WATCH_INTERVAL_MILLIS = 2000L

/**
 * Watches a condition until it becomes true or times out
 */
class ConditionalWatcher(
    private val conditionChecker: () -> Boolean,
    private val timeoutExceptionCreator: (Long) -> Exception = { TimeoutException() },
    private val timeoutMillis: Long,
    private val watchInterval: Long = WATCH_INTERVAL_MILLIS
) {

    @Throws(Exception::class)
    fun waitForCondition() {
        var elapsedTime = 0L
        while(!conditionChecker()) {
            requireNotInterrupted()
            if(elapsedTime <= timeoutMillis) {
                Thread.sleep(watchInterval)
                elapsedTime += watchInterval
            } else {
                throw timeoutExceptionCreator(timeoutMillis)
            }
        }
    }
}