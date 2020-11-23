package com.fluentbuild.apollo.auth

import android.os.Handler
import com.fluentbuild.apollo.foundation.async.Service
import com.fluentbuild.apollo.foundation.async.ServiceState
import com.fluentbuild.apollo.auth.Money
import com.fluentbuild.apollo.auth.Wallet
import java.math.BigDecimal
import java.util.concurrent.ExecutorService

// todo: this should be removed in favour of wallet object in auth object
class WalletService(
    executorService: ExecutorService,
    mainThreadHandler: Handler
): Service<Wallet>(executorService, mainThreadHandler) {

    init {
        updateState(ServiceState.Success(
            Wallet(
                Money(
                    "$",
                    BigDecimal(32000)
                )
            )
        ))
    }

    fun addJob() {
        // Update job
        //updateState(ServiceState.Success())
    }

    fun updateJob() {
        // Update job
        //updateState(ServiceState.Success())
    }

    fun getWallet(): Wallet {
        return Wallet(Money("$", BigDecimal(32000)))
    }
}
