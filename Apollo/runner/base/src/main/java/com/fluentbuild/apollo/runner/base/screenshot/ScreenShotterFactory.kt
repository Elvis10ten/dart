package com.fluentbuild.apollo.runner.base.screenshot

import android.os.Handler
import android.view.View
import com.fluentbuild.apollo.foundation.android.AndroidVersion

class ScreenShotterFactory(
    private val screenshotHandler: Handler
) {

    fun createOrderedBestShotters(): Set<ScreenShotter> {
        val shotters = mutableSetOf<ScreenShotter>()

        if(AndroidVersion.isAtLeastOreo()) {
            shotters += WindowScreenShotter(screenshotHandler)
        }

        shotters += ReflectionScreenShotter(screenshotHandler)
        shotters += RootViewScreenShotter(screenshotHandler)
        return shotters
    }

    fun createBestShotter() = createOrderedBestShotters().first()
}