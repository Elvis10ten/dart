package com.fluentbuild.workserver.work.artifacts

import com.fluentbuild.workserver.utils.autoClose
import java.io.File
import java.io.InputStream
import java.util.zip.ZipFile

class ArtifactEntries(
    private val file: File
) {

    fun readEntries(action: (Entry, InputStream) -> Unit) {
        ZipFile(file).autoClose { zipFile ->
            for(zipEntry in zipFile.entries()) {
                val entry = Entry(zipEntry.name, zipEntry.size, zipEntry.lastModifiedTime.toMillis())
                action(entry, zipFile.getInputStream(zipEntry))
            }
        }
    }
}

data class Entry(
    val name: String,
    val sizeBytes: Long,
    val lastModifiedTime: Long
)