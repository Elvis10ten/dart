package com.fluentbuild.apollo.runtime.store

import android.os.Handler
import androidx.annotation.MainThread
import com.fluentbuild.apollo.foundation.async.requireMainThread
import com.fluentbuild.apollo.persistence.document.CollectionReference
import com.fluentbuild.apollo.runtime.models.WorkSchedule
import java.util.concurrent.ExecutorService

private const val ID_SCHEDULE = "is"

class ScheduleStore(
    private val executorService: ExecutorService,
    mainThreadHandler: Handler,
    private val scheduleCollection: CollectionReference<WorkSchedule>
): BaseStore<WorkSchedule?>(executorService, mainThreadHandler) {

    @MainThread
    internal fun setSchedule(schedule: WorkSchedule) {
        requireMainThread()
        updateDataCallback(schedule)
        executorService.execute {
            scheduleCollection.save(ID_SCHEDULE, schedule)
        }
    }

    override fun getData(): WorkSchedule? {
        return scheduleCollection.get(ID_SCHEDULE)
    }
}