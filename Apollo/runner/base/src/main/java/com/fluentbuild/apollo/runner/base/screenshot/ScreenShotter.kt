package com.fluentbuild.apollo.runner.base.screenshot

import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread

interface ScreenShotter {

    @MainThread
    fun take(activity: Activity, ignoredView: View? = null, callback: Callback)

    interface Callback {

        @WorkerThread
        fun onSuccess(bitmap: Bitmap)

        @WorkerThread
        fun onError(error: Throwable)
    }

    class DecorViewNullException: IllegalArgumentException()

    class IllegalBitmapSizeException: IllegalArgumentException()

    class NoWindowSurfaceException(cause: Throwable): IllegalArgumentException(cause)
}

internal fun View.createBitmapWithViewSize(): Bitmap {
    if(width <= 0 || height <= 0) throw ScreenShotter.IllegalBitmapSizeException()
    return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
}

internal fun Activity.requireDecorView(): View {
    return window.peekDecorView() ?: throw ScreenShotter.DecorViewNullException()
}