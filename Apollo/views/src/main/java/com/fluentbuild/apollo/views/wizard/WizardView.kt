package com.fluentbuild.apollo.views.wizard

import android.content.Context
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.WizardBinding
import com.fluentbuild.apollo.views.utils.ViewChangeAnimator

class WizardView(
    private val context: Context,
    private val primaryActionClickCallback: () -> Unit,
    private val skipClickCallback: () -> Unit
): ViewHolder<WizardViewModel> {

    private lateinit var binding: WizardBinding
    private var wizardAnimator: ViewChangeAnimator? = null

    override fun create() {
        binding = WizardBinding.inflate(context.getLayoutInflater())
        binding.primaryButton.setOnClickListener { primaryActionClickCallback() }
        binding.skipButton.setOnClickListener { skipClickCallback() }
    }

    override fun destroy() {
        clearAnimations()
        binding.primaryButton.setOnClickListener(null)
        binding.skipButton.setOnClickListener(null)
    }

    override fun setViewModel(viewModel: WizardViewModel) {
        clearAnimations()
        wizardAnimator = ViewChangeAnimator(
            binding.wizardContainer,
            { viewModel.currentIndex != 0 },
            {
                binding.model = viewModel
                binding.executePendingBindings()
            }
        ).animate()
    }

    override fun getRoot() = binding.root

    private fun clearAnimations() {
        wizardAnimator?.cancel()
        wizardAnimator = null
    }
}
