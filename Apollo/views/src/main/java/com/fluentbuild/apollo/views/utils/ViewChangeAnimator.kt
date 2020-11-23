package com.fluentbuild.apollo.views.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

open class ViewChangeAnimator(
    private val view: View,
    private val hasContentAlready: () -> Boolean,
    private val changeContent: () -> Unit
) {

    private var isCancelled = false
    private var inAnimation: Animation? = null
    private var outAnimation: Animation? = null

    fun animate(): ViewChangeAnimator {
        if(!hasContentAlready()) {
            changeContent()
            return this
        }

        val inAnimation = AnimationUtils.loadAnimation(view.context, android.R.anim.fade_in)
        val outAnimation = AnimationUtils.loadAnimation(view.context, android.R.anim.fade_out)

        outAnimation.setAnimationListener(object: SimpleAnimationListener() {

            override fun onAnimationEnd(animation: Animation) {
                if(!isCancelled) {
                    changeContent()
                    view.startAnimation(inAnimation)
                }
            }
        })

        if(!isCancelled) {
            this.inAnimation = inAnimation
            this.outAnimation = outAnimation
            view.startAnimation(outAnimation)
        }

        return this
    }

    fun cancel() {
        isCancelled = false
        inAnimation?.cancel()
        outAnimation?.cancel()
        inAnimation = null
        outAnimation = null
    }
}

class TextViewChangeAnimator(
    textView: TextView,
    text: String
): ViewChangeAnimator(
    textView,
    { textView.text?.isNotBlank() == true },
    { textView.text = text }
)

class ImageViewChangeAnimator(
    imageView: ImageView,
    drawable: Drawable
): ViewChangeAnimator(
    imageView,
    { imageView.drawable != null },
    { imageView.setImageDrawable(drawable) }
)

fun ImageView.animateDrawableIn(@DrawableRes drawableRes: Int): ImageViewChangeAnimator {
    return ImageViewChangeAnimator(this, ContextCompat.getDrawable(context, drawableRes)!!)
}

fun TextView.animateTextIn(text: String): TextViewChangeAnimator {
    return TextViewChangeAnimator(this, text)
}
