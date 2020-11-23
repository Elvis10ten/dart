package com.fluentbuild.apollo.persistence.document

import android.util.LruCache
import timber.log.Timber
import java.io.IOException
import java.lang.reflect.Type

/**
 * A lightweight reference to a collection.
 *
 * Collections cannot store data directly but stores Documents which then contains data.
 *
 * This class is thread safe.
 */
class CollectionReference<T>(
    private val collectionName: String,
    private val documentStorage: DocumentStorage,
    private val memoryCache: LruCache<String, DocumentModel<T>>,
    private val documentType: Type
) {

    @Throws(IOException::class)
    fun save(documentId: String, content: Any) {
        val documentKey = getKey(documentId)
        DocumentLocker.lock(documentKey)

        try {
            memoryCache.remove(documentKey)
            documentStorage.save(documentKey, content, documentType)
            Timber.d("%s document saved!", documentKey)
        } finally {
            DocumentLocker.unlock(documentKey)
        }
    }

    @Throws(IOException::class)
    fun get(documentId: String): T? {
        val documentKey = getKey(documentId)
        DocumentLocker.lock(documentKey)

        try {
            return (memoryCache.getOrPut(documentKey) { documentStorage.get(documentKey, documentType) })?.content
        } finally {
            DocumentLocker.unlock(documentKey)
        }
    }

    @Throws(IOException::class)
    fun getCount(): Int {
        return documentStorage.getKeys { isDocumentKey(it) }.size
    }

    @Throws(IOException::class)
    fun isEmpty(): Boolean {
        return getCount() == 0
    }

    @Throws(IOException::class)
    fun contains(documentId: String): Boolean {
        val documentKey = getKey(documentId)
        DocumentLocker.lock(documentKey)

        try {
            return memoryCache.get(documentKey) != null || documentStorage.contains(documentKey)
        } finally {
            DocumentLocker.unlock(documentKey)
        }
    }

    @Throws(IOException::class)
    fun delete(documentId: String) {
        val documentKey = getKey(documentId)
        DocumentLocker.lock(documentKey)

        try {
            memoryCache.remove(documentKey)
            documentStorage.delete(documentKey)
            Timber.d("%s document deleted!", documentKey)
        } finally {
            DocumentLocker.unlock(documentKey)
        }
    }

    @Throws(IOException::class)
    fun drop() {
        val documentKeys = documentStorage.getKeys { isDocumentKey(it) }

        for(documentKey in documentKeys) {
            DocumentLocker.lock(documentKey)

            try {
                memoryCache.remove(documentKey)
                documentStorage.delete(documentKey)
            } finally {
                DocumentLocker.unlock(documentKey)
            }
        }

        Timber.d("%s collection cleared!", collectionName)
    }

    private fun getKey(documentId: String) = "${collectionName}_$documentId"

    private fun isDocumentKey(key: String) = key.startsWith("${collectionName}_")
}

internal inline fun <K, V> LruCache<K, V>.getOrPut(key: K, computeFunction: () -> V?): V? {
    val cachedValue = get(key)

    return if(cachedValue == null) {
        Timber.v("Computing value for %s", key)
        val computedValue = computeFunction()

        if(computedValue != null) {
            put(key, computedValue)
        }

        computedValue
    } else {
        Timber.v("Memory cache hit for %s", key)
        cachedValue
    }
}
