package com.fluentbuild.workserver.db.assignment

class AssignRequest(
    authModelId: Long,
    workId: String
): AssignmentRequest(authModelId, workId)
