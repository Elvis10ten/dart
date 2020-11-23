package com.fluentbuild.apollo.runner.base.screenshot

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import com.fluentbuild.apollo.foundation.async.requireMainThread

class RootViewScreenShotter(
    private val screenshotHandler: Handler
): ScreenShotter {

    override fun take(activity: Activity, ignoredView: View?, callback: ScreenShotter.Callback) {
        requireMainThread()
        var bitmap: Bitmap? = null

        try {
            val rootView = activity.requireDecorView().rootView
            bitmap = rootView.createBitmapWithViewSize()

            val ignoredViewInitialVisibility = ignoredView?.visibility
            ignoredView?.visibility = View.INVISIBLE

            rootView.draw(Canvas(bitmap))
            ignoredViewInitialVisibility?.let { ignoredView.visibility = it }

            screenshotHandler.post { callback.onSuccess(bitmap) }
        } catch (e: Throwable) {
            bitmap?.recycle()
            screenshotHandler.post { callback.onError(e) }
        }
    }
}