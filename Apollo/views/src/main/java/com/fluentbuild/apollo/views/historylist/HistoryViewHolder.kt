package com.fluentbuild.apollo.views.historylist

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.foundation.android.createColorStateList
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.R
import com.fluentbuild.apollo.views.databinding.ItemHistoryBinding
import com.fluentbuild.apollo.views.utils.MoneyFormatter

internal class HistoryViewHolder(
    private val binding: ItemHistoryBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(moneyFormatter: MoneyFormatter, history: WorkHistory) {
        binding.history = history
        binding.moneyFormatter = moneyFormatter
        binding.historyIcon.setHistoryStatus(history.status)
    }
}

private fun ImageView.setHistoryStatus(status: WorkHistory.Status) {
    when(status) {
        WorkHistory.Status.SUCCESS -> {
            backgroundTintList = context.createColorStateList(R.color.colorSuccessStatus)
            setImageResource(R.drawable.ic_check_black_24)
        }
        WorkHistory.Status.PENDING -> {
            backgroundTintList = context.createColorStateList(R.color.colorNeutralStatus)
            setImageResource(R.drawable.ic_schedule_black_24)
        }
        WorkHistory.Status.FAILED -> {
            backgroundTintList = context.createColorStateList(R.color.colorAlertStatus)
            setImageResource(R.drawable.ic_exclamation_black_24)
        }
    }
}
