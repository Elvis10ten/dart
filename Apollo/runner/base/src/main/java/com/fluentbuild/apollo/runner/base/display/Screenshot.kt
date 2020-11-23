package com.fluentbuild.apollo.runner.base.display

import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.media.Image
import android.media.ImageReader
import android.media.projection.MediaProjection
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.foundation.closeCatching
import java.lang.Exception
import java.nio.ByteBuffer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

private const val DISPLAY_NAME_SCREENSHOT = "ScreenyScreenshotDisplay"
// Max images is set to 2 to allow [ImageReader.acquireLatestImage] to do its thing
private const val MAX_IMAGES = 2
private const val SCREENSHOT_TIMEOUT_MILLIS = 10_000L
private const val LOG_TAG = "Screenshot"

internal class Screenshot(
    private val mediaProjection: MediaProjection,
    private val backgroundHandler: Handler
) {

    fun capture(windowManager: WindowManager): Bitmap? {
        Log.i(LOG_TAG, "Capturing Screenshot!")
        val countDownLatch = CountDownLatch(1)
        val displayProps = windowManager.getDefaultDisplayProps()
        val imageReader = ImageReader.newInstance(displayProps.width, displayProps.height, PixelFormat.RGBA_8888,
            MAX_IMAGES
        )
        var bitmap: Bitmap? = null

        val virtualDisplay = mediaProjection.createVirtualDisplay(
            DISPLAY_NAME_SCREENSHOT,
            displayProps,
            imageReader.surface,
            backgroundHandler
        ) {
            com.fluentbuild.apollo.foundation.async.requireNotMainThread()
            countDownLatch.countDown()
        }

        imageReader.setOnImageAvailableListener({
            com.fluentbuild.apollo.foundation.async.requireNotMainThread()
            imageReader.setOnImageAvailableListener(null, null)
            val image = imageReader.acquireLatestImage()

            image.close()
            try {
                bitmap = image.getBitmap(displayProps)
                Log.i(LOG_TAG, "Screenshot captured!!")
            } catch (e: Exception) {
                Log.e(LOG_TAG, "Failed to get bitmap from image", e)
            } finally {
                image.closeCatching { Log.e(LOG_TAG, "Error closing Image", it) }
                imageReader.closeCatching { Log.e(LOG_TAG, "Error closing ImageReader", it) }
                virtualDisplay.surface = null
                countDownLatch.countDown()
            }
        }, backgroundHandler)

        try {
            countDownLatch.await(SCREENSHOT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
        } finally {
            virtualDisplay.release()
        }

        return bitmap
    }
}

@WorkerThread
private fun Image.getBitmap(displayProps: DisplayProperties): Bitmap {
    val buffer: ByteBuffer = planes.first().buffer
    val pixelStride = planes.first().pixelStride
    val rowStride = planes.first().rowStride
    val rowPadding = rowStride - pixelStride * displayProps.width

    val bitmap = Bitmap.createBitmap(
        displayProps.width + (rowPadding.toFloat() / pixelStride.toFloat()).toInt(),
        displayProps.height,
        Bitmap.Config.ARGB_8888
    )
    bitmap.copyPixelsFromBuffer(buffer)
    return bitmap
}
