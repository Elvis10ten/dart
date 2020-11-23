package com.fluentbuild.apollo.runtime.stages

import android.os.IBinder

data class StageServiceBinder(
    val binder: IBinder,
    val unbindCallback: () -> Unit
)