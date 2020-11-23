package com.fluentbuild.apollo.views.sheets

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Should be expanded all the way to the top
class BottomSheet: BottomSheetDialogFragment() {

    private lateinit var content: Content
    private var shouldInvokeDismissCallback = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return content.viewInflater(container)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if(shouldInvokeDismissCallback) {
            content.dismissCallback()
        }
    }

    fun dismissBottomSheet(shouldInvokeDismissCallback: Boolean) {
        this.shouldInvokeDismissCallback = shouldInvokeDismissCallback
        dismiss()
    }

    companion object {

        fun show(activity: FragmentActivity, content: Content): BottomSheet {
            val sheet = BottomSheet()
            sheet.content = content
            sheet.show(activity.supportFragmentManager, null)
            return sheet
        }
    }

    data class Content(
        val viewInflater: (ViewGroup?) -> View,
        val dismissCallback: () -> Unit
    )
}
