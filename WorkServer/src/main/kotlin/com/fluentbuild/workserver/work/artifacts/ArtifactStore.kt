package com.fluentbuild.workserver.work.artifacts

import com.fluentbuild.apollo.work.tests.AtomicResultProto.AtomicResult
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import java.io.InputStream

interface ArtifactStore {

    fun add(
        query: DeviceWorkQuery,
        result: AtomicResult,
        artifactEntries: ArtifactEntries
    )

    fun openArtifact(
        query: DeviceWorkQuery,
        artifactName: String,
        result: AtomicResult,
        range: IntRange? = null
    ): InputStream

    fun listResultArtifacts(
        query: DeviceWorkQuery,
        result: AtomicResult
    ): ResultArtifacts
}