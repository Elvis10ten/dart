package com.fluentbuild.apollo.presentation

import android.content.Context

interface RuntimeSwitch {

    fun startup(context: Context)

    fun shutdown(context: Context)
}
