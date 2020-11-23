package com.fluentbuild.apollo.auth.exceptions

import java.lang.Exception

abstract class AuthException(
    message: String,
    cause: Throwable? = null
): Exception(message, cause)
