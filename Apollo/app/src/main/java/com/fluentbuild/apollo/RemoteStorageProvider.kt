package com.fluentbuild.apollo

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import com.fluentbuild.apollo.foundation.openParcelFileDescriptor
import com.fluentbuild.apollo.runner.base.RemoteStorageConstants
import com.fluentbuild.apollo.runtime.RuntimeManager
import com.fluentbuild.apollo.setup.ComponentInjector
import timber.log.Timber
import java.io.File

private const val REMOTE_STORAGE_DIR = "stash"

class RemoteStorageProvider: ContentProvider() {

    lateinit var runtimeManager: RuntimeManager
    var hasInitialized = false

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return -1
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return -1
    }

    override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor? {
        // todo: handle isolated case. Where files can overwrite if using same dir
        initProvider()
        /*val clientPackage = callingPackage ?: return null
        if(!runtimeManager.isClientAllowed(clientPackage)) return null*/
        val child = uri.toString().substringAfter(RemoteStorageConstants.BASE_URI)
        if(child.isBlank()) return null

        return try {
            File(getDir(context!!), child).run {
                Timber.i("Opening file: %s with mode: %s", absolutePath, mode)
                parentFile?.mkdirs()
                openParcelFileDescriptor(mode)
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun initProvider() {
        if(!hasInitialized) {
            ComponentInjector.inject(this)
            hasInitialized = true
        }
    }

    companion object {

        fun getDir(context: Context): File {
            return File(context.filesDir, REMOTE_STORAGE_DIR).apply { mkdirs() }
        }
    }
}