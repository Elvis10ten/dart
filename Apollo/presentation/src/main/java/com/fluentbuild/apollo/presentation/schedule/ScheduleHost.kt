package com.fluentbuild.apollo.presentation.schedule

import android.view.ViewGroup
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.views.schedule.ScheduleView
import com.fluentbuild.apollo.views.schedule.ScheduleViewModel

class ScheduleHost(
    private val navigator: Navigator
): Host<ScheduleViewModel, ScheduleView>() {

    override fun createViewHolder(container: ViewGroup): ScheduleView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInitialViewModel(): ScheduleViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
