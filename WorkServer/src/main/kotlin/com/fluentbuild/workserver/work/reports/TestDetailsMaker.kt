package com.fluentbuild.workserver.work.reports

import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.reports.TestDetailsProto.*
import com.fluentbuild.workserver.work.artifacts.ArtifactStore
import com.fluentbuild.workserver.work.pricing.PriceEstimator
import com.fluentbuild.workserver.work.store.TestQuery

class TestDetailsMaker(
    private val priceEstimator: PriceEstimator,
    private val artifactStore: ArtifactStore
) {

    fun make(
        query: TestQuery,
        mainResult: AtomicResult,
        retriesResult: List<AtomicResult>
    ): TestDetails {
        val resultArtifacts = artifactStore.listResultArtifacts(query.createDeviceWorkQuery(), mainResult)

        return TestDetails.newBuilder()
            .setAtomicTest(mainResult.atomicTest)
            .setStatus(mainResult.status)
            .setStackTrace(mainResult.stackTrace)
            .setSummaryProfile(mainResult.summaryProfile)
            .setVideo(resultArtifacts.screenVideo)
            .addAllScreenshots(resultArtifacts.screenshots)
            .addAllOthers(resultArtifacts.others)
            .addAllRetries(makeRetries(query, retriesResult))
            .setApproximateCost(priceEstimator.estimate(mainResult))
            .setCurrencySymbol(priceEstimator.getCurrencySymbol(mainResult))
            .build()
    }

    private fun makeRetries(
        query: TestQuery,
        retriesResult: List<AtomicResult>
    ): List<RetryDetails> {
        val retryDetails = mutableListOf<RetryDetails>()

        for(retryResult in retriesResult) {
            val resultArtifacts = artifactStore.listResultArtifacts(query.createDeviceWorkQuery(), retryResult)

            retryDetails += RetryDetails.newBuilder()
                .setStatus(retryResult.status)
                .setStackTrace(retryResult.stackTrace)
                .setSummaryProfile(retryResult.summaryProfile)
                .addAllScreenshots(resultArtifacts.screenshots)
                .addAllOthers(resultArtifacts.others)
                .setApproximateCost(priceEstimator.estimate(retryResult))
                .setCurrencySymbol(priceEstimator.getCurrencySymbol(retryResult))
                .build()
        }

        return retryDetails
    }
}