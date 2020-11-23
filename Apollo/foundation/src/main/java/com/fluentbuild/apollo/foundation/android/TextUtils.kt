package com.fluentbuild.apollo.foundation.android

import android.text.Html
import android.text.Spanned

fun String.toHtmlSpan(): Spanned {
    return if (AndroidVersion.isAtLeastNougat()) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        Html.fromHtml(this)
    }
}
