package com.fluentbuild.apollo.presentation.faq

import android.content.Context
import com.fluentbuild.apollo.presentation.R
import com.fluentbuild.apollo.views.faq.FaqViewModel

object FaqItemsProvider {

    fun get(appContext: Context): List<FaqViewModel.Item> {
        return listOf(
            FaqViewModel.Item(
                appContext.getDrawable(R.drawable.ic_verified_user_black_24)!!,
                appContext.getString(R.string.faqItemTitle1),
                appContext.getString(R.string.faqItemDescription1)
            ),
            FaqViewModel.Item(
                appContext.getDrawable(R.drawable.ic_dollar_black_24)!!,
                appContext.getString(R.string.faqItemTitle2),
                appContext.getString(R.string.faqItemDescription2)
            ),
            FaqViewModel.Item(
                appContext.getDrawable(R.drawable.ic_trending_up_black_24)!!,
                appContext.getString(R.string.faqItemTitle3),
                appContext.getString(R.string.faqItemDescription3)
            ),
            FaqViewModel.Item(
                appContext.getDrawable(R.drawable.ic_eco_black_24)!!,
                appContext.getString(R.string.faqItemTitle4),
                appContext.getString(R.string.faqItemDescription4)
            )
        )
    }
}
