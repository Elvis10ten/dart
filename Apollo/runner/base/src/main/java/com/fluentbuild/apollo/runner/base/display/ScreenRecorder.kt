package com.fluentbuild.apollo.runner.base.display

import android.hardware.display.VirtualDisplay
import android.media.MediaRecorder
import android.media.projection.MediaProjection
import android.util.Log
import android.view.WindowManager
import java.io.File
import java.io.IOException

private const val DISPLAY_NAME_SCREEN_RECORDER = "ScreenyRecorderDisplay"
private const val VIDEO_ENCODING_BIT_RATE = 1 * 1024 * 1024
private const val VIDEO_FRAME_RATE = 24
private const val LOG_TAG = "ScreenRecorder"

internal class ScreenRecorder(
    private val mediaProjection: MediaProjection
) {

    private var mediaRecorder: MediaRecorder? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var isRecording = false

    @Throws(IOException::class, IllegalStateException::class)
    fun start(destFile: File, windowManager: WindowManager) {
        Log.i(LOG_TAG, "Starting screen recording!")
        val displayProps = windowManager.getDefaultDisplayProps()
        val mediaRecorder = MediaRecorder()

        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.SURFACE)
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder.setOutputFile(destFile.absolutePath)
        mediaRecorder.setVideoSize(displayProps.width, displayProps.height)
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264)
        mediaRecorder.setVideoEncodingBitRate(VIDEO_ENCODING_BIT_RATE)
        mediaRecorder.setVideoFrameRate(VIDEO_FRAME_RATE)

        this.mediaRecorder = mediaRecorder
        isRecording = true
        mediaRecorder.prepare()

        virtualDisplay = mediaProjection.createVirtualDisplay(
            DISPLAY_NAME_SCREEN_RECORDER,
            displayProps,
            mediaRecorder.surface,
            null
        ) {
            if(isRecording) {
                stop()
                throw IllegalStateException("Display was stopped while still recording screen")
            }
        }

        mediaRecorder.start()
        Log.i(LOG_TAG,"Screen recording started!!")
    }

    fun isRecording() = isRecording

    fun stop() {
        check(isRecording) { "Error stopping recording. Recording wasn't started." }
        Log.i(LOG_TAG,"Stopping screen recording!")
        isRecording = false
        release()
    }

    private fun release() {
        virtualDisplay?.release()
        virtualDisplay = null

        try {
            mediaRecorder?.stop()
        } catch (e: IllegalStateException) {
            Log.e(LOG_TAG, "Error stopping screen recording", e)
        }

        mediaRecorder?.release()
        mediaRecorder = null
    }
}
