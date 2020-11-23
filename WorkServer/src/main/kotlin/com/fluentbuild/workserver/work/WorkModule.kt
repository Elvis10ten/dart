package com.fluentbuild.workserver.work

import com.fluentbuild.apollo.work.ft.FileStorage
import com.fluentbuild.apollo.work.ft.FtLogger
import com.fluentbuild.workserver.Injector
import com.fluentbuild.workserver.work.artifacts.FileArtifactStore
import com.fluentbuild.workserver.work.pricing.PriceEstimator
import com.fluentbuild.workserver.work.reports.ResultsProcessor
import com.fluentbuild.workserver.work.reports.TestDetailsMaker
import com.fluentbuild.workserver.work.reports.TestLogReader
import com.fluentbuild.workserver.work.reports.TestPerformanceReportMaker
import com.fluentbuild.workserver.work.store.DbTestStore
import com.fluentbuild.workserver.work.store.WorkStore
import com.fluentbuild.workserver.work.wire.UseCaseProvider
import com.fluentbuild.workserver.work.wire.WorkService
import java.io.File

class WorkModule(
    private val workStore: WorkStore,
    private val artifactStore: FileArtifactStore
) {

    private val logger = object: FtLogger {

        override fun i(message: () -> String) {
            println(message())
        }

        override fun e(throwable: Throwable, message: () -> String) {
            throwable.printStackTrace()
            println(throwable)
            println(message())
        }

    }

    private val storage = FileStorage(
        Injector.baseDir,
        logger
    )

    private val priceEstimator = PriceEstimator()

    private val testDetailsMaker = TestDetailsMaker(priceEstimator, artifactStore)
    private val testPerformanceReportMaker = TestPerformanceReportMaker(artifactStore)
    private val testLogReader = TestLogReader(artifactStore)

    private val testStore = DbTestStore(
        testDetailsMaker,
        testPerformanceReportMaker,
        testLogReader
    )

    private val useCaseProvider = UseCaseProvider(
        workStore,
        testStore,
        logger,
        storage,
        ResultsProcessor(artifactStore)
    )

    fun getWorkService(): WorkService {
        return WorkService(
            useCaseProvider,
            testStore
        )
    }
}