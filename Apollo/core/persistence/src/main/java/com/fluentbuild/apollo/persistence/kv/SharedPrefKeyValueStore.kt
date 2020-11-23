package com.fluentbuild.apollo.persistence.kv

import android.content.Context

class SharedPrefKeyValueStore(context: Context, key: String) : KeyValueStore {

    private val sp = context.getSharedPreferences(key, Context.MODE_PRIVATE)

    override fun contains(key: String) = sp.contains(key)

    override fun setString(key: String, value: String?) = sp.edit().putString(key, value).apply()

    override fun getString(key: String, defValue: String?): String? = sp.getString(key, defValue)

    override fun setBoolean(key: String, value: Boolean) = sp.edit().putBoolean(key, value).apply()

    override fun getBoolean(key: String, defValue: Boolean) = sp.getBoolean(key, defValue)

    override fun setInt(key: String, value: Int) = sp.edit().putInt(key, value).apply()

    override fun getInt(key: String, defValue: Int) = sp.getInt(key, defValue)

    override fun setLong(key: String, value: Long) = sp.edit().putLong(key, value).apply()

    override fun getLong(key: String, defValue: Long) = sp.getLong(key, defValue)

    override fun setFloat(key: String, value: Float) = sp.edit().putFloat(key, value).apply()

    override fun getFloat(key: String, defValue: Float) = sp.getFloat(key, defValue)

    // logic taken from https://stackoverflow.com/a/18098090/1308530
    override fun setDouble(key: String, value: Double) =
        sp.edit().putLong(key, java.lang.Double.doubleToRawLongBits(value)).apply()

    override fun getDouble(key: String, defValue: Double): Double =
        java.lang.Double.longBitsToDouble(sp.getLong(key, java.lang.Double.doubleToLongBits(defValue)))

    override fun remove(key: String) = sp.edit().remove(key).apply()

    override fun drop() = sp.edit().clear().apply()
}
