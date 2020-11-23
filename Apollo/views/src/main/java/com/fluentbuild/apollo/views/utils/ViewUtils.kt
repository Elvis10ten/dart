package com.fluentbuild.apollo.views.utils

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.text.method.LinkMovementMethod
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

internal fun FloatingActionButton.changeBackgroundColor(@ColorRes colorFromRes: Int, @ColorRes colorToRes: Int): ValueAnimator {
    val colorFrom = ContextCompat.getColor(context, colorFromRes)
    val colorTo = ContextCompat.getColor(context, colorToRes)

    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo).apply {
        duration = context.resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
    }

    colorAnimation.addUpdateListener { animator ->
        backgroundTintList = ColorStateList.valueOf(animator.animatedValue as Int)
    }

    colorAnimation.start()
    return colorAnimation
}

fun TextView.showLinks() {
    movementMethod = LinkMovementMethod.getInstance()
}

internal fun View.addSingleGlobalLayoutListener(callback: () -> Unit): ViewTreeObserver.OnGlobalLayoutListener {
    return viewTreeObserver.let {
        val listener = object: ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                callback()
            }
        }

        it.addOnGlobalLayoutListener(listener)
        listener
    }
}
