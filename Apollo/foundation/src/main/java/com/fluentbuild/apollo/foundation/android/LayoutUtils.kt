package com.fluentbuild.apollo.foundation.android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

fun Context.getLayoutInflater() =
    LayoutInflater.from(this) as LayoutInflater

fun LayoutInflater.inflate(@LayoutRes layoutRes: Int) =
    inflate(layoutRes, null, false) as View