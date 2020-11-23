package com.fluentbuild.apollo.utils

import android.content.Context
import com.fluentbuild.apollo.R
import com.fluentbuild.apollo.runtime.ContainerNotProvisionedException
import com.fluentbuild.apollo.runtime.ContainerUnSupportedException

object ErrorMessageProvider {

    fun get(context: Context, throwable: Throwable): String {
        val errorResId = when(throwable) {
            is ContainerNotProvisionedException -> R.string.runtime_container_not_provisioned
            is ContainerUnSupportedException -> R.string.runtime_container_not_supported
            // todo: Handle other exceptions
            else -> R.string.runtimeGenericError
        }

        return context.getString(errorResId)
    }
}