package com.fluentbuild.apollo.androidtools

import android.content.Context
import android.os.Handler
import com.fluentbuild.apollo.androidtools.notifications.DndController
import com.fluentbuild.apollo.androidtools.notifications.DndPermission
import com.fluentbuild.apollo.androidtools.packages.*
import com.fluentbuild.apollo.androidtools.window.SystemWindows
import java.util.concurrent.ExecutorService

class AndroidToolsModule(
    private val appContext: Context,
    private val executorService: ExecutorService,
    private val mainThreadHandler: Handler
) {

    val installPermission by lazy {
        InstallPermission(appContext)
    }

    val dndPermission by lazy {
        DndPermission(appContext)
    }

    val systemWindows by lazy {
        SystemWindows(appContext)
    }

    val processKiller by lazy {
        ProcessKiller(appContext)
    }

    val dndController by lazy {
        DndController(appContext, dndPermission)
    }

    val strategyFactory by lazy {
        StrategyFactory(
            appContext,
            executorService,
            mainThreadHandler
        )
    }

    fun getPackageInstaller(): PackageInstaller {
        return PackageInstaller(
            appContext,
            executorService,
            mainThreadHandler,
            installPermission,
            strategyFactory
        )
    }

    fun getPackageRemover(): PackageRemover {
        return PackageRemover(
            appContext,
            executorService,
            mainThreadHandler,
            installPermission,
            strategyFactory
        )
    }
}