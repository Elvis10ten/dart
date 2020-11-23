package com.fluentbuild.apollo.runner.server.models

import android.content.ComponentName
import android.content.Context
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.work.WorkProto
import com.fluentbuild.apollo.work.tests.AtomicTestProto.*

data class ServerArgs(
    val work: WorkProto.Work,
    val instrumentations: List<InstrumentationMeta>,
    val testsAlreadyRan: Map<InstrumentationMeta, Set<AtomicTest>>
)

data class InstrumentationMeta(
    val componentName: ComponentName,
    val functionalTest: Boolean,
    val targetPackage: String,
    val targetProcesses: String?
)

fun Context.getInstrumentationsMeta(packageName: String): List<InstrumentationMeta> {
    return packageManager.queryInstrumentation(packageName, 0).map {
        InstrumentationMeta(
            ComponentName(it.packageName, it.name),
            it.functionalTest,
            it.targetPackage,
            if(AndroidVersion.isAtLeastOreo()) it.targetProcesses else null
        )
    }
}
