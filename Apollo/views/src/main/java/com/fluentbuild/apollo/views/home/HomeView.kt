package com.fluentbuild.apollo.views.home

import android.animation.ValueAnimator
import android.content.Context
import android.view.ViewTreeObserver
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.FragmentActivity
import com.fluentbuild.apollo.foundation.android.getLayoutInflater
import com.fluentbuild.apollo.foundation.android.createColorStateList
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.runtime.models.WorkHistory
import com.fluentbuild.apollo.views.R
import com.fluentbuild.apollo.views.ScrollY
import com.fluentbuild.apollo.views.ViewHolder
import com.fluentbuild.apollo.views.databinding.HomeBinding
import com.fluentbuild.apollo.views.sheets.AlertSheet
import com.fluentbuild.apollo.views.utils.MoneyFormatter
import com.fluentbuild.apollo.views.utils.addSingleGlobalLayoutListener
import com.fluentbuild.apollo.views.utils.changeBackgroundColor
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView

class HomeView(
    private val context: Context,
    private val moneyFormatter: MoneyFormatter,
    private val runtimeSwitchClickCallback: (RuntimeState) -> Unit,
    private val actionClickCallback: (HomeAction) -> Unit,
    private val confirmShutdownClickCallback: () -> Unit,
    private val notConfirmShutdownClickCallback: () -> Unit,
    private val historyClickCallback: (WorkHistory) -> Unit,
    private val profileClickCallback: () -> Unit,
    private val onScroll: (ScrollY) -> Unit,
    private val onRuntimeOnboardingDismissed: () -> Unit
): ViewHolder<HomeViewModel> {

    private lateinit var binding: HomeBinding
    private var powerToggleAnimator: ValueAnimator? = null
    private var shutdownConfirmationAlertSheet: AlertSheet? = null
    private var lastDispatchScrolledY = 0
    private var scrollViewTreeListener: ViewTreeObserver.OnGlobalLayoutListener? = null
    private var runtimeSwitchOnboardingView: TapTargetView? = null

    override fun create() {
        binding = HomeBinding.inflate(context.getLayoutInflater())
        binding.historyListView.init(moneyFormatter, historyClickCallback)

        binding.runtimeSwitch.setOnClickListener {
            binding.model?.let { runtimeSwitchClickCallback(it.runtimeState) }
        }

        binding.bottomAppBar.setOnMenuItemClickListener {
            actionClickCallback(HomeAction.find(it.itemId))
            true
        }

        binding.homeScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            if(lastDispatchScrolledY != scrollY) {
                lastDispatchScrolledY = scrollY
                onScroll(scrollY)
            }
        })

        binding.profileContainer.setOnClickListener {
            profileClickCallback()
        }

        binding.moneyFormatter = moneyFormatter
    }

    override fun destroy() {
        clearAnimations()
        binding.runtimeSwitch.setOnClickListener(null)
        binding.bottomAppBar.setOnMenuItemClickListener(null)
        binding.profileContainer.setOnClickListener(null)

        val scrollListener: NestedScrollView.OnScrollChangeListener? = null
        binding.homeScrollView.setOnScrollChangeListener(scrollListener)
        clearScrollViewLayoutListener()

        clearShutdownConfirmationAlertSheet()
        clearRuntimeSwitchOnboardingView()
    }

    override fun setViewModel(viewModel: HomeViewModel) {
        updateRuntimeSwitch(binding.model?.runtimeState, viewModel.runtimeState)
        binding.historyListView.update(viewModel.histories)

        showHideShutdownAlertSheet(binding.model?.showShutdownConfirmationSheet == true, viewModel.showShutdownConfirmationSheet)
        showHideRuntimeSwitchOnboarding(binding.model?.showRuntimeSwitchOnboarding == true, viewModel.showRuntimeSwitchOnboarding)

        binding.model = viewModel

        clearScrollViewLayoutListener()
        scrollViewTreeListener = binding.homeScrollView.addSingleGlobalLayoutListener {
            viewModel.scrollPositionY?.let {
                lastDispatchScrolledY = it
                binding.homeScrollView.scrollTo(0, it)
            }
        }
    }

    override fun getRoot() = binding.root

    private fun showHideShutdownAlertSheet(wasShowing: Boolean, showNow: Boolean) {
        if(wasShowing && !showNow) {
            clearShutdownConfirmationAlertSheet()
        }

        if(!wasShowing && showNow) {
            shutdownConfirmationAlertSheet = AlertSheet(context as FragmentActivity).apply {
                show(AlertSheet.Content(
                    context.getString(R.string.confirmShutdownTitle),
                    context.getString(R.string.confirmShutdownDescription),
                    context.getString(R.string.confirmShutdownPositiveAction),
                    { notConfirmShutdownClickCallback() },
                    context.getString(R.string.confirmShutdownNegativeAction),
                    { confirmShutdownClickCallback() }
                ))
            }
        }
    }

    private fun updateRuntimeSwitch(oldRuntimeState: RuntimeState?, newRuntimeState: RuntimeState) {
        clearAnimations()
        if(oldRuntimeState == null) {
            binding.runtimeSwitch.setImageDrawable(newRuntimeState.getIconDrawable(context))
            binding.runtimeSwitch.backgroundTintList = context.createColorStateList(newRuntimeState.getBackgroundColor())
        } else if(oldRuntimeState != newRuntimeState) {
            powerToggleAnimator = with(binding.runtimeSwitch) {
                setImageDrawable(newRuntimeState.getIconDrawable(context))
                changeBackgroundColor(
                    oldRuntimeState.getBackgroundColor(),
                    newRuntimeState.getBackgroundColor()
                )
            }
        }
    }

    private fun showHideRuntimeSwitchOnboarding(wasShowing: Boolean, showNow: Boolean) {
        if(wasShowing && !showNow) {
            clearRuntimeSwitchOnboardingView()
        }

        if(!wasShowing && showNow) {
            val target = TapTarget.forView(
                binding.runtimeSwitch,
                context.getString(R.string.homeOnboardingRuntimeSwitchTitle),
                context.getString(R.string.homeOnboardingRuntimeSwitchDescription)
            ).apply {
                tintTarget(false)
                drawShadow(true)
                dimColor(android.R.color.black)
            }

            runtimeSwitchOnboardingView = TapTargetView.showFor(
                context as FragmentActivity,
                target,
                object: TapTargetView.Listener() {

                    override fun onTargetDismissed(view: TapTargetView, userInitiated: Boolean) {
                        onRuntimeOnboardingDismissed()
                        super.onTargetDismissed(view, userInitiated)
                    }

                    override fun onTargetClick(view: TapTargetView) {
                        binding.model?.let { runtimeSwitchClickCallback(it.runtimeState) }
                        super.onTargetClick(view)
                    }
                }
            )
        }
    }

    private fun clearRuntimeSwitchOnboardingView() {
        runtimeSwitchOnboardingView?.dismiss(false)
        runtimeSwitchOnboardingView = null
    }

    private fun clearShutdownConfirmationAlertSheet() {
        shutdownConfirmationAlertSheet?.dismiss()
        shutdownConfirmationAlertSheet = null
    }

    private fun clearScrollViewLayoutListener() {
        scrollViewTreeListener?.let { binding.homeScrollView.viewTreeObserver.removeOnGlobalLayoutListener(it) }
        scrollViewTreeListener = null
    }

    private fun clearAnimations() {
        powerToggleAnimator?.cancel()
        powerToggleAnimator = null
    }
}
