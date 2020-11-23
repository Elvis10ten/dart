package com.fluentbuild.workserver.work.store

import com.fluentbuild.apollo.work.WorkCheckpointProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.reports.PerformanceReportProto.*
import com.fluentbuild.reports.TestDetailsProto.*
import com.fluentbuild.workserver.work.reports.TestDetailsMaker
import com.fluentbuild.workserver.work.reports.TestLogReader
import com.fluentbuild.workserver.work.reports.TestPerformanceReportMaker

class DbTestStore(
    private val testDetailsMaker: TestDetailsMaker,
    private val testPerformanceReportMaker: TestPerformanceReportMaker,
    private val testLogReader: TestLogReader
): TestStore {

    // TODO: Change Dummy memory db
    // todo: do actual queries
    private val testUpdates = mutableMapOf<TestQuery, MutableList<AtomicResult>>()
    private val workResults = mutableMapOf<DeviceWorkQuery, MutableList<AtomicResult>>()

    override fun upsertTestUpdates(query: TestQuery, results: List<AtomicResult>) {
        val savedUpdates = testUpdates.getOrPut(query, { mutableListOf() })
        savedUpdates.addAll(results)
        testUpdates[query] = savedUpdates
    }

    override fun deleteTestUpdates(query: TestQuery, results: List<AtomicResult>) {
        val savedUpdates = testUpdates.getOrPut(query, { mutableListOf() })
        savedUpdates.removeAll(results)
        testUpdates[query] = savedUpdates
    }

    override fun getTestUpdates(query: DeviceWorkQuery): List<AtomicResult> {
        val testUpdates = testUpdates.filterKeys { it.workKey == query.workKey && it.deviceKey == query.deviceKey }
        return testUpdates.values.flatten()
    }

    override fun upsertAtomicResults(query: DeviceWorkQuery, results: MutableList<AtomicResult>) {
        workResults[query] = results
    }

    override fun deleteAtomicResult(query: DeviceWorkQuery, results: MutableList<AtomicResult>) {
        workResults[query]?.removeAll(results)
    }

    override fun getTestDetails(query: TestQuery): TestDetails {
        val workDeviceResults = workResults.filterKeys {
            it.workKey == query.workKey && it.deviceKey == query.deviceKey
        }.values.flatten()
        val atomicResults = workDeviceResults.filter { it.atomicTest.key == query.testKey }

        val mainResult = atomicResults.last()
        val retriesResult = atomicResults.dropLast(1)
        return testDetailsMaker.make(query, mainResult, retriesResult)
    }

    override fun getTestPerformanceReport(query: TestQuery): PerformanceReport {
        val workDeviceResults = workResults.filterKeys {
            it.workKey == query.workKey && it.deviceKey == query.deviceKey
        }.values.flatten()
        val atomicResult = workDeviceResults.last { it.atomicTest.key == query.testKey }

        return testPerformanceReportMaker.make(query.createDeviceWorkQuery(), atomicResult)
    }

    override fun getTestLogs(query: TestQuery, startOffset: Int): TestLogs {
        val workDeviceResults = workResults.filterKeys {
            it.workKey == query.workKey && it.deviceKey == query.deviceKey
        }.values.flatten()
        val atomicResult = workDeviceResults.last { it.atomicTest.key == query.testKey }

        return testLogReader.read(query.createDeviceWorkQuery(), startOffset, atomicResult)
    }
}