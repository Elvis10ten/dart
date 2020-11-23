package com.fluentbuild.apollo.work.ft

import com.fluentbuild.apollo.work.FileTransferProto.*

class FileReceiver(
    private val storage: Storage,
    private val transport: Transport,
    private val logger: FtLogger
) {

    private val lock = Object()
    private lateinit var manifest: Manifest

    private var currentFileIndex = 0
    private lateinit var currentFileMeta: FileMeta
    @Volatile
    private var isCancelled = false

    fun cancel() {
        isCancelled = true
    }

    fun handleManifest(manifest: Manifest) {
        logger.i { "Handling manifest: $manifest" }
        synchronized(lock) {
            this.manifest = manifest
            currentFileIndex = 0
            requestFiles()
        }
    }

    private fun requestFiles() {
        val pendingFileRange= moveToFirstPendingFile()
        if(pendingFileRange == null) {
            logger.i { "File transfer complete!" }
            if(isCancelled) return
            transport.completeTransfer()
        } else {
            requestFile(pendingFileRange)
        }
    }

    @Throws(IllegalArgumentException::class)
    fun handleChunkResponse(chunk: ChunkResponse) {
        logger.i { "Handling chunk range: ${chunk.range} for: ${chunk.fileMeta}" }
        synchronized(lock) {
            requireChunkValid(chunk)
            storage.createOrAppend(getMetaWrapper(chunk.fileMeta), chunk.data.toByteArray())

            val savedFileSize = storage.getSize(getMetaWrapper(chunk.fileMeta))
            val fileProgress = getPercent(savedFileSize, currentFileMeta.size)
            if(isCancelled) return
            transport.reportProgress(currentFileIndex, fileProgress, manifest.fileMetaCount)

            if(isFileComplete(chunk)) {
                requestFiles()
            }
        }
    }

    private fun moveToFirstPendingFile(): Range? {
        currentFileMeta = manifest.getFileMeta(currentFileIndex)
        logger.i { "Current file meta: $currentFileMeta" }
        val currentFileMetaWrapper = getMetaWrapper(currentFileMeta)
        val savedFileSize = storage.getSize(currentFileMetaWrapper)
        val savedFileLastModified = storage.getLastModifiedTime(currentFileMetaWrapper)
        logger.i { "Saved file size: $savedFileSize, lastModified: $savedFileLastModified" }

        if(currentFileMeta.size == savedFileSize && currentFileMeta.isStale(savedFileLastModified)) {
            storage.delete(currentFileMetaWrapper)
        } else if(currentFileMeta.size == savedFileSize) {
            return if(currentFileIndex == manifest.fileMetaList.lastIndex) {
                null
            } else {
                currentFileIndex++
                moveToFirstPendingFile()
            }
        } else if(savedFileSize > currentFileMeta.size) {
            // todo: check screenshot
            throw IllegalArgumentException("Size mismatch, saved size ($savedFileSize) & meta: (${currentFileMeta.size}")
        }

        return createRange(savedFileSize, currentFileMeta.size - savedFileSize)
    }

    private fun requestFile(range: Range) {
        logger.i { "Requesting range: $range, file: $currentFileMeta" }
        val chunkRequest = ChunkRequest.newBuilder()
            .setFileMeta(currentFileMeta)
            .setRange(range)
            .build()
        if(isCancelled) return
        transport.requestFile(chunkRequest)
    }

    private fun requireChunkValid(chunk: ChunkResponse) {
        if(currentFileMeta != chunk.fileMeta) {
            throw IllegalArgumentException("Current meta doesn't match chunk's meta")
        }

        val offset = chunk.range.startOffset
        val savedFileSize = storage.getSize(getMetaWrapper(chunk.fileMeta))
        if(offset != savedFileSize) {
            throw IllegalArgumentException("Offset doesn't match saved file end")
        }
    }

    private fun isFileComplete(chunk: ChunkResponse): Boolean {
        return storage.getSize(getMetaWrapper(chunk.fileMeta)) == chunk.fileMeta.size
    }

    private fun getMetaWrapper(meta: FileMeta): Storage.MetaWrapper {
        return Storage.MetaWrapper(manifest.workKey, meta)
    }

    interface Transport {

        fun requestFile(chunkRequest: ChunkRequest)

        fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int)

        fun completeTransfer()
    }
}