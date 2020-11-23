package com.fluentbuild.apollo.presentation.historydetail

import android.view.ViewGroup
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.historydetail.HistoryDetailView
import com.fluentbuild.apollo.views.historydetail.HistoryDetailViewModel

class HistoryDetailHost(
    private val history: WorkHistory,
    private val navigator: Navigator
): Host<HistoryDetailViewModel, HistoryDetailView>() {
    override fun createViewHolder(container: ViewGroup): HistoryDetailView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createInitialViewModel(): HistoryDetailViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
