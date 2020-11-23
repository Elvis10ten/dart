package com.fluentbuild.apollo.auth

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.auth.exceptions.AuthException
import com.fluentbuild.apollo.foundation.async.Service
import com.fluentbuild.apollo.foundation.async.ServiceState
import com.fluentbuild.apollo.foundation.async.requireMainThread
import java.util.concurrent.ExecutorService

// TODO: Handle sign up when Firebase asks for recent auth activity.  FirebaseAuthRecentLoginRequiredException
class SignupService(
    private val authManager: AuthManager,
    executor: ExecutorService,
    mainThreadHandler: Handler
): Service<Unit>(executor, mainThreadHandler) {

    @MainThread
    fun signup(request: SignupRequest) {
        requireMainThread()
        updateState(ServiceState.Loading)

        execute {
            authManager.signUp(request)
        }
    }
}
