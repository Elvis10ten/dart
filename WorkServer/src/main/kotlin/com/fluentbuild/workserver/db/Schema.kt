package com.fluentbuild.workserver.db

import java.util.logging.Level
import java.util.logging.Logger

private const val CREATE_SCRIPT_NAME = "schema_create.sql"
private const val DROP_SCRIPT_NAME = "schema_drop.sql"
private val LOGGER = Logger.getLogger(Schema::class.java.name)

class Schema(
    private val connection: DbConnection
) {

    fun create() {
        val sql = getSqlScript(CREATE_SCRIPT_NAME)
        connection.createStatement().apply {
            execute(sql)
            close()
        }

        LOGGER.info("Schema created!")
        connection.close()
    }

    fun drop() {
        val sql = getSqlScript(DROP_SCRIPT_NAME)
        connection.createStatement().apply {
            execute(sql)
            close()
        }

        LOGGER.info("Schema dropped!")
        connection.close()
    }

    private fun getSqlScript(name: String): String {
        return javaClass.classLoader.getResourceAsStream(name)!!.bufferedReader().readText()
    }
}