package com.fluentbuild.workserver.work.artifacts

import com.fluentbuild.apollo.work.tests.ArtifactProto

data class ResultArtifacts(
    val screenshots: List<ArtifactProto.Artifact>,
    val screenVideo: ArtifactProto.Artifact,
    val others: List<ArtifactProto.Artifact>
)