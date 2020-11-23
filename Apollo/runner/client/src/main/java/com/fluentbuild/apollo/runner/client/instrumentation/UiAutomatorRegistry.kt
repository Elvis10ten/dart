package com.fluentbuild.apollo.runner.client.instrumentation

import android.app.Instrumentation
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.automation.UiAutomation
import com.fluentbuild.apollo.automation.UiAutomationConnector
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import java.util.concurrent.CountDownLatch

object UiAutomatorRegistry {

    private lateinit var instrumentation: Instrumentation
    private lateinit var uiAutomationConnector: UiAutomationConnector
    private lateinit var logWrapper: LogWrapper

    fun init(instrumentation: Instrumentation, logWrapper: LogWrapper) {
        this.instrumentation = instrumentation
        this.logWrapper = logWrapper
        uiAutomationConnector = UiAutomationConnector(
            instrumentation.targetContext,
            logWrapper
        )
    }

    internal fun getLogWrapper() = logWrapper

    @WorkerThread
    fun getUiAutomation(flags: Int? = null): UiAutomation {
        requireNotMainThread()

        val latch = CountDownLatch(1)
        var connectedUiAutomation: UiAutomation? = null

        uiAutomationConnector.connect(flags, object: UiAutomationConnector.Callback {

            override fun onConnected(_uiAutomation: UiAutomation) {
                connectedUiAutomation = _uiAutomation
                latch.countDown()
            }

            override fun onConnectTimeout() {
                latch.countDown()
            }

            override fun onServiceError() {
                latch.countDown()
            }
        })

        latch.await()
        // todo: throw meaningful exception?
        return connectedUiAutomation!!
    }
}