package com.fluentbuild.workserver.work.reports

import com.fluentbuild.apollo.work.tests.AtomicResultProto.AtomicResult
import com.fluentbuild.workserver.utils.autoClose
import com.fluentbuild.workserver.work.artifacts.ArtifactStore
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import com.fluentbuild.workserver.work.store.TestLogs

private const val MAX_OUTPUT_LOG_SIZE_BYTES = 1 * 1024 * 1024 // 1 MB
private const val INVALID_OFFSET = -1

class TestLogReader(
    private val artifactStore: ArtifactStore
) {

    fun read(
        query: DeviceWorkQuery,
        startOffset: Int = 0,
        atomicResult: AtomicResult
    ): TestLogs {
        require(startOffset >= 0) { "Start offset cannot be negative" }
        val lines = mutableListOf<String>()
        var nextOffset = INVALID_OFFSET

        val range = IntRange(startOffset, startOffset + MAX_OUTPUT_LOG_SIZE_BYTES)
        val inputStream = artifactStore.openArtifact(
            query,
            atomicResult.logFileName,
            atomicResult,
            range
        )

        inputStream.bufferedReader().autoClose { reader ->
            lines += reader.readLines()
        }

        if(lines.isNotEmpty()) {
            nextOffset = range.last + 1
        }

        return TestLogs(lines, nextOffset)
    }
}