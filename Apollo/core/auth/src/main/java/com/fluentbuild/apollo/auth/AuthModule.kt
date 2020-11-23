package com.fluentbuild.apollo.auth

import android.os.Handler
import com.fluentbuild.apollo.analytics.EventPublisher
import com.fluentbuild.apollo.persistence.document.DocumentDb
import java.util.concurrent.ExecutorService

private const val AUTH_COLLECTION_NAME = "auth"

class AuthModule(
    private val mainHandler: Handler,
    private val executorService: ExecutorService,
    private val documentDb: DocumentDb,
    private val eventPublisher: EventPublisher
) {

    val authManager by lazy { AuthManager(documentDb.collection(AUTH_COLLECTION_NAME, AuthModel::class.java), eventPublisher) }

    val phoneAuthenticator by lazy { PhoneAuthenticator(authManager, executorService, mainHandler) }

    val signupService by lazy { SignupService(authManager, executorService, mainHandler) }
}
