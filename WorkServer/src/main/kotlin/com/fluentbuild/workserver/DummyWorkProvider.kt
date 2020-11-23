package com.fluentbuild.workserver

import com.fluentbuild.apollo.measurement.SampleFrequencyProto
import com.fluentbuild.apollo.work.FileTransferProto
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.ft.toProto
import com.fluentbuild.apollo.work.tests.AtomicTestProto
import java.io.File
import java.util.*

object DummyWorkProvider {

    private val payloadFile = File(Injector.baseDir, "pl.b")
    private val payloadFile1 = File(Injector.baseDir, "pl.b")
    private val payloadFile2 = File(Injector.baseDir, "pl.b")

    private var count = 0

    fun getPayloadFileMeta(): FileTransferProto.FileMeta {
        return if(count % 2 == 0) {
            getPayloadFileMeta1()
        } else {
            getPayloadFileMeta2()
        }
    }

    fun getAssignedWork(): WorkProto.Work {
        //count++
        return if(count % 2 == 0) {
            getAssignedWork1()
        } else {
            getAssignedWork2()
        }
    }

    fun getPayloadFileMeta1(): FileTransferProto.FileMeta {
        payloadFile1.copyTo(payloadFile, true)
        return payloadFile.toProto()
    }

    fun getPayloadFileMeta2(): FileTransferProto.FileMeta {
        payloadFile2.copyTo(payloadFile, true)
        return payloadFile.toProto()
    }

    fun getAssignedWork2(): WorkProto.Work {
        val key = UUID.randomUUID().toString()
        return WorkProto.Work.newBuilder()
            .setPackageName("com.google.samples.apps.iosched")
            .setTestPackageName("com.google.samples.apps.iosched.test")
            .setNumRetriesPerDevice(0)
            .setAutoScreenShotFps(20)
            .setAutoScreenShotQuality(20)
            .setIsIsolated(false)
            .setPayload(
                WorkProto.RemoteFile.newBuilder()
                    .setLastModified(System.currentTimeMillis())
                    .setSizeBytes(payloadFile2.length())
                    .setUrl(payloadFile2.absolutePath)
                    .build()
            )
            .setTimeout(1_800_000) // 30 minutes
            .setRetrieveAppFiles(true)
            .setRetrieveTestFiles(true)
            .setTakeWindowAutoShots(true)
            .setShouldClearPackageData(true)
            .setObscureScreen(true)
            .setKey(key)
            .setType(WorkProto.TestType.INSTRUMENTATION)
            .setLocale(Locale.US.isO3Country)
            .setOrientation(WorkProto.ScreenOrientation.PORTRAIT)
            .putEnvironmentVariables("env1", "value")
            .setIsPerformanceMonitoringEnabled(true)
            .setSampleFrequency(SampleFrequencyProto.SampleFrequency.FREQUENT)
            .setUseSystemProfiler(false)
            .setIsVideoRecordingEnabled(true)
            .setTestRunnerClassName("null")
            .addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.AgendaTest")
                    .setMethodName("agenda_basicViewsDisplayed")
                    .setKey("agenda_basicViewsDisplayed")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.HomeTest")
                    .setMethodName("home_basicViewsDisplayed")
                    .setKey("home_basicViewsDisplayed")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.InfoTest")
                    .setMethodName("info_basicViewsDisplayed")
                    .setKey("info_basicViewsDisplayed")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.ScheduleTest")
                    .setMethodName("showFirstDay_sessionOnFirstDayShown")
                    .setKey("showFirstDay_sessionOnFirstDayShown")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.ScheduleTest")
                    .setMethodName("clickOnFirstItem_detailsShown")
                    .setKey("clickOnFirstItem_detailsShown")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.ScheduleTest")
                    .setMethodName("clickFilters_showFilters")
                    .setKey("clickFilters_showFilters")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.ScheduleTest")
                    .setMethodName("filters_applyAFilter")
                    .setKey("filters_applyAFilter")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.ScheduleTest")
                    .setMethodName("filters_clearFilters")
                    .setKey("filters_clearFilters")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.SessionDetailTest")
                    .setMethodName("details_basicViewsDisplayed")
                    .setKey("details_basicViewsDisplayed")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.SettingsTest")
                    .setMethodName("settings_basicViewsDisplayed")
                    .setKey("settings_basicViewsDisplayed")
                    .build()
            ).addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("com.google.samples.apps.iosched.tests.ui.MapTest")
                    .setMethodName("map_basicViewsDisplayed")
                    .setKey("map_basicViewsDisplayed")
                    .build()
            )
            .build()
    }

    fun getAssignedWork1(): WorkProto.Work {
        val key = UUID.randomUUID().toString()
        return WorkProto.Work.newBuilder()
            .setPackageName("org.mozilla.focus.debug")
            .setTestPackageName("org.mozilla.focus.debug.test")
            .setNumRetriesPerDevice(0)
            .setAutoScreenShotFps(20)
            .setAutoScreenShotQuality(20)
            .setIsIsolated(false)
            .setPayload(
                WorkProto.RemoteFile.newBuilder()
                    .setLastModified(System.currentTimeMillis())
                    .setSizeBytes(payloadFile.length())
                    .setUrl(payloadFile1.absolutePath)
                    .build()
            )
            .setTimeout(1_800_000) // 30 minutes
            .setRetrieveAppFiles(true)
            .setRetrieveTestFiles(true)
            .setTakeWindowAutoShots(true)
            .setShouldClearPackageData(true)
            .setObscureScreen(false)
            .setKey(key)
            .setType(WorkProto.TestType.INSTRUMENTATION)
            .setLocale(Locale.US.isO3Country)
            .setOrientation(WorkProto.ScreenOrientation.PORTRAIT)
            .putEnvironmentVariables("env1", "value")
            .setIsPerformanceMonitoringEnabled(true)
            .setSampleFrequency(SampleFrequencyProto.SampleFrequency.REGULAR)
            .setUseSystemProfiler(false)
            .setIsVideoRecordingEnabled(true)
            .setTestRunnerClassName("null")
            .addTests(
                AtomicTestProto.AtomicTest.newBuilder()
                    .setClassName("org.mozilla.focus.activity.MainActivityTest2")
                    .setMethodName("mainActivityTest2")
                    .build()
            )
            .build()
    }
}