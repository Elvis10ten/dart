package com.fluentbuild.apollo.views.historylist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.databinding.ItemHistoryBinding
import com.fluentbuild.apollo.views.utils.MoneyFormatter

internal class HistoryAdapter(
    private val moneyFormatter: MoneyFormatter,
    private val clickCallback: (WorkHistory) -> Unit
): RecyclerView.Adapter<HistoryViewHolder>() {

    private var histories = emptyList<WorkHistory>()

    fun update(newHistories: List<WorkHistory>) {
        histories = newHistories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            parent.context.getLayoutInflater(),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun getItemCount() = histories.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = histories[position]
        holder.bind(moneyFormatter, history)
        holder.itemView.setOnClickListener { clickCallback(history) }
    }
}
