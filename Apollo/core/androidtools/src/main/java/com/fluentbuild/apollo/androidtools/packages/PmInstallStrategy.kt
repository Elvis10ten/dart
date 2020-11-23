package com.fluentbuild.apollo.androidtools.packages

import android.app.PendingIntent
import android.content.*
import android.content.pm.PackageInfo.INSTALL_LOCATION_INTERNAL_ONLY
import android.content.pm.PackageInstaller.*
import android.content.pm.PackageManager.INSTALL_REASON_USER
import android.graphics.Bitmap
import android.net.Uri
import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.DEFAULT_IO_BUFFER_SIZE
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.async.cancelInterrupting
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.foundation.autoClose
import timber.log.Timber
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

private const val APP_LABEL = "Payload"
private const val REQUEST_CODE_INSTALL_STATUS = 69

class PmInstallStrategy(
    private val appContext: Context,
    private val mainThreadHandler: Handler,
    private val executorService: ExecutorService,
    private val targetPackageName: String,
    private val installAppIcon: Bitmap,
    private val timeoutMillis: Long,
    // Callback is used implicitly as a isDisposed check
    private var callback: InstallStrategy.Callback?
): InstallStrategy {

    private val packageInstaller = appContext.packageManager.packageInstaller
    private val actionInstallStatus = "${appContext.packageName}.ACTION_INSTALL_STATUS"
    private val actionUninstallStatus = "${appContext.packageName}.ACTION_UNINSTALL_STATUS"
    
    private var writeInstallAppFuture: Future<*>? = null
    private val timeoutRunnable = Runnable {
        onError(InstallStrategy.TimeoutException(timeoutMillis))
    }

    private var statusReceiver = object: BroadcastReceiver() {

        var isRegistered = false

        override fun onReceive(context: Context, intent: Intent?) {
            val extras = intent?.extras ?: return
            Timber.i("Status received: %s", intent)

            when (extras.getInt(EXTRA_STATUS)) {
                STATUS_SUCCESS -> {
                    disposeInternal()
                    callback?.onCompleted()
                }
                STATUS_PENDING_USER_ACTION -> {
                    Timber.i("Prompting user for action")
                    val promptIntent = extras.getParcelable<Intent>(Intent.EXTRA_INTENT) as Intent
                    promptIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    appContext.startActivity(promptIntent)
                }
                STATUS_FAILURE_BLOCKED -> {
                    val blockingPackageName = extras.getString(EXTRA_OTHER_PACKAGE_NAME)
                    onError(InstallStrategy.BlockedException(blockingPackageName))
                }
                STATUS_FAILURE -> {
                    onError(InstallStrategy.GenericException())
                }
                STATUS_FAILURE_ABORTED -> {
                    onError(InstallStrategy.AbortedException())
                }
                STATUS_FAILURE_CONFLICT -> {
                    onError(InstallStrategy.ConflictException())
                }
                STATUS_FAILURE_INVALID -> {
                    onError(InstallStrategy.InvalidException())
                }
                STATUS_FAILURE_STORAGE -> {
                    onError(InstallStrategy.StorageException())
                }
                STATUS_FAILURE_INCOMPATIBLE -> {
                    onError(InstallStrategy.IncompatibleException())
                }
            }
        }
    }

    @MainThread
    override fun install(appFile: File) {
        requireMainThread()
        Timber.i("Installing: %s from file: %s", targetPackageName, appFile)
        val params = getInstallParams(appFile)
        val session: Session

        try {
            Timber.d("Opening session")
            val sessionId = packageInstaller.createSession(params)
            session = packageInstaller.openSession(sessionId)
        } catch (e: Exception) {
            Timber.e(e, "Failed to open session")
            onError(e)
            return
        }

        statusReceiver.isRegistered = true
        appContext.registerReceiver(statusReceiver, IntentFilter(actionInstallStatus))
        mainThreadHandler.postDelayed(timeoutRunnable, timeoutMillis)
        
        writeInstallAppFuture = executorService.submit {
            try {
                writeInstallApp(session, appFile)
                commitSession(session)
            } catch (e: Exception) {
                onSessionError(session, e)
            }
        }
    }

    private fun writeInstallApp(session: Session, appFile: File) {
        Timber.d("Writing APK file")
        session.openWrite(targetPackageName, 0, appFile.length())
            .autoClose { sessionOutputStream ->
                appFile.inputStream().autoClose { fileInputStream ->
                    fileInputStream.copyTo(sessionOutputStream, DEFAULT_IO_BUFFER_SIZE)
                }
                session.fsync(sessionOutputStream)
            }
    }

    private fun commitSession(session: Session) {
        mainThreadHandler.post {
            if(callback != null) {
                try {
                    session.commit(createInstallSender(actionInstallStatus))
                } catch (e: Exception) {
                    onSessionError(session, e)
                }
            } else {
                session.abandon()
            }
        }
    }

    private fun onSessionError(session: Session, error: Throwable) {
        Timber.e(error, "Session error")
        mainThreadHandler.post {
            session.abandon()
            onError(error)
        }
    }

    @MainThread
    override fun uninstall() {
        requireMainThread()
        Timber.i("Uninstalling: %s", targetPackageName)
        statusReceiver.isRegistered = true
        appContext.registerReceiver(statusReceiver, IntentFilter(actionUninstallStatus))
        mainThreadHandler.postDelayed(timeoutRunnable, timeoutMillis)
        packageInstaller.uninstall(targetPackageName, createInstallSender(actionUninstallStatus))
    }

    @MainThread
    override fun dispose() {
        requireMainThread()
        Timber.i("Disposing listeners")
        callback = null
        disposeInternal()
    }

    private fun onError(error: Throwable) {
        disposeInternal()
        callback?.onError(error)
    }
    
    private fun disposeInternal() {
        mainThreadHandler.removeCallbacks(timeoutRunnable)

        if(statusReceiver.isRegistered) {
            statusReceiver.isRegistered = false
            appContext.unregisterReceiver(statusReceiver)
        }

        writeInstallAppFuture?.cancelInterrupting()
        writeInstallAppFuture = null
    }
    
    private fun createInstallSender(action: String): IntentSender {
        return PendingIntent.getBroadcast(
            appContext,
            REQUEST_CODE_INSTALL_STATUS,
            Intent(action),
            0
        ).intentSender
    }

    private fun getInstallParams(appFile: File): SessionParams {
        return SessionParams(SessionParams.MODE_FULL_INSTALL).apply {
            setAppPackageName(targetPackageName)
            setAppLabel(APP_LABEL)
            setAppIcon(installAppIcon)
            setInstallLocation(INSTALL_LOCATION_INTERNAL_ONLY)
            setSize(appFile.length())
            setOriginatingUri(Uri.fromFile(appFile))

            if(AndroidVersion.isAtLeastOreo()) {
                setInstallReason(INSTALL_REASON_USER)
            }
        }
    }
}