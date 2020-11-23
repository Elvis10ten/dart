package com.fluentbuild.apollo.runner.client

import android.content.Context
import android.net.Uri
import android.os.ParcelFileDescriptor
import com.fluentbuild.apollo.runner.base.RemoteStorageConstants.BASE_URI
import com.fluentbuild.apollo.runner.base.RemoteStorageConstants.MODE_APPEND
import com.fluentbuild.apollo.runner.base.RemoteStorageConstants.MODE_READ
import com.fluentbuild.apollo.runner.base.RemoteStorageConstants.MODE_WRITE

class FileDescriptorProvider(
    private val context: Context
) {

    @Throws(Exception::class)
    internal fun getReadableDescriptor(fileName: String): ParcelFileDescriptor {
        return getDescriptor(fileName, MODE_READ)
    }

    @Throws(Exception::class)
    internal fun getWritableDescriptor(fileName: String): ParcelFileDescriptor {
        return getDescriptor(fileName, MODE_WRITE)
    }

    @Throws(Exception::class)
    internal fun getAppendableDescriptor(fileName: String): ParcelFileDescriptor {
        return getDescriptor(fileName, MODE_APPEND)
    }

    @Throws(Exception::class)
    private fun getDescriptor(fileName: String, mode: String): ParcelFileDescriptor {
        val fileUri = getFileUri(fileName)
        return context.contentResolver.openFileDescriptor(fileUri, mode)!!.apply {
            checkError()

            if(!fileDescriptor.valid()) {
                throw IllegalArgumentException("File descriptor is not valid")
            }
        }
    }

    private fun getFileUri(filePath: String): Uri {
        return Uri.parse("${BASE_URI}${filePath}")
    }
}