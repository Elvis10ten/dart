package com.fluentbuild.apollo.presentation.utils

import android.content.Context
import android.content.Intent
import com.fluentbuild.apollo.presentation.R

object IntentUtils {

    fun emailSupport(appContext: Context) {
        val emailIntent = Intent(Intent.ACTION_SEND)

        emailIntent.type = "plain/text"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "support@fluentbuild.com")
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, appContext.getString(R.string.contactSupportEmailSubject))
        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        appContext.startActivity(emailIntent)
    }
}
