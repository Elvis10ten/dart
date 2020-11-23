package com.fluentbuild.apollo.views.utils

import android.view.animation.Animation

abstract class SimpleAnimationListener: Animation.AnimationListener {

    override fun onAnimationRepeat(animation: Animation) {}

    override fun onAnimationEnd(animation: Animation) {}

    override fun onAnimationStart(animation: Animation) {}
}
