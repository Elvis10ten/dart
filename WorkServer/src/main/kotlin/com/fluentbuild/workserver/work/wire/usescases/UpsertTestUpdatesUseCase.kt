package com.fluentbuild.workserver.work.wire.usescases

import com.fluentbuild.apollo.work.DelineateWorkRequestProto.*
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.store.TestQuery
import com.fluentbuild.workserver.work.store.TestStore

class UpsertTestUpdatesUseCase(
    private val testStore: TestStore,
    private val logger: Logger
) {

    fun run(request: DelineateWorkRequest) {
        for(result in request.checkpoint.resultsList) {
            val query = TestQuery(request.workKey, request.deviceKey, result.atomicTest.key)
            logger.d("Upsert: %s", query)
            testStore.upsertTestUpdates(query, listOf(result))
        }
    }
}