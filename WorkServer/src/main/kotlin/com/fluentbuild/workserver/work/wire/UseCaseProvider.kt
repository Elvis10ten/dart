package com.fluentbuild.workserver.work.wire

import com.fluentbuild.apollo.work.ft.FtLogger
import com.fluentbuild.apollo.work.ft.Storage
import com.fluentbuild.workserver.utils.Logger
import com.fluentbuild.workserver.work.reports.ResultsProcessor
import com.fluentbuild.workserver.work.store.TestStore
import com.fluentbuild.workserver.work.store.WorkStore
import com.fluentbuild.workserver.work.wire.usescases.*

class UseCaseProvider(
    private val workStore: WorkStore,
    private val testStore: TestStore,
    private val ftLogger: FtLogger,
    private val storage: Storage,
    private val resultsProcessor: ResultsProcessor
) {

    fun provideGetTestDetailsUseCase(): GetTestDetailsUseCase {
        return GetTestDetailsUseCase(testStore, Logger(GetTestDetailsUseCase::class.java.simpleName))
    }

    fun provideGetTestLogsUseCase(): GetTestLogsUseCase {
        return GetTestLogsUseCase(testStore, Logger(GetTestLogsUseCase::class.java.simpleName))
    }

    fun provideGetTestPerformanceUseCase(): GetTestPerformanceUseCase {
        return GetTestPerformanceUseCase(testStore, Logger(GetTestPerformanceUseCase::class.java.simpleName))
    }

    fun provideGetWorkDevicesUseCase(): GetWorkDevicesUseCase {
        return GetWorkDevicesUseCase(workStore, Logger(GetWorkDevicesUseCase::class.java.simpleName))
    }

    fun provideGetWorkUseCase(): GetWorkUseCase {
        return GetWorkUseCase(workStore, Logger(GetWorkUseCase::class.java.simpleName))
    }

    fun provideGetWorkUpdatesUseCase(): GetWorkUpdatesUseCase {
        return GetWorkUpdatesUseCase(testStore, Logger(GetWorkUpdatesUseCase::class.java.simpleName))
    }

    fun provideUpsertTestUpdatesUseCase(): UpsertTestUpdatesUseCase {
        return UpsertTestUpdatesUseCase(testStore, Logger(UpsertTestUpdatesUseCase::class.java.simpleName))
    }

    fun provideCompleteWorkUseCase(): CompleteWorkUseCase {
        return CompleteWorkUseCase(
            ftLogger,
            Logger(CompleteWorkUseCase::class.java.simpleName),
            storage,
            resultsProcessor
        )
    }

    fun provideDownloadPayloadUseCase(): DownloadPayloadUseCase {
        return DownloadPayloadUseCase(
            storage,
            ftLogger,
            workStore,
            Logger(DownloadPayloadUseCase::class.java.simpleName)
        )
    }

    fun provideFindWorkUseCase(): FindWorkUseCase {
        return FindWorkUseCase(
            workStore,
            Logger(FindWorkUseCase::class.java.simpleName)
        )
    }
}