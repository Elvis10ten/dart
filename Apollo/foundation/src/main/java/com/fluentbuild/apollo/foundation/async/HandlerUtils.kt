package com.fluentbuild.apollo.foundation.async

import android.os.Handler
import android.os.HandlerThread

fun createBackgroundHandler(name: String): Handler {
    val handlerThread = HandlerThread(name)
    handlerThread.start()
    return Handler(handlerThread.looper)
}