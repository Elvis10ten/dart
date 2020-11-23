package com.fluentbuild.apollo.runner.client.collators.screenshot

import android.graphics.Bitmap
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import com.fluentbuild.apollo.foundation.autoClose
import com.fluentbuild.apollo.foundation.closeCatching
import com.fluentbuild.apollo.runner.client.FileDescriptorProvider
import java.io.FileOutputStream

private const val LOG_TAG = "ScreenShotWriter"

class ScreenShotWriter(
    private val quality: Int,
    private val fileProvider: FileDescriptorProvider,
    private val logWrapper: LogWrapper
) {

    @WorkerThread
    fun saveScreenShot(name: String, bitmap: Bitmap) {
        requireNotMainThread()
        var parcelDescriptor: ParcelFileDescriptor? = null

        try {
            parcelDescriptor = fileProvider.getWritableDescriptor(name)
            FileOutputStream(parcelDescriptor.fileDescriptor).autoClose { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.WEBP, quality, outputStream)
                outputStream.flush()
            }
        }  catch (e: Exception) {
            logWrapper.e(LOG_TAG, e, "Failed to save screenshot")
        } finally {
            parcelDescriptor.closeCatching { Log.e(LOG_TAG, "Failed to close PFD") }
        }
    }
}