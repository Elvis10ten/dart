package com.fluentbuild.apollo.auth

import android.os.Handler
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.auth.exceptions.AuthException
import com.fluentbuild.apollo.auth.exceptions.InternalAuthException
import com.fluentbuild.apollo.auth.exceptions.InvalidPhoneNumberException
import com.fluentbuild.apollo.auth.exceptions.UnknownAuthException
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

private const val VERIFY_TIMEOUT_SECONDS = 60

class PhoneAuthenticator(
    private val authManager: AuthManager,
    private val executor: ExecutorService,
    private val mainThreadHandler: Handler
) {

    private val lock = Object()

    private var callback: Callback? = null
    private var verificationId: String? = null
    private var isVerifying = false
    private var pendingVerificationException: Exception? = null
    private var pendingIsLoggedIn = false
    private var isSmsCodeSent = false

    @MainThread
    fun setCallback(callback: Callback) {
        Timber.v("PhoneAuthenticator callback set")
        this.callback = callback

        dispatchVerificationStartedEvent()
        dispatchSmsCodeSentEvent()
        dispatchPendingErrorEvent()
        dispatchPendingLoggedInEvent()
    }

    @MainThread
    fun removeCallback() {
        Timber.v("PhoneAuthenticator callback removed")
        this.callback = null
    }

    @MainThread
    fun verify(phoneNumber: String) {
        Timber.i("Verifying phone: %s", phoneNumber)
        synchronized(lock) {
            isVerifying = true
        }
        dispatchVerificationStartedEvent()

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,
            VERIFY_TIMEOUT_SECONDS.toLong(),
            TimeUnit.SECONDS,
            executor,
            object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    Timber.d("On verification completed, credential: %s", credential)
                    signIn(credential)
                }

                override fun onVerificationFailed(exception: FirebaseException) {
                    Timber.e(exception, "On verification failed")
                    synchronized(lock) {
                        pendingVerificationException = exception
                    }

                    dispatchPendingErrorEvent()
                }

                override fun onCodeSent(verifyId: String, token: PhoneAuthProvider.ForceResendingToken) {
                    Timber.d("On code sent, verifyId: %s, token: %s", verifyId, token)
                    synchronized(lock) {
                        verificationId = verifyId
                        isSmsCodeSent = true
                    }

                    dispatchSmsCodeSentEvent()
                }
            }
        )
    }

    @MainThread
    fun submitCodeManually(smsCode: String) {
        Timber.i("On submit code manually!")
        executor.execute {
            signIn(PhoneAuthProvider.getCredential(verificationId!!, smsCode))
        }
    }

    @MainThread
    fun clearAll() {
        Timber.d("Clear all")
        verificationId = null
        isSmsCodeSent = false
        isVerifying = false

        pendingVerificationException = null
        pendingIsLoggedIn = false
    }

    @WorkerThread
    private fun signIn(credential: PhoneAuthCredential) {
        try {
            authManager.signIn(credential)

            synchronized(lock) {
                pendingIsLoggedIn = true
            }

            dispatchPendingLoggedInEvent()
        } catch (exception: AuthException) {
            synchronized(lock) {
                pendingVerificationException = exception
            }

            dispatchPendingErrorEvent()
        }
    }

    private fun dispatchVerificationStartedEvent() {
        if(isVerifying) {
            mainThreadHandler.post { callback?.onVerificationStarted() }
        }
    }

    private fun dispatchSmsCodeSentEvent() {
        if(isSmsCodeSent) {
            mainThreadHandler.post { callback?.onSmsCodeSent() }
        }
    }

    private fun dispatchPendingLoggedInEvent() {
        if(pendingIsLoggedIn) {
            val verificationCallback = callback ?: return
            mainThreadHandler.post { verificationCallback.onSignedIn() }
            onComplete()
        }
    }

    private fun dispatchPendingErrorEvent() {
        val exception = pendingVerificationException ?: return
        val verificationCallback = callback ?: return
        Timber.e(exception, "Dispatching pending error event")

        mainThreadHandler.post {
            when (exception) {
                is FirebaseTooManyRequestsException -> {
                    verificationCallback.onVerificationFailed(InternalAuthException("Firebase SMS quota has been exceeded"))
                }
                is FirebaseAuthInvalidCredentialsException -> {
                    verificationCallback.onVerificationFailed(InvalidPhoneNumberException("Phone number is invalid"))
                }
                else -> {
                    verificationCallback.onVerificationFailed(UnknownAuthException("Unknown error occurred while verifying phone number", exception))
                }
            }
        }

        onComplete()
    }

    private fun onComplete() {
        synchronized(lock) {
            // todo
            //verificationId = null
            isSmsCodeSent = false
            isVerifying = false

            pendingVerificationException = null
            pendingIsLoggedIn = false
        }
    }

    interface Callback {

        fun onVerificationStarted()

        fun onSmsCodeSent()

        fun onSignedIn()

        fun onVerificationFailed(exception: AuthException)
    }
}
