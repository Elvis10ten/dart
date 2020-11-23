package com.fluentbuild.apollo.runner.base

object RemoteStorageConstants {

    const val PREFIX_CONTENT = "content://"
    const val AUTHORITY = "com.fluentbuild.apollo.runtime.remotestorage"
    const val BASE_URI = "${PREFIX_CONTENT}${AUTHORITY}/"

    const val MODE_READ = "r"
    const val MODE_WRITE = "w"
    const val MODE_APPEND = "wa"
}