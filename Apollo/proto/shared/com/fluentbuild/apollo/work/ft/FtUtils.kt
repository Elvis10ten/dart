package com.fluentbuild.apollo.work.ft

import com.fluentbuild.apollo.work.FileTransferProto.*
import com.fluentbuild.apollo.work.SendFileWrapperProto.*
import com.fluentbuild.apollo.work.UploadResultResponseProto.*
import com.google.protobuf.ByteString
import java.io.Closeable
import java.io.File
import java.nio.ByteBuffer
import kotlin.math.abs

internal const val CHUNK_MAX_SIZE = 2 * 1024 * 1024 // 2 MB
internal const val AWAIT_READY_TIMEOUT_MILLIS = 60_000L
internal const val MIN_FRESHNESS_MILLIS = 60 * 60 * 1000L

internal fun File.toProto(): FileMeta {
    return FileMeta.newBuilder()
        .setFileName(name)
        .setLastModified(lastModified())
        .setSize(getSize())
        .build()
}

internal fun createRange(startOffset: Int, size: Int): Range {
    return Range.newBuilder()
        .setStartOffset(startOffset)
        .setSize(size)
        .build()
}

internal fun ByteBuffer.createChunk(meta: FileMeta, range: Range): ChunkResponse {
    return ChunkResponse.newBuilder()
        .setData(ByteString.copyFrom(this.array(), 0, range.size))
        .setRange(range)
        .setFileMeta(meta)
        .build()
}

internal fun File.getSize(): Int {
    if(length() > Int.MAX_VALUE) {
        throw IllegalArgumentException("File size greater than: ${Int.MAX_VALUE} bytes")
    } else {
        return length().toInt()
    }
}

internal fun getPercent(current: Int, total: Int): Int {
    return ((current.toDouble() / total) * 100).toInt()
}

internal fun UploadResultResponse.isForWorkSummary() =
    hasWorkSummary() && !hasChunkRequest()

internal fun UploadResultResponse.isForChunkRequest() =
    !hasWorkSummary() && hasChunkRequest()

internal fun SendFileWrapper.isForChunkResponse() =
    hasChunkResponse() && !hasManifest()

internal fun SendFileWrapper.isForManifest() =
    !hasChunkResponse() && hasManifest()

internal fun File.listFilesOnly(): Array<File> {
    return listFiles { file: File -> !file.isDirectory  } ?: emptyArray()
}

internal fun Closeable.closeSilently(logger: FtLogger) {
    try {
        close()
    } catch (e: Exception) {
        logger.e(e) { "Failed to close" }
    }
}

internal fun Manifest.createSendFileWrapper(): SendFileWrapper {
    return SendFileWrapper.newBuilder()
        .setManifest(this)
        .build()
}

internal fun ChunkResponse.createSendFileWrapper(): SendFileWrapper {
    return SendFileWrapper.newBuilder()
        .setChunkResponse(this)
        .build()
}

fun FileMeta.isStale(savedFileLastModified: Long): Boolean {
    return abs(lastModified - savedFileLastModified) > MIN_FRESHNESS_MILLIS
}