package com.fluentbuild.workserver.db

class DbModule(
    private val connection: DbConnection
) {

    fun getSchema(): Schema {
        return Schema(connection)
    }

}