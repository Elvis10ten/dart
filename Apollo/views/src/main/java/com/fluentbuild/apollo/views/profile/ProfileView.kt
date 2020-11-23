package com.fluentbuild.apollo.views.profile

import android.content.Context
import android.view.View
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.ProfileBinding
import com.fluentbuild.apollo.views.utils.MoneyFormatter

class ProfileView(
    private val context: Context,
    private val moneyFormatter: MoneyFormatter,
    private val backClickCallback: () -> Unit,
    private val logoutClickCallback: () -> Unit,
    private val manageWalletClickCallback: () -> Unit
): ViewHolder<ProfileViewModel> {

    private lateinit var binding: ProfileBinding

    override fun create() {
        binding = ProfileBinding.inflate(context.getLayoutInflater())
        binding.moneyFormatter = moneyFormatter

        binding.backButton.setOnClickListener { backClickCallback() }
        binding.logoutButton.setOnClickListener { logoutClickCallback() }
        binding.manageWalletButton.setOnClickListener { manageWalletClickCallback() }
    }

    override fun destroy() {
        binding.backButton.setOnClickListener(null)
        binding.logoutButton.setOnClickListener(null)
        binding.manageWalletButton.setOnClickListener(null)
    }

    override fun setViewModel(viewModel: ProfileViewModel) {
        binding.model = viewModel
    }

    override fun getRoot() = binding.root
}
