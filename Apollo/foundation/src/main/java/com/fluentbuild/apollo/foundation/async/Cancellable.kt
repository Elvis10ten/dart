package com.fluentbuild.apollo.foundation.async

/**
 * Represents an asynchronous task that can be cancelled.
 */
interface Cancellable {
    fun cancel()
}

class NoOpsCancellable(): Cancellable {
    override fun cancel() {}
}

class Cancellables {

    private val cancellableList = mutableListOf<Cancellable>()

    fun add(cancellable: Cancellable) {
        cancellableList.add(cancellable)
    }

    fun cancelAll() {
        cancellableList.forEach { it.cancel() }
        cancellableList.clear()
    }
}