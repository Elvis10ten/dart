package com.fluentbuild.workserver.work.pricing

import com.fluentbuild.apollo.work.tests.AtomicResultProto.*

class PriceEstimator {

    fun getCurrencySymbol(result: AtomicResult): String {
        return "$"
    }

    fun estimate(result: AtomicResult): Double {
        return (result.timeFinished - result.timeStarted) * 0.01
    }
}