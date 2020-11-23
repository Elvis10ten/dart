package com.fluentbuild.apollo.work.ft.com.fluentbuild.apollo.work.ft

import com.fluentbuild.apollo.work.FileTransferProto.*
import com.fluentbuild.apollo.work.ft.*
import com.fluentbuild.apollo.work.ft.CHUNK_MAX_SIZE
import com.fluentbuild.apollo.work.ft.createRange
import com.fluentbuild.apollo.work.ft.getPercent
import java.nio.ByteBuffer

class FileSender(
    private val workKey: String,
    private val transport: Transport,
    private val storage: Storage,
    private val files: List<FileMeta>,
    private val logger: FtLogger
) {

    private val lock = Object()
    @Volatile
    private var isCancelled = false

    fun init() {
        logger.i { "Init file sender" }
        synchronized(lock) {
            if(isCancelled) return
            transport.sendManifest(getManifest())
        }
    }

    fun cancel() {
        logger.i { "Cancelling file sender" }
        isCancelled = true
    }

    fun handleChunkRequest(request: ChunkRequest) {
        logger.i { "Handling chunk request: $request" }
        synchronized(lock) {
            sendChunks(request.range, getMetaIndex(request.fileMeta))
        }
    }

    private fun sendChunks(fileRange: Range, fileMetaIndex: Int) {
        val buffer = ByteBuffer.allocate(CHUNK_MAX_SIZE)
        val fileMeta = files[fileMetaIndex]
        val channel = storage.openInputChannel(getMetaWrapper(fileMeta))

        try {
            channel.position(fileRange.startOffset.toLong())
            var startPosition: Long
            var totalBytesRead = 0

            while (totalBytesRead < fileRange.size) {
                val fileProgress =
                    getPercent(totalBytesRead, fileRange.size)
                if(isCancelled) return
                transport.reportProgress(fileMetaIndex, fileProgress, files.size)

                buffer.clear()
                if(isCancelled) return
                transport.awaitReady()

                startPosition = channel.position()
                val chunkRange = createRange(
                    startPosition.toInt(),
                    channel.read(buffer)
                )
                totalBytesRead += chunkRange.size
                if(isCancelled) return
                transport.sendChunk(buffer.createChunk(fileMeta, chunkRange))
            }
        } finally {
            channel.closeSilently(logger)
        }
    }

    private fun getManifest(): Manifest {
        return Manifest.newBuilder()
            .setWorkKey(workKey)
            .addAllFileMeta(files)
            .build()
    }

    private fun getMetaIndex(meta: FileMeta): Int {
        return files.indexOfFirst { it == meta }
    }

    private fun getMetaWrapper(fileMeta: FileMeta): Storage.MetaWrapper {
        return Storage.MetaWrapper(workKey, fileMeta)
    }

    interface Transport {

        fun sendManifest(manifest: Manifest)

        fun sendChunk(chunkResponse: ChunkResponse)

        fun reportProgress(curFileIndex: Int, progressPercent: Int, filesCount: Int)

        fun awaitReady()
    }
}