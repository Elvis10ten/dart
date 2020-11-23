package com.fluentbuild.apollo.runner.base.screenshot

import android.app.Activity
import android.graphics.*
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.os.Handler
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.fluentbuild.apollo.foundation.android.getStartCoordinates
import com.fluentbuild.apollo.foundation.async.requireMainThread
import java.lang.Exception
import java.nio.IntBuffer
import java.util.concurrent.CountDownLatch
import javax.microedition.khronos.egl.EGL10
import javax.microedition.khronos.egl.EGLContext
import javax.microedition.khronos.opengles.GL10

class ReflectionScreenShotter(
    private val screenshotHandler: Handler
): ScreenShotter {

    override fun take(activity: Activity, ignoredView: View?, callback: ScreenShotter.Callback) {
        requireMainThread()
        var bitmap: Bitmap? = null

        try {
            val rootView = activity.requireDecorView().rootView
            val roots = ReflectionHelper.getRootViews(activity)
            bitmap = rootView.createBitmapWithViewSize()
            drawRootsToBitmap(roots, bitmap, ignoredView)
            screenshotHandler.post { callback.onSuccess(bitmap) }
        } catch (e: Throwable) {
            bitmap?.recycle()
            screenshotHandler.post { callback.onError(e) }
        }
    }

    private fun drawRootsToBitmap(
        roots: List<RootViewInfo>,
        bitmap: Bitmap,
        ignoredView: View?
    ) {
        for (root in roots) {
            drawRootToBitmap(root, bitmap, ignoredView)
        }
    }

    @Suppress("SameParameterValue")
    private fun isFlagEnabled(params: WindowManager.LayoutParams, windowFlag: Int) =
        params.flags and windowFlag == windowFlag

    private fun drawRootToBitmap(
        root: RootViewInfo,
        bitmap: Bitmap,
        ignoredView: View?
    ) {
        // support dim screen
        if (isFlagEnabled(root.layoutParams, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)) {
            val dimCanvas = Canvas(bitmap)
            val alpha = (255 * root.layoutParams.dimAmount).toInt()
            dimCanvas.drawARGB(alpha, 0, 0, 0)
        }

        val canvas = Canvas(bitmap)
        canvas.translate(root.startCoordinates.x.toFloat(), root.startCoordinates.y.toFloat())

        val ignoredViewInitialVisibility = ignoredView?.visibility
        ignoredView?.visibility = View.INVISIBLE

        root.view.draw(canvas)
        if(root.view is ViewGroup) {
            attemptToDrawUnSupportedViews(root.view, canvas)
        }

        ignoredViewInitialVisibility?.let { ignoredView.visibility = it }
    }

    private fun attemptToDrawUnSupportedViews(viewGroup: ViewGroup, canvas: Canvas) {
        for (childIndex in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(childIndex)
            if(child is ViewGroup) {
                attemptToDrawUnSupportedViews(child, canvas)
            }

            try {
                if (child is TextureView) {
                    drawTextureView(child, canvas)
                }

                if (child is GLSurfaceView) {
                    drawGLSurfaceView(child, canvas)
                }
            } catch (ignored: Exception) {}
        }
    }

    private fun drawGLSurfaceView(surfaceView: GLSurfaceView, canvas: Canvas) {
        surfaceView.windowToken ?: return

        val starCoordinates = surfaceView.getStartCoordinates()
        val width = surfaceView.width
        val height = surfaceView.height

        val x = 0
        val y = 0
        val b = IntArray(width * (y + height))

        val ib = IntBuffer.wrap(b)
        ib.position(0)

        //To wait for the async call to finish before going forward
        val countDownLatch = CountDownLatch(1)

        surfaceView.queueEvent {
            val egl = EGLContext.getEGL() as EGL10
            egl.eglWaitGL()
            val gl = egl.eglGetCurrentContext().gl as GL10

            gl.glFinish()

            /*
            todo: Wait for draw?
            try {
                Thread.sleep(200)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }*/

            gl.glReadPixels(x, 0, width, y + height, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, ib)
            countDownLatch.countDown()
        }

        try {
            countDownLatch.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val bt = IntArray(width * height)
        var i = 0
        var k = 0
        while (i < height) {
            for (j in 0 until width) {
                val pix = b[i * width + j]
                val pb = pix shr 16 and 0xFF
                val pr = pix shl 16 and 0xFF0000
                val pix1 = pix and 0xFF00FF00.toInt() or pr or pb
                bt[(height - k - 1) * width + j] = pix1
            }
            i++
            k++
        }

        val surfaceBitmap = Bitmap.createBitmap(bt, width, height, Bitmap.Config.ARGB_8888)
        try {
            val paint = Paint()
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)

            canvas.drawBitmap(
                surfaceBitmap,
                starCoordinates.x.toFloat(),
                starCoordinates.y.toFloat(),
                paint
            )
        } finally {
            surfaceBitmap.recycle()
        }
    }

    private fun drawTextureView(textureView: TextureView, canvas: Canvas) {
        val startCoordinates = textureView.getStartCoordinates()
        val textureViewBitmap = textureView.bitmap ?: return

        try {
            val paint = Paint()
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
            canvas.drawBitmap(
                textureViewBitmap,
                startCoordinates.x.toFloat(),
                startCoordinates.y.toFloat(),
                paint
            )
        } finally {
            textureViewBitmap.recycle()
        }
    }
}