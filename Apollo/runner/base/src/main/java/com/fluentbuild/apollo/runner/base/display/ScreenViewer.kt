package com.fluentbuild.apollo.runner.base.display

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Handler
import android.os.HandlerThread
import android.view.WindowManager
import java.io.File
import java.lang.IllegalStateException

private const val REQUEST_CODE_SCREEN_VIEWER_PERMISSION = 9091

class ScreenViewer(
    private val windowManager: WindowManager,
    private val mediaProjectionManager: MediaProjectionManager,
    var callback: Callback? = null
) {

    private var mediaProjection: MediaProjection? = null
    private var screenRecorder: ScreenRecorder? = null
    private var screenshot: Screenshot? = null
    private var backgroundThread: HandlerThread? = null
    private var backgroundHandler: Handler? = null

    private val mediaProjectionCallback = object: MediaProjection.Callback() {
        override fun onStop() {
            onPermissionLost()
        }
    }

    @Throws(IllegalStateException::class)
    fun capture(): Bitmap? {
        requirePermission()
        return screenshot!!.capture(windowManager)
    }

    @Throws(IllegalStateException::class)
    fun record(destFile: File) {
        requirePermission()
        screenRecorder!!.start(destFile, windowManager)
    }

    @Throws(IllegalStateException::class)
    fun isRecording(): Boolean {
        requirePermission()
        return screenRecorder!!.isRecording()
    }

    @Throws(IllegalStateException::class)
    fun stopRecord() {
        requirePermission()
        screenRecorder!!.stop()
    }

    fun hasPermission() = mediaProjection != null

    @Throws(IllegalStateException::class)
    fun requestPermission(activity: Activity) {
        requireDoNotHavePermission()
        activity.startActivityForResult(
            mediaProjectionManager.createScreenCaptureIntent(),
            REQUEST_CODE_SCREEN_VIEWER_PERMISSION
        )
    }

    @Throws(IllegalStateException::class)
    fun onRequestPermissionResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if(requestCode != REQUEST_CODE_SCREEN_VIEWER_PERMISSION) return false
        requireDoNotHavePermission()

        val mediaProjection = data?.let { mediaProjectionManager.getMediaProjection(resultCode, it) }

        if(mediaProjection == null) {
            onPermissionDenied()
        } else {
            onPermissionObtained(mediaProjection)
            mediaProjection.registerCallback(mediaProjectionCallback, null)
        }

        return true
    }

    private fun onPermissionObtained(mediaProjection: MediaProjection) {
        val handlerThread = HandlerThread("ScreenViewThread")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)

        this.backgroundThread = handlerThread
        this.backgroundHandler = handler
        this.screenRecorder =
            ScreenRecorder(mediaProjection)
        this.screenshot = Screenshot(
            mediaProjection,
            handler
        )

        callback?.onPermissionObtained()
        this.mediaProjection = mediaProjection
    }

    private fun onPermissionDenied() {
        callback?.onPermissionDenied()
    }

    private fun onPermissionLost() {
        clearPermission()
        callback?.onPermissionLost()
    }

    fun clearPermission() {
        screenshot = null
        if(screenRecorder?.isRecording() == true) {
            screenRecorder?.stop()
        }

        backgroundThread?.quit()
        backgroundThread = null
        backgroundHandler = null

        mediaProjection?.unregisterCallback(mediaProjectionCallback)
        mediaProjection?.stop()
        mediaProjection = null
    }

    @Throws(IllegalStateException::class)
    private fun requirePermission() {
        require(mediaProjection != null) { "Media projection permission not granted"}
    }

    @Throws(IllegalStateException::class)
    private fun requireDoNotHavePermission() {
        check(mediaProjection == null) { "Media projection permission already granted"}
    }

    interface Callback {

        fun onPermissionLost()

        fun onPermissionObtained()

        fun onPermissionDenied()
    }
}
