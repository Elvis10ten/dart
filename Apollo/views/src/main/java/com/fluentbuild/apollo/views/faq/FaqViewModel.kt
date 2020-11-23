package com.fluentbuild.apollo.views.faq

import android.graphics.drawable.Drawable
import com.fluentbuild.apollo.views.Index
import com.fluentbuild.apollo.views.ScrollY

data class FaqViewModel(
    val items: List<Item>,
    val scrollPositionY: ScrollY? = null,
    val expandedPosition: Int? = null
) {

    data class Item(
        val icon: Drawable,
        val title: String,
        val description: String
    )
}
