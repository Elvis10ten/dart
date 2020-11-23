package com.fluentbuild.apollo.views.historylist

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.utils.MoneyFormatter

class HistoryListView(
    context: Context,
    attrSet: AttributeSet?
): RecyclerView(context, attrSet) {

    fun init(moneyFormatter: MoneyFormatter, historyClickCallback: (WorkHistory) -> Unit) {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = HistoryAdapter(moneyFormatter, historyClickCallback)
    }

    fun update(histories: List<WorkHistory>) {
        (adapter as HistoryAdapter).update(histories)
    }
}
