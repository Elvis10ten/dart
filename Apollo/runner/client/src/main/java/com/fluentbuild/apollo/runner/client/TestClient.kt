package com.fluentbuild.apollo.runner.client

import android.app.Activity
import android.app.Instrumentation
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.RemoteException
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.android.requireServiceBind
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import com.fluentbuild.apollo.runner.Finisher
import com.fluentbuild.apollo.runner.TestCallback
import com.fluentbuild.apollo.runner.base.WorkInterruptCallback
import com.fluentbuild.apollo.runner.client.collators.CollateInfo
import com.fluentbuild.apollo.runner.client.instrumentation.finishInstrumentation
import com.fluentbuild.apollo.runner.client.junit.createTestModel
import org.junit.runner.Description
import org.junit.runner.Result
import org.junit.runner.notification.Failure
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

private const val LOG_TAG = "TestClient"
private const val RUNNER_PACKAGE = "com.fluentbuild.apollo"
private const val RUNNER_SERVICE = "com.fluentbuild.apollo.RunnerService"
private const val SERVICE_CONNECTION_TIMEOUT_MILLIS = 10_000L

/**
 * For the current instrumentation to communicate information back to the RuntimeService.
 *
 */
class TestClient(
    private val instrumentation: Instrumentation,
    private val clientFinalizer: ClientFinalizer,
    private val logWrapper: LogWrapper
): WorkInterruptCallback {

    private val connectionLock = Object()
    private val connectionLatch = CountDownLatch(1)

    @Volatile
    private lateinit var testCallback: TestCallback
    @Volatile
    private var hasRequestedServiceConnection = false
    private var isUsed = false


    private val serviceConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            requireMainThread()
            logWrapper.i(LOG_TAG, "TestClient connected to runner service")
            testCallback = TestCallback.Stub.asInterface(service)
            connectionLatch.countDown()
        }

        override fun onServiceDisconnected(className: ComponentName) {
            requireMainThread()
            logWrapper.e(LOG_TAG, "TestClient is disconnected from runner service")
            instrumentation.finishInstrumentation(Activity.RESULT_CANCELED)
        }
    }

    @WorkerThread
    fun connect() {
        requireNotMainThread()
        logWrapper.i(LOG_TAG, "Connecting to runner service")
        if(isUsed) {
            throw IllegalStateException("TestClient cannot be reconnected to!")
        }

        val intent = Intent()
        intent.setClassName(RUNNER_PACKAGE, RUNNER_SERVICE)

        synchronized(connectionLock) {
            instrumentation.context.requireServiceBind(intent, serviceConnection)
            hasRequestedServiceConnection = true
            isUsed = true

            if(!connectionLatch.await(SERVICE_CONNECTION_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
                unbindService()
                throw TimeoutException("Couldn't connect to runner service")
            }

            onClientConnected()
        }
    }

    private fun onClientConnected() {
        try {
            testCallback.onClientConnected(object : Finisher.Stub() {

                override fun finish(resultCode: Int) {
                    logWrapper.i(LOG_TAG, "Instrumentation finish requested")
                    clientFinalizer.finalize()
                    instrumentation.finishInstrumentation(resultCode)
                }
            })
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to notify runner service of connection!", e)
        }
    }

    @MainThread
    fun disconnect() {
        requireMainThread()
        synchronized(connectionLock) {
            unbindService()
        }
    }

    private fun unbindService() {
        if(hasRequestedServiceConnection) {
            instrumentation.context.unbindService(serviceConnection)
            hasRequestedServiceConnection = false
        }
    }

    fun testRunStarted(description: Description) {
        try {
            testCallback.onTestRunStarted(description.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test run started event to runtime", e)
        }
    }

    fun testStarted(
        description: Description,
        info: CollateInfo
    ) {
        try {
            testCallback.onTestStarted(
                description.createTestModel(),
                info.logFileName,
                info.profilerFileName,
                info.screenShotNamePrefix
            )
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test started event to runtime", e)
        }
    }

    fun testAssumptionFailure(failure: Failure) {
        try {
            testCallback.onTestAssumptionFailure(failure.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test assumption failure event to runtime", e)
        }
    }

    fun testRunFinished(result: Result) {
        try {
            testCallback.onTestRunFinished(result.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test run finished event to runtime", e)
        }
    }

    fun testFailure(failure: Failure) {
        try {
            testCallback.onTestFailure(failure.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test failure event to runtime", e)
        }
    }

    fun testFinished(description: Description) {
        try {
            testCallback.onTestFinished(description.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test finished event to runtime", e)
        }
    }

    fun testIgnored(description: Description) {
        try {
            testCallback.onTestIgnored(description.createTestModel())
        } catch (e: RemoteException) {
            handleRemoteFailure("Unable to send test ignored event to runtime", e)
        }
    }

    fun processCrashed(failure: Failure) {
        try {
            testCallback.onProcessCrashed(failure.description?.createTestModel(), failure.trace)
        } catch (e: RemoteException) {
            // Ignore, crashing anyways
            logWrapper.e(LOG_TAG, e, "Unable to send process crashed event to runtime")
        }
    }

    override fun onInterrupted(reason: WorkInterruptCallback.Reason) {
        try {
            testCallback.onInterrupted(reason.id)
        } catch (e: RemoteException) {
            handleRemoteFailure("Failed to interrupt via runtime", e)
        }
    }

    fun sendString(message: String) {
        try {
            testCallback.sendString(message)
        } catch (e: RemoteException) {
            handleRemoteFailure("Failed to send message to runtime", e)
        }
    }

    private fun handleRemoteFailure(msg: String, exception: RemoteException) {
        logWrapper.e(LOG_TAG, exception, msg)
        instrumentation.finishInstrumentation(Activity.RESULT_CANCELED)
    }
}