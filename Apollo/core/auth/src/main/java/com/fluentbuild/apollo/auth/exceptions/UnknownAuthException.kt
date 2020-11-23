package com.fluentbuild.apollo.auth.exceptions

class UnknownAuthException(message: String, cause: Throwable): AuthException(message, cause)
