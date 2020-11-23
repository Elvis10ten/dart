package com.fluentbuild.apollo.runner.base

interface WorkInterruptCallback {

    fun onInterrupted(reason: Reason)

    enum class Reason(val id: Int) {
        WINDOW_PRESSED(0),
        HOME_PRESSED(1),
        RECENT_APPS_PRESSED(2),
        KEY_PRESSED(3);

        companion object {

            fun of(id: Int): Reason {
                return values().first { it.id == id }
            }
        }
    }
}