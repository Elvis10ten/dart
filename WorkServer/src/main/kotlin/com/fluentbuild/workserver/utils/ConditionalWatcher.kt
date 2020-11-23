package com.fluentbuild.workserver.utils

private const val WATCH_INTERVAL_MILLIS = 2000L

class ConditionalWatcher(
    private val conditionChecker: () -> Boolean,
    private val timeoutExceptionCreator: (Long) -> Exception,
    private val timeoutMillis: Long,
    private val watchInterval: Long = WATCH_INTERVAL_MILLIS
) {

    fun waitForCondition() {
        var elapsedTime = 0L
        while(!conditionChecker()) {
            if(elapsedTime <= timeoutMillis) {
                Thread.sleep(watchInterval)
                elapsedTime += watchInterval
            } else {
                throw timeoutExceptionCreator(timeoutMillis)
            }
        }
    }
}