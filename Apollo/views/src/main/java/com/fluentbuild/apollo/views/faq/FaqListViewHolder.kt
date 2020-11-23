package com.fluentbuild.apollo.views.faq

import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.views.databinding.ItemFaqBinding

internal class FaqListViewHolder(
    private val binding: ItemFaqBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(isExpanded: Boolean, item: FaqViewModel.Item) {
        binding.isExpanded = isExpanded
        binding.item = item
        binding.executePendingBindings()
    }
}
