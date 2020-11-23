package com.fluentbuild.apollo.views.home

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import com.fluentbuild.apollo.runtime.RuntimeState
import com.fluentbuild.apollo.views.R
import com.github.ybq.android.spinkit.style.RotatingPlane

internal fun RuntimeState.getIconDrawable(context: Context): Drawable {
    return if(this == RuntimeState.Idle) {
        context.getDrawable(R.drawable.ic_play_arrow_black_24)!!
    } else {
        RotatingPlane().apply { start() }
    }
}

@ColorRes
internal fun RuntimeState.getBackgroundColor(): Int {
    return if(this == RuntimeState.Idle) {
        R.color.colorSecondary
    } else {
        R.color.colorDanger
    }
}
