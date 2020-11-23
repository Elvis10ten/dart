package com.fluentbuild.apollo.views.faq

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.views.Index

class FaqListView(
    context: Context,
    attrSet: AttributeSet?
): RecyclerView(context, attrSet) {

    fun init(itemClickCallback: (Index?) -> Unit) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = FaqListAdapter(itemClickCallback)
    }

    fun update(items: List<FaqViewModel.Item>) {
        (adapter as FaqListAdapter).update(items)
    }

    fun setExpandedPosition(newExpandedPosition: Int?) {
        (adapter as FaqListAdapter).setExpandedPosition(newExpandedPosition)
    }
}
