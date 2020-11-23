package com.fluentbuild.apollo.foundation.async

import java.util.concurrent.Future

fun <V> Future<V>?.cancelInterrupting() {
    this?.cancel(true)
}
