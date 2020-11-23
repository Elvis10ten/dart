package com.fluentbuild.workserver.db.work

import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.workserver.db.DbConnection

class WorkStore(
    private val connection: DbConnection
) {

    fun find(request: FindRequest): WorkProto.Work? {
        TODO()
    }
}