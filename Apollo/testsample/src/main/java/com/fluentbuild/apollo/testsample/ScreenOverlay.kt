package com.fluentbuild.apollo.testsample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView

@SuppressLint("SetTextI18n")
class ScreenOverlay(
    private val context: Context,
    private val consumer: Consumer
) {

    internal val rootView: LinearLayout = LinearLayout(context)
    private val labelTextView: TextView

    init {
        rootView.id = View.generateViewId()
        rootView.tag = "dart"
        rootView.orientation = LinearLayout.VERTICAL
        rootView.setBackgroundResource(R.drawable.image)
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
        labelTextView.text = "Setting up!"
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
        cancelDescTextView.text =
            "You can stop execution from the notification panel.\nNote: You won't earn any money if you cancel now."
        cancelDescTextView.layoutParams = LinearLayout.LayoutParams(visibleChildLayoutParams)
        rootView.addView(cancelDescTextView)

        rootView.setOnTouchListener { v, event ->
            Log.e("dart", "touched: " + event.deviceId)
            false
        }
        attachListeners()
    }

    private fun attachListeners() {
        consumer.setLabelUpdater { label ->
            rootView.post { labelTextView.text = label }
        }
    }

    internal fun detachListeners() {
        consumer.setLabelUpdater(null)
    }

    interface Consumer {

        fun setLabelUpdater(labelUpdater: ((String) -> Unit)? = null)
    }
}