package com.fluentbuild.apollo.runtime.store

import android.os.Handler
import androidx.annotation.WorkerThread
import com.fluentbuild.apollo.auth.Money
import com.fluentbuild.apollo.foundation.async.requireNotMainThread
import com.fluentbuild.apollo.persistence.document.CollectionReference
import com.fluentbuild.apollo.work.tests.RunReportProto.*
import com.fluentbuild.apollo.runtime.models.Minute
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.WorkSummaryProto
import timber.log.Timber
import java.math.BigDecimal
import java.util.concurrent.ExecutorService

private const val ID_HISTORIES = "ih"
private const val MAX_SIZE = 200

class HistoryStore(
    executorService: ExecutorService,
    private val mainThreadHandler: Handler,
    private val workHistoryCollection: CollectionReference<List<WorkHistory>>
): BaseStore<List<WorkHistory>>(executorService, mainThreadHandler) {

    @WorkerThread
    internal fun upsert(
        work: WorkProto.Work,
        runReport: RunReport,
        workSummary: WorkSummaryProto.WorkSummary
    ) {
        requireNotMainThread()
        Timber.i("Upserting work history: %s", workSummary)
        val histories = getData().toMutableList()
        histories.removeAll { it.key == work.key }

        val status = if(runReport.hasRunError()) WorkHistory.Status.FAILED else WorkHistory.Status.SUCCESS
        val money = Money(workSummary.currencySymbol, BigDecimal(workSummary.earnedAmount))

        histories.add(WorkHistory(
            work.key,
            status,
            money,
            Minute(workSummary.durationMinutes),
            System.currentTimeMillis()
        ))

        histories.sortedByDescending { it.lastUpdated }
        while(histories.size > MAX_SIZE) {
            histories.removeAt(histories.lastIndex)
        }

        mainThreadHandler.post { updateDataCallback(histories) }
        workHistoryCollection.save(ID_HISTORIES, histories)
    }

    override fun getData(): List<WorkHistory> {
        return workHistoryCollection.get(ID_HISTORIES) ?: emptyList()
    }
}