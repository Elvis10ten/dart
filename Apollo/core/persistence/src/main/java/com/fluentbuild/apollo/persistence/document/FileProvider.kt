package com.fluentbuild.apollo.persistence.document

import android.content.Context
import java.io.File
import java.io.FileOutputStream

private const val ORIGINAL_EXTENSION = ".doc"
private const val BACKUP_EXTENSION = ".bak"

open class FileProvider(private val context: Context) {

    open fun openFileOutput(name: String): FileOutputStream = context.openFileOutput(name, Context.MODE_PRIVATE)

    open fun getFilesDir(): File = context.filesDir

    open fun getOriginalFile(documentKey: String): File = context.getFileStreamPath(documentKey + ORIGINAL_EXTENSION)

    open fun getBackupFile(documentKey: String): File = context.getFileStreamPath(documentKey + BACKUP_EXTENSION)

    open fun isDocumentFile(fileName: String) = fileName.endsWith(ORIGINAL_EXTENSION) || fileName.endsWith(BACKUP_EXTENSION)
}
