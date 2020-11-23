package com.fluentbuild.workserver.db.assignment

class DeAssignRequest(
    authModelId: Long,
    workId: String
): AssignmentRequest(authModelId, workId)

