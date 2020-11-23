package com.fluentbuild.apollo.foundation.async


@Deprecated("Maybe")
sealed class ServiceState<out R: Any> {

    data class Success<out T: Any>(val data: T): ServiceState<T>()

    data class Error(val exception: Exception): ServiceState<Nothing>()

    object Loading: ServiceState<Nothing>()

    object Idle: ServiceState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
            Idle -> "Idle"
        }
    }
}
