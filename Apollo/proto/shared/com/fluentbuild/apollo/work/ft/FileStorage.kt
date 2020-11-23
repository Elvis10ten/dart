package com.fluentbuild.apollo.work.ft

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel

class FileStorage(
    private val parentDir: File,
    private val logger: FtLogger
): Storage {

    override fun createOrAppend(wrapper: Storage.MetaWrapper, data: ByteArray) {
        val file = getFile(wrapper)
        val outputStream = FileOutputStream(file, true)

        try {
            outputStream.write(data)
            outputStream.flush()
            outputStream.fd.sync()
            file.setLastModified(wrapper.meta.lastModified)
        } finally {
            outputStream.closeSilently(logger)
        }
    }

    override fun getSize(wrapper: Storage.MetaWrapper): Int {
        return getFile(wrapper).getSize()
    }

    override fun getLastModifiedTime(wrapper: Storage.MetaWrapper): Long {
        return getFile(wrapper).lastModified()
    }

    override fun delete(wrapper: Storage.MetaWrapper) {
        logger.i { "Deleting file: ${wrapper.meta}" }
        val file = getFile(wrapper)
        if(!file.delete()) {
            throw IOException("Failed to delete file: $file")
        }
    }

    override fun openInputChannel(wrapper: Storage.MetaWrapper): FileChannel {
        return getFile(wrapper).inputStream().channel
    }

    private fun getFile(wrapper: Storage.MetaWrapper) =
        File(parentDir, wrapper.meta.fileName)
}