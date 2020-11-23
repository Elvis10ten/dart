package com.fluentbuild.apollo.persistence.kv

interface KeyValueStore {

    operator fun contains(key: String): Boolean

    fun setString(key: String, value: String?)
    fun getString(key: String, defValue: String?): String?

    fun setBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, defValue: Boolean): Boolean

    fun setInt(key: String, value: Int)
    fun getInt(key: String, defValue: Int): Int

    fun setFloat(key: String, value: Float)
    fun getFloat(key: String, defValue: Float): Float

    fun setDouble(key: String, value: Double)
    fun getDouble(key: String, defValue: Double): Double

    fun setLong(key: String, value: Long)
    fun getLong(key: String, defValue: Long): Long

    fun remove(key: String)
    fun drop()
}
