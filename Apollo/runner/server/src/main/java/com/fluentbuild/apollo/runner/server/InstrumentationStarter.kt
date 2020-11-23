package com.fluentbuild.apollo.runner.server

import android.content.Context
import com.fluentbuild.apollo.foundation.android.requireInstrumentationStart
import com.fluentbuild.apollo.foundation.toBundle
import com.fluentbuild.apollo.runner.*
import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.tests.AtomicTestProto.*
import timber.log.Timber
import java.io.File
import java.lang.Exception
import java.util.*

class InstrumentationStarter(
    private val appContext: Context,
    private val instrumentationMeta: InstrumentationMeta,
    private val work: WorkProto.Work,
    testsAlreadyRan: Map<InstrumentationMeta, Set<AtomicTest>>,
    private val clientObserver: ClientObserver,
    private val clientObserverCallback: ClientObserver.Callback
) {

    private val pendingTests = Stack<AtomicTest>().apply {
        for(test in work.testsList) {
            if(testsAlreadyRan[instrumentationMeta]?.contains(test) != true) {
                push(test)
            } else {
                Timber.i("Ignoring test already ran: %s", test)
            }
        }
    }

    @Throws(RuntimeException::class)
    fun start() {
        val args = work.environmentVariablesMap.toBundle()
        args.putInt(ARG_TESTS_COUNT, pendingTests.size)
        args.putBoolean(ARG_OBSCURE_WINDOW_ENABLED, work.obscureScreen)
        args.putBoolean(ARG_AUTO_SCREEN_SHOT_ENABLED, work.takeWindowAutoShots)
        args.putBoolean(ARG_RETRIEVE_APP_FILES, work.retrieveAppFiles)
        args.putBoolean(ARG_RETRIEVE_TEST_FILES, work.retrieveTestFiles)
        args.putBoolean(ARG_CLEAR_DATA, work.shouldClearPackageData)
        args.putInt(ARG_PROFILER_SAMPLE_FREQUENCY, work.sampleFrequencyValue)

        args.putInt(ARG_AUTO_SCREEN_SHOT_FPS, work.autoScreenShotFps)
        args.putInt(ARG_AUTO_SCREEN_QUALITY, work.autoScreenShotQuality)

        val tests: String
        if(work.isIsolated) {
            tests = pendingTests.pop().getFullName()
        } else {
            tests = pendingTests.joinToString(JUNIT_TESTS_SEPARATOR) { test ->
                test.getFullName()
            }
            pendingTests.clear()
        }
        args.putString(ARG_JUNIT_TESTS_CLASS, tests)

        clientObserver.init(
            instrumentationMeta,
            work,
            clientObserverCallback
        )

        Timber.i("Starting test: %s", args)
        appContext.requireInstrumentationStart(
            instrumentationMeta.componentName,
            getSystemProfileFile()?.absolutePath,
            args
        )
    }

    private fun getSystemProfileFile(): File? {
        if(!work.useSystemProfiler) return null

        return try {
            val targetContext = appContext.createPackageContext(work.packageName, 0)
            File(targetContext.filesDir, "profile.trace")
        } catch (e: Exception) {
            Timber.e("Failed to get system profiler file")
            null
        }
    }

    fun finishTest(resultCode: Int) {
        clientObserver.finishClient(resultCode)
    }

    fun hasPendingTests() =
        pendingTests.isNotEmpty()
}
