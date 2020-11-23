package com.fluentbuild.apollo.runner.server

class ClientCrashException(
    val stackTrace: String
): RuntimeException()