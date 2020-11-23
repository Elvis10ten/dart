package com.fluentbuild.apollo.runtime.store

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import java.util.concurrent.ExecutorService

abstract class BaseStore<T>(
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler
) {

    private var dataCallback: ((T) -> Unit)? = null

    abstract fun getData(): T

    @MainThread
    fun setDataCallback(callback: ((T) -> Unit)?) {
        requireMainThread()
        this.dataCallback = callback

        executorService.execute {
            updateDataCallback(getData())
        }
    }

    protected fun updateDataCallback(data: T) {
        mainThreadHandler.post {
            dataCallback?.invoke(data)
        }
    }
}