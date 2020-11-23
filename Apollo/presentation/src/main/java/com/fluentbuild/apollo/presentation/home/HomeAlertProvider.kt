package com.fluentbuild.apollo.presentation.home

import android.content.Context
import com.fluentbuild.apollo.presentation.R
import com.fluentbuild.apollo.runtime.store.ScheduleStore
import com.fluentbuild.apollo.views.home.HomeAlert

class HomeAlertProvider(
    private val appContext: Context,
    private val workScheduleStore: ScheduleStore
) {

    fun getHighestPriorityAlert(
        enableScheduleClickCallback: () -> Unit
    ): HomeAlert? {
        // todo: Use schedule callback maybe?
        return if(workScheduleStore.getData() == null) {
            HomeAlert(
                appContext.getString(R.string.enableScheduleAlertText),
                appContext.getString(R.string.enableScheduleAlertActionText),
                enableScheduleClickCallback,
                HomeAlert.Type.NORMAL
            )
        } else {
            null
        }
    }
}
