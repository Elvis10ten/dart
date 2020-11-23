package com.fluentbuild.workserver.utils

import java.io.Closeable

private const val LOG_TAG = "IoUtils"
const val DEFAULT_IO_BUFFER_SIZE = 64 * 1024

/**
 * Closes the given AutoCloseable quietly.
 * @param errorLogger called to log any failure should the close fail
 */
fun AutoCloseable?.closeCatching(errorLogger: (Exception) -> Unit) {
    try {
        this?.close()
    } catch (e: Exception) {
        errorLogger(e)
    }
}

/**
 * Closes the given Closeable quietly.
 * @param errorLogger called to log any failure should the close fail
 */
fun Closeable?.closeCatching(errorLogger: (Exception) -> Unit) {
    try {
        this?.close()
    } catch (e: Exception) {
        errorLogger(e)
    }
}

public inline fun <T : Closeable?, R> T.autoClose(block: (T) -> R): R {
    return try {
        block(this)
    } finally {
        closeCatching { it.printStackTrace() }
    }
}