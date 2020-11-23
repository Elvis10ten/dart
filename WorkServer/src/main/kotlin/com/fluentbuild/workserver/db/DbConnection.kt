package com.fluentbuild.workserver.db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import java.util.logging.Level
import java.util.logging.Logger

private val LOGGER = Logger.getLogger(DbConnection::class.java.name)

class DbConnection(
    private val dbUrl: String,
    private val dbUser: String,
    private val dbPassword: String
) {

    private val lock = Object()
    private var connection: Connection? = null

    private fun get(): Connection {
        return synchronized(lock) {
            val existingConnection = connection ?: return createNewConnection()
            if (existingConnection.isClosed) return createNewConnection()
            existingConnection
        }
    }

    fun createStatement(): Statement {
        return synchronized(lock) {
            get().createStatement()
        }
    }

    fun commit() {
        synchronized(lock) {
            get().commit()
        }
    }

    fun close() {
        synchronized(lock) {
            connection?.close()
        }
    }

    private fun createNewConnection(): Connection {
        return try {
            Class.forName("org.postgresql.Driver")
            val newConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
            connection = newConnection
            newConnection
        } catch (e: Exception) {
            LOGGER.log(Level.SEVERE, "Failed to connect to DB", e)
            throw e
        }
    }
}