package com.fluentbuild.apollo.persistence.document

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Allows threads to lock a document based on it's key. This enables multiple documents with different keys to be
 * readable/writable in parallel.
 *
 * Because document data is usually cached in memory after first read from [DocumentStorage],
 * it makes sense to also lock reads so that subsequent threads just read from the memory cache,
 * hence [ReentrantReadWriteLock] was not used.
 */
internal object DocumentLocker {

    private val locks = ConcurrentHashMap<String, ReentrantLock>()

    fun lock(key: String) {
        locks.getOrPut(key) { ReentrantLock() }.lockInterruptibly()
    }

    fun unlock(key: String) {
        val lock = locks[key] ?: throw IllegalStateException("No Document lock with $key key was found")
        lock.unlock()
    }
}
