package com.fluentbuild.apollo.runner.client.androidx

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import androidx.test.internal.runner.listener.InstrumentationResultPrinter
import androidx.test.runner.AndroidJUnitRunner
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.client.TestConfigs
import com.fluentbuild.apollo.runner.client.instrumentation.InstrumentationInitializer
import com.fluentbuild.apollo.runner.client.CancelSignalObserver
import com.fluentbuild.apollo.runner.client.instrumentation.UiAutomatorRegistry
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor
import java.lang.reflect.Field

private const val LOG_TAG = "RunnerHelper"

class RunnerHelper(
    private val runner: AndroidJUnitRunner,
    private val logWrapper: LogWrapper
) {

    private val activityMonitor = ActivityMonitor(logWrapper)
    private val appMonitor = AppMonitor(logWrapper)
    private val initializer = InstrumentationInitializer(
        runner,
        appMonitor,
        activityMonitor,
        logWrapper
    )

    private val cancelSignalObserver = CancelSignalObserver(
        runner,
        logWrapper
    )

    fun onCreate(arguments: Bundle) {
        logWrapper.i(LOG_TAG, "Runner onCreate")
        cancelSignalObserver.start()
        init(TestConfigs(arguments))
        UiAutomatorRegistry.init(runner, logWrapper)
    }

    fun onStart() {
        logWrapper.i(LOG_TAG, "Runner onStart")
        initializer.onStart()
    }

    fun onDestroy() {
        logWrapper.i(LOG_TAG, "Runner onDestroy")
        initializer.deInit()
        cancelSignalObserver.stop()
    }

    fun onCallApplicationOnCreate(app: Application, action: () -> Unit) {
        appMonitor.onCallApplicationOnCreate(app, action)
    }

    fun onCallActivityOnDestroy(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnDestroy(activity, action)
    }

    fun onCallActivityOnRestart(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnRestart(activity, action)
    }

    fun onCallActivityOnCreate(activity: Activity, bundle: Bundle?, action: () -> Unit) {
        activityMonitor.onCallActivityOnCreate(activity, bundle, action)
    }

    fun onCallActivityOnCreate(
        activity: Activity,
        bundle: Bundle?,
        persistentState: PersistableBundle,
        action: () -> Unit
    ) {
        activityMonitor.onCallActivityOnCreate(activity, bundle, persistentState, action)
    }

    fun onCallActivityOnStart(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnStart(activity, action)
    }

    fun onCallActivityOnStop(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnStop(activity, action)
    }

    fun onCallActivityOnResume(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnResume(activity, action)
    }

    fun onCallActivityOnPause(activity: Activity, action: () -> Unit) {
        activityMonitor.onCallActivityOnPause(activity, action)
    }
    
    private fun init(testConfigs: TestConfigs) {
        val printerField = getPrinterField()
        val printer = printerField.get(runner) as InstrumentationResultPrinter
        initializer.init(testConfigs, printer)
        printerField.set(runner, initializer.getTestObserver())
    }

    private fun getPrinterField(): Field {
        return AndroidJUnitRunner::class.java.getDeclaredField("instrumentationResultPrinter")
            .apply { isAccessible = true }
    }
}