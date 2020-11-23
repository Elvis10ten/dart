package com.fluentbuild.apollo.foundation

fun <T> T?.foldNull(onNonNull: (T) -> Unit, onNull: () -> Unit) {
    if(this == null) {
        onNull()
    } else {
        onNonNull(this)
    }
}