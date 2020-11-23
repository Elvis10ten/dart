package com.fluentbuild.apollo.views.utils

import android.graphics.drawable.Drawable
import android.text.format.DateUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.fluentbuild.apollo.foundation.android.toHtmlSpan
import com.fluentbuild.apollo.views.models.UiState
import com.google.android.material.textfield.TextInputLayout
import com.hbb20.CountryCodePicker
import com.squareup.picasso.Picasso


@BindingAdapter("profilePhotoUrl", "placeholder")
fun ImageView.loadProfilePhoto(photoUrl: String?, placeholder: Drawable) {
    Picasso.get()
        .load(photoUrl)
        .placeholder(placeholder)
        .transform(CropCircleTransformation())
        .into(this)
}

@BindingAdapter("visible")
fun View.setVisible(isVisible: Boolean) {
    visibility = if(isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@BindingAdapter("html")
fun TextView.setHtmlText(text: String) {
    setText(text.toHtmlSpan())
}

@BindingAdapter("htmlList")
fun TextView.setHtmlTexts(texts: List<String>) {
    val html = texts.joinToString("<br/>")
    setHtmlText(html)
}

@BindingAdapter("timeAgo")
fun TextView.setTimeAgo(timestamp: Long) {
    text = DateUtils.getRelativeTimeSpanString(timestamp, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS)
}

@BindingAdapter("android:src")
fun ImageView.setImageRes(@DrawableRes imageRes: Int) {
    setImageResource(imageRes)
}

@BindingAdapter("android:background")
fun View.setBackgroundRes(@DrawableRes backgroundRes: Int) {
    setBackgroundResource(backgroundRes)
}

@BindingAdapter("showInputError")
fun TextInputLayout.showInputError(errorText: String?) {
    error = errorText
}

@BindingAdapter("phoneNumber")
fun CountryCodePicker.setPhoneNumber(phoneNumber: String?) {
    if(phoneNumber != null) {
        fullNumber = phoneNumber
    }
}

@BindingAdapter("showUiErrorMessage")
fun TextView.showUiErrorMessage(uiState: UiState?) {
    if(uiState is UiState.Error) {
        text = uiState.message
    }
}
