package com.fluentbuild.workserver.utils

class Logger(
    private val className: String
) {

    fun d(message: String, vararg args: Any?) {
        println(className + ": " + message.format(*args))
    }

    fun e(message: String, vararg args: Any?) {
        System.err.println(className + ": " + message.format(*args))
    }

    fun e(throwable: Throwable, message: String, vararg args: Any?) {
        System.err.println(throwable)
        System.err.println(className + ": " + message.format(*args))
    }
}