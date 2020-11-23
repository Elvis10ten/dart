package com.fluentbuild.apollo.runner.server

import com.fluentbuild.apollo.runner.server.models.InstrumentationMeta
import com.fluentbuild.apollo.work.WorkProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.apollo.work.tests.AtomicTestProto.*
import com.fluentbuild.apollo.work.tests.InstrumentationProto.*
import com.fluentbuild.apollo.work.tests.RunReportProto.*

class ResultsHolder(
    private val work: Work
) {

    private val emptyResults = emptyList<AtomicResult>()
    private val instrumentationsResults = mutableMapOf<InstrumentationMeta, Set<AtomicResult>>()
    private val retriedInstrumentationsResults =
        mutableMapOf<InstrumentationMeta, MutableMap<AtomicTest, MutableList<AtomicResult>>>()

    fun put(instrumentationMeta: InstrumentationMeta, atomicResults: Set<AtomicResult>) {
        instrumentationsResults[instrumentationMeta] = atomicResults
    }

    fun clear() {
        instrumentationsResults.clear()
    }

    fun moveRunFailedTestsFromAlreadyRanList() {
        for((instrumentationMeta, instrumentationResults) in instrumentationsResults) {
            val iterator = instrumentationResults.iterator() as MutableIterator

            while(iterator.hasNext()) {
                val atomicResult = iterator.next()

                if(atomicResult.isRunFailed()) {
                    val instrumentationRetries = retriedInstrumentationsResults.getOrPut(
                        instrumentationMeta,
                        { mutableMapOf() }
                    )

                    val testRetries = instrumentationRetries.getOrPut(
                        atomicResult.atomicTest,
                        { mutableListOf() }
                    )

                    testRetries += atomicResult
                    iterator.remove()
                }
            }
        }
    }

    fun getTestsAlreadyRan(): Map<InstrumentationMeta, Set<AtomicTest>> {
        return instrumentationsResults.mapValues { resultsEntry ->
            resultsEntry.value.map { it.atomicTest }.toSet()
        }
    }

    fun isComplete(): Boolean {
        for((instrumentationMeta, instrumentationResults) in instrumentationsResults) {
            if(instrumentationResults.size < work.testsList.size) return false

            for(atomicResult in instrumentationResults) {
                if(atomicResult.isRunFailed()) {
                    val retriedResult = getRetries(instrumentationMeta, atomicResult.atomicTest)
                    if(retriedResult.size < work.numTestRetries) return false
                }
            }
        }

        return instrumentationsResults.isNotEmpty()
    }

    private fun getRetries(
        instrumentationMeta: InstrumentationMeta,
        atomicTest: AtomicTest
    ): List<AtomicResult> {
        return retriedInstrumentationsResults[instrumentationMeta]?.get(atomicTest) ?: emptyResults
    }

    private fun getRetries(
        instrumentationMeta: InstrumentationMeta
    ): List<AtomicResult>? {
        val instrumentationRetries = retriedInstrumentationsResults[instrumentationMeta] ?: return null
        val retries = mutableListOf<AtomicResult>()

        for(retryEntry in instrumentationRetries) {
            retries.addAll(retryEntry.value)
        }

        return retries
    }

    fun getResults(): InstrumentationResult {
        val instrumentationResults = mutableListOf<InstrumentationResult>()

        for(instrumentationMeta in instrumentationsResults.keys) {
            val instrumentation = Instrumentation.newBuilder()
                .setClassName(instrumentationMeta.componentName.className)
                .setPackageName(instrumentationMeta.componentName.packageName)
                .build()

            val instrumentationResultBuilder = InstrumentationResult.newBuilder()
                .setInstrumentation(instrumentation)
                .addAllAtomicResults(instrumentationsResults.getValue(instrumentationMeta))

            val retriedAtomicResults = getRetries(instrumentationMeta)
            if(retriedAtomicResults != null) {
                instrumentationResultBuilder.addAllRetriedAtomicResults(retriedAtomicResults)
            }

            instrumentationResults.add(instrumentationResultBuilder.build())
        }

        // todo: use only single instrumentation
        return instrumentationResults.first()
    }
}