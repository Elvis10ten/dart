package com.fluentbuild.workserver.db.work

import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.workserver.db.DbConnection

internal class FindWorkQuery(
    private val connection: DbConnection,
    private val request: FindRequest
) {

    fun getWork(): WorkProto.Work {
        val query = "SELECT * FROM work"
        val statement = connection.createStatement()

        val results = statement.executeQuery(query)
        results.first()


        statement.close()
        connection.close()
        TODO()
    }
}