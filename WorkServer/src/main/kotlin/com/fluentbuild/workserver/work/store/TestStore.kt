package com.fluentbuild.workserver.work.store

import com.fluentbuild.apollo.work.WorkCheckpointProto.WorkCheckpoint
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.reports.PerformanceReportProto.*
import com.fluentbuild.reports.TestDetailsProto.TestDetails

interface TestStore {

    fun upsertTestUpdates(query: TestQuery, results: List<AtomicResult>)

    fun deleteTestUpdates(query: TestQuery, results: List<AtomicResult>)

    fun getTestUpdates(query: DeviceWorkQuery): List<AtomicResult>

    fun upsertAtomicResults(query: DeviceWorkQuery, results: MutableList<AtomicResult>)

    fun deleteAtomicResult(query: DeviceWorkQuery, results: MutableList<AtomicResult>)

    fun getTestDetails(query: TestQuery): TestDetails

    fun getTestPerformanceReport(query: TestQuery): PerformanceReport

    fun getTestLogs(query: TestQuery, startOffset: Int): TestLogs
}

