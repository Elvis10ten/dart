package com.fluentbuild.apollo.container

import android.content.Context

class ContainerModule(
    private val appContext: Context
) {

    val containerProvisioner by lazy { ContainerProvisioner(appContext) }
}
