package com.fluentbuild.apollo.runner.client.instrumentation.lifecycle

import java.lang.ref.WeakReference

abstract class Monitor<C> {

    private val callbacks = mutableListOf<WeakReference<C>>()

    protected fun forEachCallback(action: (C, MutableIterator<WeakReference<C>>) -> Unit) {
        val callbackIterator = callbacks.iterator()
        while(callbackIterator.hasNext()) {
            val callback = callbackIterator.next().get()
            if(callback == null) {
                callbackIterator.remove()
                continue
            }

            action(callback, callbackIterator)
        }
    }

    internal fun registerCallback(callback: C) {
        var shouldAddCallback = true
        forEachCallback { storedCallback, _ ->
            if(storedCallback == callback) {
                shouldAddCallback = false
            }
        }

        if(shouldAddCallback) {
            callbacks += WeakReference(callback)
        }
    }

    internal fun unregisterCallback(callback: C) {
        forEachCallback { storedCallback, iterator ->
            if(storedCallback == callback) {
                iterator.remove()
            }
        }
    }
}