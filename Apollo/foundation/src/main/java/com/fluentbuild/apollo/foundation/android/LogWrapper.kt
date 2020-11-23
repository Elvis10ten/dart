package com.fluentbuild.apollo.foundation.android

import android.util.Log

/**
 * A wrapper around log calls. Usually used in a client library.
 */
class LogWrapper(private val isEnabled: Boolean) {

    fun v(tag: String, message: String): Int {
        return if(isEnabled) {
            Log.v(tag, message)
        } else {
            0
        }
    }

    fun i(tag: String, message: String): Int {
        return if(isEnabled) {
            Log.i(tag, message)
        } else {
            0
        }
    }

    fun e(tag: String, throwable: Throwable, message: String): Int {
        return if(isEnabled) {
            return Log.e(tag, message, throwable)
        }  else {
            0
        }
    }

    fun e(tag: String, message: String): Int {
        return if(isEnabled) {
            return Log.e(tag, message)
        }  else {
            0
        }
    }

    fun w(tag: String, message: String): Int {
        return if(isEnabled) {
            return Log.w(tag, message)
        }  else {
            0
        }
    }
}
