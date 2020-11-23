package com.fluentbuild.apollo.views.sheets

import androidx.fragment.app.FragmentActivity
import com.fluentbuild.apollo.views.databinding.SheetAlertBinding

class AlertSheet(private val activity: FragmentActivity) {

    private var bottomSheet: BottomSheet? = null

    fun show(content: Content) {
        dismiss()
        bottomSheet = BottomSheet.show(
            activity,
            BottomSheet.Content({
                    container ->
                val binding = SheetAlertBinding.inflate(activity.getLayoutInflater(), container, false)
                binding.content = content
                binding.root
            }, {
                // TODO
            })
        )
    }

    fun dismiss() {
        bottomSheet?.dismiss()
        bottomSheet = null
    }

    data class Content(
        val title: String,
        val description: String,
        val positiveActionText: String,
        val positiveActionClickCallback: () -> Unit,
        val negativeActionText: String,
        val negativeActionClickCallback: () -> Unit
    )
}
