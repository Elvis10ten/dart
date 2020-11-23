package com.fluentbuild.apollo.views.onboarding

import androidx.fragment.app.FragmentActivity
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.OnboardingBinding

class OnboardingView(
    private val activity: FragmentActivity,
    private val getStartedClickCallback: () -> Unit,
    private val faqClickCallback: () -> Unit
): ViewHolder<OnboardingViewModel> {

    private lateinit var binding: OnboardingBinding

    override fun create() {
        binding = OnboardingBinding.inflate(activity.layoutInflater)
        binding.getStartedButton.setOnClickListener { getStartedClickCallback() }
        binding.faqButton.setOnClickListener { faqClickCallback() }
    }

    override fun destroy() {
        binding.getStartedButton.setOnClickListener(null)
        binding.faqButton.setOnClickListener(null)
    }

    override fun setViewModel(viewModel: OnboardingViewModel) {
        binding.model = viewModel
    }

    override fun getRoot() = binding.root
}
