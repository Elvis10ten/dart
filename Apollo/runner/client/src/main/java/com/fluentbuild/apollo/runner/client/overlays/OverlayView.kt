package com.fluentbuild.apollo.runner.client.overlays

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import com.fluentbuild.apollo.foundation.android.setBackgroundColor
import com.fluentbuild.apollo.foundation.android.setPadding
import com.fluentbuild.apollo.foundation.android.toHtmlSpan

private const val INTERRUPT_WARNING_TEXT = "<b>Note:</b> You won't earn any money if you interrupt work."
private const val INITIAL_TEXT = "Setting up!"

internal class OverlayView(context: Context) {

    val rootView: LinearLayout = LinearLayout(context)
    private val labelTextView: TextView

    init {
        rootView.orientation = LinearLayout.VERTICAL
        rootView.setBackgroundColor("#6200EE")
        rootView.setPadding(24f)
        rootView.gravity = Gravity.CENTER_HORIZONTAL

        rootView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val spaceLayoutParams = LinearLayout.LayoutParams(0, 0, 1f)
        val visibleChildLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val firstSpace = Space(context)
        firstSpace.layoutParams = LinearLayout.LayoutParams(spaceLayoutParams)
        rootView.addView(firstSpace)

        labelTextView = TextView(context)
        labelTextView.textSize = 16f
        labelTextView.gravity = Gravity.CENTER
        labelTextView.typeface = Typeface.DEFAULT_BOLD
        labelTextView.setTextColor(Color.WHITE)
        labelTextView.text = INITIAL_TEXT
        labelTextView.layoutParams = LinearLayout.LayoutParams(visibleChildLayoutParams)
        rootView.addView(labelTextView)

        val secondSpace = Space(context)
        secondSpace.layoutParams = LinearLayout.LayoutParams(spaceLayoutParams)
        rootView.addView(secondSpace)

        val cancelDescTextView = TextView(context)
        cancelDescTextView.textSize = 14f
        cancelDescTextView.gravity = Gravity.CENTER
        cancelDescTextView.typeface = Typeface.DEFAULT
        cancelDescTextView.setTextColor(Color.WHITE)
        cancelDescTextView.text = INTERRUPT_WARNING_TEXT.toHtmlSpan()
        cancelDescTextView.layoutParams = LinearLayout.LayoutParams(visibleChildLayoutParams)
        rootView.addView(cancelDescTextView)
    }

    fun updateLabel(labelText: String) {
        rootView.post { labelTextView.text = labelText }
    }
}