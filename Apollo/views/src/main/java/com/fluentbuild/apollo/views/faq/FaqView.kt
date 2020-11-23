package com.fluentbuild.apollo.views.faq

import android.content.Context
import android.view.ViewTreeObserver
import androidx.core.widget.NestedScrollView
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.views.Index
import com.fluentbuild.apollo.views.ScrollY
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.FaqBinding
import com.fluentbuild.apollo.views.utils.addSingleGlobalLayoutListener

class FaqView(
    private val context: Context,
    private val faqItemClickCallback: (Index?) -> Unit,
    private val backClickCallback: () -> Unit,
    private val contactSupportClickCallback: () -> Unit,
    private val onScroll: (ScrollY) -> Unit
): ViewHolder<FaqViewModel> {

    private lateinit var binding: FaqBinding
    private var lastDispatchScrolledY = 0
    private var scrollViewTreeListener: ViewTreeObserver.OnGlobalLayoutListener? = null

    override fun create() {
        binding = FaqBinding.inflate(context.getLayoutInflater())
        binding.faqList.init(faqItemClickCallback)
        binding.contactSupportButton.setOnClickListener { contactSupportClickCallback() }
        binding.backButton.setOnClickListener { backClickCallback() }

        binding.faqScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            if(lastDispatchScrolledY != scrollY) {
                lastDispatchScrolledY = scrollY
                onScroll(scrollY)
            }
        })
    }

    override fun destroy() {
        binding.backButton.setOnClickListener(null)
        binding.contactSupportButton.setOnClickListener(null)

        val scrollListener: NestedScrollView.OnScrollChangeListener? = null
        binding.faqScrollView.setOnScrollChangeListener(scrollListener)
        clearScrollViewLayoutListener()
    }

    override fun setViewModel(viewModel: FaqViewModel) {
        if(binding.model?.items != viewModel.items) {
            binding.faqList.update(viewModel.items)
        }

        if(binding.model?.expandedPosition != viewModel.expandedPosition) {
            binding.faqList.setExpandedPosition(viewModel.expandedPosition)
        }

        binding.model = viewModel

        scrollViewTreeListener = binding.faqScrollView.addSingleGlobalLayoutListener {
            viewModel.scrollPositionY?.let {
                lastDispatchScrolledY = it
                binding.faqScrollView.scrollTo(0, it)
            }
        }
    }

    override fun getRoot() = binding.root

    private fun clearScrollViewLayoutListener() {
        scrollViewTreeListener?.let { binding.faqScrollView.viewTreeObserver.removeOnGlobalLayoutListener(it) }
        scrollViewTreeListener = null
    }
}
