package com.fluentbuild.apollo.persistence.document

import android.util.LruCache
import java.lang.reflect.Type

private const val MEMORY_CACHE_MAX_SIZE_BYTES = 2 * 1024 * 1024 // 2 MB

/**
 * DocumentDB is a simple and fast NO-SQL DB. It was designed to store large "unstructured" data that would
 * not make sense to be stored in an SQLite DB or SharedPreferences.
 *
 * Objects (data) are stored in Documents, which are stored in Collections. Collections/Documents do not need
 * to be explicitly created, as they are implicitly created the first time data is saved to a document.
 */
class DocumentDb(private val documentStorage: DocumentStorage) {

    fun <T> collection(collectionName: String, documentType: Type): CollectionReference<T> {
        @Suppress("UNCHECKED_CAST") // Cast from wildcard to <T> type
        val memoryCache = lruCache as LruCache<String, DocumentModel<T>>
        return CollectionReference(collectionName, documentStorage, memoryCache, documentType)
    }

    private val lruCache = object: LruCache<String, DocumentModel<Any>>(MEMORY_CACHE_MAX_SIZE_BYTES) {

        override fun sizeOf(key: String, document: DocumentModel<Any>) = document.size.toInt()
    }
}
