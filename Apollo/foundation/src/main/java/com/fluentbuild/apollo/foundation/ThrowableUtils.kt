package com.fluentbuild.apollo.foundation

import java.io.PrintWriter
import java.io.StringWriter

fun Throwable.getTrace(): String {
    val stringWriter = StringWriter()
    val writer = PrintWriter(stringWriter)
    printStackTrace(writer)
    return stringWriter.toString()
}