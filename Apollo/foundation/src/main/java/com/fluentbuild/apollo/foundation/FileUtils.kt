package com.fluentbuild.apollo.foundation

import android.os.ParcelFileDescriptor
import java.io.*

fun File.overwrite(): Boolean {
    if(exists()) {
        delete()
    }

    return createNewFile()
}

@Throws(IOException::class)
fun File.requireDeleteDirectory() {
    if(!deleteRecursively()) {
        throw IOException("Directory was not successfully deleted")
    }
}

fun File.sizeMbCeil(): Long {
    return kotlin.math.ceil(length() / 1024.0 / 1024.0).toLong()
}

@Throws(IOException::class)
fun ParcelFileDescriptor.copyFrom(sourceFile: File) {
    autoCloseOutputStream { destOutputStream ->
        sourceFile.inputStream().autoClose { sourceInputStream ->
            sourceInputStream.copyTo(destOutputStream, DEFAULT_IO_BUFFER_SIZE)
            destOutputStream.flush()
        }
    }
}

fun ParcelFileDescriptor.createOutputStream() = FileOutputStream(fileDescriptor)

@Throws(IOException::class)
fun ParcelFileDescriptor.autoCloseOutputStream(action: (OutputStream) -> Unit) {
    autoClose {
        createOutputStream().autoClose { outputStream ->
            action(outputStream)
            outputStream.flush()
            fileDescriptor.sync()
        }
    }
}

@Throws(IOException::class)
fun ParcelFileDescriptor.autoCloseBufferedWriter(action: (Writer) -> Unit) {
    autoClose {
        createOutputStream().bufferedWriter().autoClose { writer ->
            action(writer)
            writer.flush()
            fileDescriptor.sync()
        }
    }
}

fun InputStream.copyAllLines(parcelFileDescriptor: ParcelFileDescriptor) {
    bufferedReader().autoClose { reader ->
        parcelFileDescriptor.autoCloseBufferedWriter { writer ->
            reader.lineSequence().forEach { line ->
                writer.appendln(line)
            }
        }
    }
}

fun File.openParcelFileDescriptor(mode: String): ParcelFileDescriptor {
    return ParcelFileDescriptor.open(this, stringModeToIntMode(mode))
}

fun String.concatPaths(path: String): String {
    return this + File.separator + path
}

fun FileInputStream.readText() = bufferedReader().readText()

private fun stringModeToIntMode(mode: String): Int {
    return if ("r" == mode) {
        ParcelFileDescriptor.MODE_READ_ONLY
    } else if ("w" == mode || "wt" == mode) {
        (ParcelFileDescriptor.MODE_WRITE_ONLY
                or ParcelFileDescriptor.MODE_CREATE
                or ParcelFileDescriptor.MODE_TRUNCATE)
    } else if ("wa" == mode) {
        (ParcelFileDescriptor.MODE_WRITE_ONLY
                or ParcelFileDescriptor.MODE_CREATE
                or ParcelFileDescriptor.MODE_APPEND)
    } else if ("rw" == mode) {
        (ParcelFileDescriptor.MODE_READ_WRITE
                or ParcelFileDescriptor.MODE_CREATE)
    } else if ("rwt" == mode) {
        (ParcelFileDescriptor.MODE_READ_WRITE
                or ParcelFileDescriptor.MODE_CREATE
                or ParcelFileDescriptor.MODE_TRUNCATE)
    } else {
        throw IllegalArgumentException("Invalid mode: $mode")
    }
}