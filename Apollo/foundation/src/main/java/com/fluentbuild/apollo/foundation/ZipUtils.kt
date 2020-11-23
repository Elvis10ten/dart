package com.fluentbuild.apollo.foundation

import com.fluentbuild.apollo.foundation.async.requireNotInterrupted
import java.io.File
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

private const val PREFIX_SEPARATOR = "_"

@Throws(Exception::class)
fun ZipOutputStream.putDir(dirFile: File, filePrefix: String = "") {
    dirFile.listFiles()?.forEach { putFile(filePrefix, it) }
}

@Throws(Exception::class)
fun ZipOutputStream.putFile(filePrefix: String, file: File) {
    requireNotInterrupted()

    val prefixWithNeededSeparator = if(filePrefix.isNotBlank()) {
        filePrefix + PREFIX_SEPARATOR
    } else {
        ""
    }

    if(file.isDirectory) {
        putDir(file, prefixWithNeededSeparator + file.name)
    } else {
        val entryName = prefixWithNeededSeparator + file.name
        putNextEntry(ZipEntry(entryName))
        file.inputStream().autoClose { fileInputStream ->
            fileInputStream.copyTo(this, DEFAULT_IO_BUFFER_SIZE)
        }
    }
}