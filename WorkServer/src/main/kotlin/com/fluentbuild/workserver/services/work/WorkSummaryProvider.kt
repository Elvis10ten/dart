package com.fluentbuild.workserver.services.work

import com.fluentbuild.apollo.work.WorkSummaryProto

class WorkSummaryProvider {

    var timeTakenMinutes = 0L

    fun getWorkSummary(): WorkSummaryProto.WorkSummary {
        return WorkSummaryProto.WorkSummary.newBuilder()
            .setCurrencySymbol("$")
            .setDurationMinutes(timeTakenMinutes.toInt())
            .setEarnedAmount(timeTakenMinutes * 0.002)
            .build()
    }
}