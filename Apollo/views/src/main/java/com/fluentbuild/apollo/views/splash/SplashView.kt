package com.fluentbuild.apollo.views.splash

import android.content.Context
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.SplashBinding

class SplashView(
    private val context: Context
): ViewHolder<SplashViewModel> {

    private lateinit var binding: SplashBinding

    override fun create() {
        binding = SplashBinding.inflate(context.getLayoutInflater())
    }

    override fun destroy() {
    }

    override fun setViewModel(viewModel: SplashViewModel) {
        binding.model = viewModel
    }

    override fun getRoot() = binding.root
}
