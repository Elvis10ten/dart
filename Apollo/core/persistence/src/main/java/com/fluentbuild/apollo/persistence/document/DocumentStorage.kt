package com.fluentbuild.apollo.persistence.document

import java.io.IOException
import java.lang.reflect.Type

interface DocumentStorage {

    @Throws(IOException::class)
    fun save(documentKey: String, content: Any, documentType: Type)

    @Throws(IOException::class)
    fun <T> get(documentKey: String, documentType: Type): DocumentModel<T>?

    @Throws(IOException::class)
    fun getKeys(keyPredicate: (documentKey: String) -> Boolean): Set<String>

    @Throws(IOException::class)
    fun contains(documentKey: String): Boolean

    @Throws(IOException::class)
    fun delete(documentKey: String)
}
