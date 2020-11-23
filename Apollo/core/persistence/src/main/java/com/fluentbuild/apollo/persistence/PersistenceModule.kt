package com.fluentbuild.apollo.persistence

import android.content.Context
import com.fluentbuild.apollo.persistence.document.DocumentDb
import com.fluentbuild.apollo.persistence.document.FileDocumentStorage
import com.fluentbuild.apollo.persistence.document.FileProvider
import com.fluentbuild.apollo.persistence.kv.KeyValueStore
import com.fluentbuild.apollo.persistence.kv.SharedPrefKeyValueStore
import com.google.gson.Gson

class PersistenceModule(
    private val appContext: Context,
    private val gson: Gson
) {

    private val documentStorage by lazy {
        FileDocumentStorage(FileProvider(appContext), gson)
    }

    val documentDb by lazy { DocumentDb(documentStorage) }

    fun getKeyValueStore(key: String): KeyValueStore {
        return SharedPrefKeyValueStore(appContext, key)
    }
}
