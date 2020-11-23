package com.fluentbuild.apollo.presentation.faq

import android.content.Context
import android.view.ViewGroup
import com.fluentbuild.apollo.presentation.Host
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.utils.IntentUtils
import com.fluentbuild.apollo.views.Index
import com.fluentbuild.apollo.views.ScrollY
import com.fluentbuild.apollo.views.faq.FaqView
import com.fluentbuild.apollo.views.faq.FaqViewModel

class FaqHost(
    private val appContext: Context,
    private val eventLogger: FaqEventLogger,
    private val navigator: Navigator
): Host<FaqViewModel, FaqView>() {

    override fun createViewHolder(container: ViewGroup): FaqView {
        return FaqView(
            container.context,
            { onFaqClicked(it) },
            { onBackClicked() },
            { onContactSupportClicked() },
            { onScrolled(it) }
        )
    }

    private fun onFaqClicked(index: Index?) {
        if(index == null) {
            eventLogger.onFaqItemCollapsed()
        } else {
            val clickedItem = requireViewModel().items[index]
            eventLogger.onFaqItemExpanded(clickedItem.title)
        }

        updateViewHolder(requireViewModel().copy(expandedPosition = index))
    }

    private fun onContactSupportClicked() {
        eventLogger.onContactSupportClicked()
        IntentUtils.emailSupport(appContext)
    }

    private fun onBackClicked() {
        eventLogger.onBackClicked()
        navigator.onNavigateBack()
    }

    private fun onScrolled(scrollY: ScrollY) {
        updateViewModel(requireViewModel().copy(scrollPositionY = scrollY))
    }

    override fun createInitialViewModel(): FaqViewModel {
        return FaqViewModel(
            FaqItemsProvider.get(appContext)
        )
    }
}
