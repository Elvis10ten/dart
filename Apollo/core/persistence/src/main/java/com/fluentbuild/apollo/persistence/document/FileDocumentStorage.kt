package com.fluentbuild.apollo.persistence.document

import com.google.gson.Gson
import timber.log.Timber
import java.io.FileFilter
import java.io.FileOutputStream
import java.io.IOException
import java.lang.reflect.Type

private const val DEFAULT_BUFFER_SIZE_BYTES: Int = 16 * 1024 // 16 KB

/**
 * Storage that persists the Document data to the device file system.
 *
 * This class is not thread safe.
 */
class FileDocumentStorage(
    private val fileProvider: FileProvider,
    private val parser: Gson
): DocumentStorage {

    override fun save(documentKey: String, content: Any, documentType: Type) {
        val originalFile = getOriginalFile(documentKey)
        val backupFile = getBackupFile(documentKey)

        // Rename the current file so it may be used as a backup during the next read
        if (originalFile.exists()) {
            //Rename original to backup
            if (!backupFile.exists()) {
                if (!originalFile.renameTo(backupFile)) {
                    throw IOException("Couldn't rename file $originalFile to backup file $backupFile")
                }
            } else {
                //Backup exist -> original file is broken and must be deleted
                originalFile.delete()
            }
        }

        /*
        Attempt to write the file, delete the backup and return as atomically as possible.
        If any exception occurs, delete the new file; next time we will restore from the backup.
         */
        try {
            fileProvider.openFileOutput(originalFile.name).use { fos ->
                fos.writer().buffered(DEFAULT_BUFFER_SIZE_BYTES).use {
                    parser.toJson(content, documentType, it)

                    it.flush()
                    fos.sync()
                }
            }

            // Writing was successful, delete the backup file if there is one.
            backupFile.delete()
        } catch (t: Throwable) {
            // Clean up an unsuccessfully written file
            if (originalFile.exists()) {
                if (!originalFile.delete()) {
                    Timber.e(t,"Couldn't clean up partially-written file $originalFile")
                }
            }

            throw t
        }
    }

    override fun <T> get(documentKey: String, documentType: Type): DocumentModel<T>? {
        val originalFile = getOriginalFile(documentKey)
        val backupFile = getBackupFile(documentKey)

        if (backupFile.exists()) {
            Timber.v("Restoring document backup")
            originalFile.delete()
            backupFile.renameTo(originalFile)
        }

        if (!originalFile.exists()) {
            return null
        }

        return originalFile.bufferedReader(bufferSize = DEFAULT_BUFFER_SIZE_BYTES).use {
            DocumentModel(parser.fromJson<T>(it, documentType), originalFile.length())
        }
    }

    override fun getKeys(keyPredicate: (documentKey: String) -> Boolean): Set<String> {
        val fileFilter = FileFilter { !it.isDirectory && fileProvider.isDocumentFile(it.name) && keyPredicate(it.nameWithoutExtension) }
        return (fileProvider.getFilesDir().listFiles(fileFilter) ?: emptyArray())
            .map { it.nameWithoutExtension }
            .toSet()
    }

    override fun contains(documentKey: String): Boolean {
        return getOriginalFile(documentKey).exists() || getBackupFile(documentKey).exists()
    }

    override fun delete(documentKey: String) {
        val originalFile = getOriginalFile(documentKey)
        val backupFile = getBackupFile(documentKey)

        backupFile.delete()

        if(originalFile.exists()) {
            if(!originalFile.delete()) throw IOException("Failed to delete $originalFile")
        }
    }

    private fun getOriginalFile(documentKey: String) = fileProvider.getOriginalFile(documentKey)

    private fun getBackupFile(documentKey: String) = fileProvider.getBackupFile(documentKey)
}

/**
 * Perform an fsync on the given FileOutputStream.  The stream at this point must be flushed but not yet closed.
 */
internal fun FileOutputStream.sync() {
    try {
        fd.sync()
    } catch (ignored: IOException) {}
}
