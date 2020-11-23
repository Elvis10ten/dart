package com.fluentbuild.workserver

import com.fluentbuild.workserver.db.DbConnection
import com.fluentbuild.workserver.db.DbModule
import com.fluentbuild.workserver.work.WorkModule
import com.fluentbuild.workserver.work.artifacts.FileArtifactStore
import com.fluentbuild.workserver.work.store.DbWorkStore
import com.fluentbuild.workserver.work.wire.WorkService
import java.io.File

object Injector {

    val baseDir = File("src/main/resources")
    val workStore = DbWorkStore()

    val dbModule = DbModule(
        DbConnection(DB_URL, DB_USER, DB_PASSWORD)
    )

    val workModule = WorkModule(
        workStore,
        FileArtifactStore(baseDir)
    )
}