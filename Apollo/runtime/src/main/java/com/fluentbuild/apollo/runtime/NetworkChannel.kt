package com.fluentbuild.apollo.runtime

import android.content.Context
import io.grpc.ManagedChannel
import io.grpc.android.AndroidChannelBuilder
import java.util.concurrent.ExecutorService

class NetworkChannel(
    private val appContext: Context,
    private val isDebug: Boolean,
    private val configProvider: ConfigProvider,
    private val executorService: ExecutorService
) {

    fun get(): ManagedChannel {
        val hostName = configProvider.getHostName()
        val port = configProvider.getPort()
        val channelBuilder =  AndroidChannelBuilder.forAddress(hostName, port)
            .context(appContext)
            .enableRetry()
            .offloadExecutor(executorService)

        if(isDebug) {
            channelBuilder.usePlaintext()
        }

        return channelBuilder.build()
    }
}