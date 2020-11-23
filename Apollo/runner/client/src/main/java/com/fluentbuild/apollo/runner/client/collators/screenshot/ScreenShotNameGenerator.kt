package com.fluentbuild.apollo.runner.client.collators.screenshot

private const val SCREEN_SHOT_EXTENSION = ".webp"

class ScreenShotNameGenerator {

    private val screenShotCounterMap = mutableMapOf<String, Int>()

    fun generate(prefix: String): String {
        return prefix + getAndIncrementCounter(prefix) + SCREEN_SHOT_EXTENSION
    }

    private fun getAndIncrementCounter(prefix: String): Int {
        val screenShotCounter = screenShotCounterMap.getOrPut(prefix, { 0 })
        screenShotCounterMap[prefix] = screenShotCounter + 1
        return screenShotCounter
    }
}