package com.fluentbuild.apollo.auth

import android.net.Uri
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.auth.exceptions.AuthException
import com.fluentbuild.apollo.auth.exceptions.IncorrectSmsCodeException
import com.fluentbuild.apollo.auth.exceptions.UnknownAuthException
import com.fluentbuild.apollo.persistence.document.CollectionReference
import com.fluentbuild.apollo.analytics.EventPublisher
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.UserProfileChangeRequest
import timber.log.Timber

private const val REQUESTS_TIMEOUT_MILLIS = 20_000
private const val ID_AUTH_MODEL = "authmod"
private const val NAME_SEGMENT_DELIMITER = "_"
private const val NO_PHOTO_URL = "null"

// TODO: List of exceptions:
// FirebaseNetworkException
class AuthManager(
    private val authCollection: CollectionReference<AuthModel>,
    private val eventPublisher: EventPublisher
) {

    private var firebaseAuth = FirebaseAuth.getInstance()
    private var signOutInitiated = false

    init {
        firebaseAuth.useAppLanguage()
        firebaseAuth.addAuthStateListener {
            if(!isSignedIn() && !signOutInitiated) {
                Timber.i("User has been signed out!")
                // todo: Restart process instead? onUnInitiatedSignOutCallback()
            }
            updateAuthStore()
        }
    }

    @WorkerThread
    @Throws(AuthException::class)
    fun signUp(request: SignupRequest) {
        Timber.d("Signing up: %s", request)
        try {
            val currentUser = firebaseAuth.currentUser!!

            setProfile(request.firstName, request.lastName)
            currentUser.updatePassword(request.password).await(REQUESTS_TIMEOUT_MILLIS)
            currentUser.updateEmail(request.email).await(REQUESTS_TIMEOUT_MILLIS)
        } catch (e: Exception) {
            Timber.e(e, "Error signing up")
            if(e is AuthException) {
                throw e
            }

            throw UnknownAuthException("An unknown exception occurred while signing up", e)
        }
    }

    @WorkerThread
    @Throws(AuthException::class)
    fun setProfile(firstName: String, lastName: String) {
        try {
            Timber.d("Setting profile, firstName: %s, lastName: %s", firstName, lastName)
            val updateProfileRequest = UserProfileChangeRequest.Builder()
                .setDisplayName(firstName + NAME_SEGMENT_DELIMITER + lastName)
                .setPhotoUri(Uri.parse(NO_PHOTO_URL))
                .build()

            val currentUser = firebaseAuth.currentUser!!
            currentUser.updateProfile(updateProfileRequest).await(REQUESTS_TIMEOUT_MILLIS)
        } catch (e: Exception) {
            Timber.e(e, "Error setting profile")
            if(e is AuthException) {
                throw e
            }

            throw UnknownAuthException("An unknown exception occurred while setting profile", e)
        }
    }

    @WorkerThread
    @Throws(AuthException::class)
    fun signIn(credential: PhoneAuthCredential) {
        Timber.d("Signing in: %s", credential)
        try {
            val authResult = firebaseAuth.signInWithCredential(credential).await(REQUESTS_TIMEOUT_MILLIS)
        } catch (e: Exception) {
            Timber.e(e, "Error signing in")
            if(e is FirebaseAuthInvalidCredentialsException) {
                throw IncorrectSmsCodeException("The SMS verification code is invalid")
            } else if(e is AuthException) {
                throw e
            }

            throw UnknownAuthException("An unknown exception occurred while signing in", e)
        }
    }

    fun signOut() {
        Timber.i("Signing out user!")
        signOutInitiated = true
        firebaseAuth.signOut()
    }

    fun isSignedIn() = firebaseAuth.currentUser != null

    fun hasProfile() = firebaseAuth.currentUser?.email != null && !firebaseAuth.currentUser?.displayName.isNullOrBlank()

    // todo: Sync this with with the hasProfile check. There should be a single source of truth.
    fun requireAuthModel(): AuthModel {
        return authCollection.get(ID_AUTH_MODEL)!!
    }

    private fun updateAuthStore() {
        val currentUser = firebaseAuth.currentUser
        if(currentUser == null) {
            authCollection.drop()
            return
        }

        val displayName = currentUser.displayName ?: return
        val email = currentUser.email ?: return
        val photoUrl = currentUser.photoUrl?.toString() ?: NO_PHOTO_URL
        if(!hasProfile()) {
            return
        }

        val (firstName, lastName) = with(displayName.split(NAME_SEGMENT_DELIMITER)) { get(0) to get(1) }

        val authModel = AuthModel(
            currentUser.uid,
            email,
            currentUser.phoneNumber!!,
            photoUrl,
            firstName,
            lastName
        )

        eventPublisher.initProps(authModel.uuid)
        authCollection.save(ID_AUTH_MODEL, authModel)
    }
}
