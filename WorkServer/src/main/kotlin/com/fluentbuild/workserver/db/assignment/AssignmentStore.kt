package com.fluentbuild.workserver.db.assignment

import com.fluentbuild.workserver.db.DbConnection
import java.sql.ResultSet

private const val SELECT_ASSIGNMENT_SQL = "SELECT * FROM work_assignment WHERE auth_model_id = %s AND work_id = %s"

class AssignmentStore(
    private val connection: DbConnection
) {

    fun assign(assignRequest: AssignRequest) {

    }

    fun deAssign(deAssignRequest: DeAssignRequest) {

    }

    fun retainAssignee(retainAssigneeRequest: RetainAssigneeRequest) {

    }

    fun isAssigned(assignmentRequest: AssignmentRequest): Boolean {
        return false
    }

    private fun getAssignment(assignmentRequest: AssignmentRequest): ResultSet {
        val query = SELECT_ASSIGNMENT_SQL.format(
            assignmentRequest.authModelId,
            assignmentRequest.workKey
        )
        return connection.createStatement().executeQuery(query)
    }
}