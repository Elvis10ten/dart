package com.fluentbuild.apollo.work.ft

import com.fluentbuild.apollo.work.FileTransferProto.*
import java.io.IOException
import java.nio.channels.FileChannel

interface Storage {

    @Throws(IOException::class)
    fun createOrAppend(wrapper: MetaWrapper, data: ByteArray)

    fun getSize(wrapper: MetaWrapper): Int

    fun getLastModifiedTime(wrapper: MetaWrapper): Long

    @Throws(IOException::class)
    fun delete(wrapper: MetaWrapper)

    @Throws(IOException::class)
    fun openInputChannel(wrapper: MetaWrapper): FileChannel

    data class MetaWrapper(
        val workKey: String,
        val meta: FileMeta
    )
}