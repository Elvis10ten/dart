package com.fluentbuild.apollo.measurement.ui

import android.app.Activity
import android.app.Application
import com.fluentbuild.apollo.measurement.ActivityStatsProto.ActivityStats
import com.fluentbuild.apollo.measurement.ApplicationStatsProto.ApplicationStats

object UiStatsFactory {

    fun createActivityStats(
        activity: Activity,
        stage: ActivityStats.Stage,
        relativeTime: Int
    ): ActivityStats {
        return ActivityStats.newBuilder()
            .setName(activity::class.java.name)
            .setStage(stage)
            .setRelativeTime(relativeTime)
            .build()
    }

    fun createAppStats(
        app: Application,
        stage: ApplicationStats.Stage,
        relativeTime: Int
    ): ApplicationStats {
        return ApplicationStats.newBuilder()
            .setName(app::class.java.name)
            .setStage(stage)
            .setRelativeTime(relativeTime)
            .build()
    }
}