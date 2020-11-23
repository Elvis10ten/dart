package com.fluentbuild.apollo.work.ft

interface FtLogger {

    fun i(message: () -> String)

    fun e(throwable: Throwable, message: () -> String)
}