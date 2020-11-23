package com.fluentbuild.workserver.db.assignment

class RetainAssigneeRequest(
    authModelId: Long,
    workId: String
): AssignmentRequest(authModelId, workId)
