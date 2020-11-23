package com.fluentbuild.apollo.views.faq

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.views.Index
import com.fluentbuild.apollo.views.databinding.ItemFaqBinding

internal class FaqListAdapter(
    private val clickCallback: (Index?) -> Unit
): RecyclerView.Adapter<FaqListViewHolder>() {

    private var items: List<FaqViewModel.Item> = emptyList()
    private var expandedPosition: Int? = null

    fun update(items: List<FaqViewModel.Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setExpandedPosition(newExpandedPosition: Int?) {
        val previousExpandedPosition = expandedPosition
        expandedPosition = newExpandedPosition

        previousExpandedPosition?.let { notifyItemChanged(it) }
        expandedPosition?.let { notifyItemChanged(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqListViewHolder {
        val binding = ItemFaqBinding.inflate(
            parent.context.getLayoutInflater(),
            parent,
            false
        )
        return FaqListViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FaqListViewHolder, position: Int) {
        val item = items[position]
        holder.bind(position == expandedPosition, item)
        holder.itemView.setOnClickListener {
            clickCallback(if(expandedPosition == position) null else position)
        }
    }
}
