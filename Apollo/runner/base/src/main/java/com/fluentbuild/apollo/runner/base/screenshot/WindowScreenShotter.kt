package com.fluentbuild.apollo.runner.base.screenshot

import android.app.Activity
import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.view.PixelCopy
import android.view.View
import android.view.Window
import androidx.annotation.RequiresApi
import com.fluentbuild.apollo.foundation.async.requireMainThread

class WindowScreenShotter(
    private val screenshotHandler: Handler
): ScreenShotter {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun take(activity: Activity, ignoredView: View?, callback: ScreenShotter.Callback) {
        requireMainThread()
        if(ignoredView != null) {
            screenshotHandler.post { callback.onError(UnsupportedOperationException()) }
            return
        }

        var bitmap: Bitmap? = null

        try {
            val decorView = activity.requireDecorView()
            bitmap = decorView.createBitmapWithViewSize()
            take(activity.window, bitmap, callback)
        } catch (e: Throwable) {
            val error = if(e is IllegalArgumentException) {
                ScreenShotter.NoWindowSurfaceException(e)
            } else {
                e
            }

            bitmap?.recycle()
            screenshotHandler.post { callback.onError(error) }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun take(window: Window, bitmap: Bitmap, callback: ScreenShotter.Callback) {
        PixelCopy.request(
            window,
            bitmap,
            { copyResult ->
                if(copyResult == PixelCopy.SUCCESS) {
                    callback.onSuccess(bitmap)
                } else {
                    bitmap.recycle()
                    callback.onError(getException(copyResult))
                }
            },
            screenshotHandler
        )
    }

    private fun getException(copyResult: Int): Throwable {
        return when(copyResult) {
            PixelCopy.ERROR_DESTINATION_INVALID -> DestinationInvalidException()
            PixelCopy.ERROR_TIMEOUT -> TimeoutException()
            PixelCopy.ERROR_SOURCE_INVALID -> SourceInvalidException()
            PixelCopy.ERROR_SOURCE_NO_DATA -> SourceNoDataException()
            else -> UnknownException()
        }
    }

    /** The pixel copy request failed with an unknown error.  */
    class UnknownException: RuntimeException()

    /**
     * A timeout occurred while trying to acquire a buffer from the source to
     * copy from.
     */
    class TimeoutException: RuntimeException()

    /**
     * The source has nothing to copy from. When the source is a [Surface]
     * this means that no buffers have been queued yet. Wait for the source
     * to produce a frame and try again.
     */
    class SourceNoDataException: RuntimeException()

    /**
     * It is not possible to copy from the source. This can happen if the source
     * is hardware-protected or destroyed.
     */
    class SourceInvalidException: RuntimeException()

    /**
     * The destination isn't a valid copy target. If the destination is a bitmap
     * this can occur if the bitmap is too large for the hardware to copy to.
     * It can also occur if the destination has been destroyed.
     */
    class DestinationInvalidException: RuntimeException()
}