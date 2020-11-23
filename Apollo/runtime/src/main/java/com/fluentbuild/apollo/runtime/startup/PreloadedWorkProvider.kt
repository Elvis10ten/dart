package com.fluentbuild.apollo.runtime.startup

import com.fluentbuild.apollo.work.WorkProto
import timber.log.Timber

object PreloadedWorkProvider {

    private var preloadedWork: WorkProto.Work? = null

    fun set(work: WorkProto.Work? = null) {
        Timber.i("Setting preloaded work: %s", work)
        preloadedWork = work
    }

    fun pop(): WorkProto.Work? {
        val poppedWork = preloadedWork
        Timber.i("Popping preloaded work: %s", preloadedWork)
        preloadedWork = null
        return poppedWork
    }
}
