package com.fluentbuild.apollo.runner.client.instrumentation

import android.app.Instrumentation
import android.os.Handler
import androidx.test.internal.runner.listener.InstrumentationResultPrinter
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.async.createBackgroundHandler
import com.fluentbuild.apollo.runner.client.*
import com.fluentbuild.apollo.runner.client.collators.CollatorsManager
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.ActivityMonitor
import com.fluentbuild.apollo.runner.client.instrumentation.lifecycle.AppMonitor
import com.fluentbuild.apollo.runner.client.interrupts.InterruptsManager
import com.fluentbuild.apollo.runner.client.junit.TestObserver
import com.fluentbuild.apollo.runner.client.overlays.OverlaysManager
import com.fluentbuild.apollo.runner.client.tasks.InitTasksManager

class InstrumentationInitializer(
    private val instrumentation: Instrumentation,
    private val appMonitor: AppMonitor,
    private val activityMonitor: ActivityMonitor,
    private val logWrapper: LogWrapper
) {

    private lateinit var interruptsManager: InterruptsManager
    private lateinit var overlaysManager: OverlaysManager
    private lateinit var collatorsManager: CollatorsManager

    private lateinit var screenShotHandler: Handler
    private lateinit var profilerHandler: Handler

    private lateinit var testConfigs: TestConfigs
    private lateinit var testObserver: TestObserver

    private lateinit var testClient: TestClient

    private lateinit var clientFinalizer: ClientFinalizer

    fun init(testConfigs: TestConfigs, instrumentationResultPrinter: InstrumentationResultPrinter) {
        this.testConfigs = testConfigs
        val targetContext = instrumentation.targetContext
        val mainThreadHandler = Handler(targetContext.mainLooper)

        screenShotHandler = createBackgroundHandler("ScreenShotHandler")
        profilerHandler = createBackgroundHandler("ProfilerHandler")

        val fileDescriptorProvider = FileDescriptorProvider(targetContext)
        val artifactsCopier = ArtifactsCopier(
            targetContext,
            instrumentation.context,
            fileDescriptorProvider,
            testConfigs,
            logWrapper
        )

        clientFinalizer = ClientFinalizer(artifactsCopier)

        testClient = TestClient(instrumentation, clientFinalizer, logWrapper)
        InitTasksManager(targetContext, testConfigs, logWrapper).run()

        overlaysManager = OverlaysManager(testConfigs, activityMonitor)

        interruptsManager = InterruptsManager(
            targetContext,
            logWrapper,
            activityMonitor,
            testClient
        )

        collatorsManager = CollatorsManager(
            targetContext,
            mainThreadHandler,
            testConfigs,
            screenShotHandler,
            activityMonitor,
            appMonitor,
            fileDescriptorProvider,
            profilerHandler,
            logWrapper
        ) { activity -> overlaysManager.getOverlayRootView(activity) }

        testObserver = TestObserver(
            testClient,
            testConfigs,
            instrumentationResultPrinter,
            clientFinalizer,
            collatorsManager,
            logWrapper
        ) { updateProgressUi(it) }

        collatorsManager.start()
        overlaysManager.init()
        interruptsManager.start()
    }

    fun onStart() {
        testClient.connect()
    }

    fun deInit() {
        interruptsManager.stop()
        collatorsManager.stop()

        screenShotHandler.looper.quit()
        profilerHandler.looper.quit()

        testClient.disconnect()
    }

    private fun updateProgressUi(text: String) {
        overlaysManager.updateProgressUi(text)
    }

    fun getTestObserver(): InstrumentationResultPrinter = testObserver
}