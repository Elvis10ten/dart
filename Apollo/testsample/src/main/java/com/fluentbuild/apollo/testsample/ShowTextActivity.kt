package com.fluentbuild.apollo.testsample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

/**
 * A simple [Activity] that shows a message.
 */
class ShowTextActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)
        // Get the message from the Intent.
        val intent = intent
        val message =
            intent.getStringExtra(KEY_EXTRA_MESSAGE)
        // Show message.
        (findViewById<View>(R.id.show_text_view) as TextView).text = message
    }

    companion object {
        // The name of the extra data sent through an {@link Intent}.
        const val KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE"

        /**
         * Creates an [Intent] for [ShowTextActivity] with the message to be displayed.
         * @param context the [Context] where the [Intent] will be used
         * @param message a [String] with text to be displayed
         * @return an [Intent] used to start [ShowTextActivity]
         */
        fun newStartIntent(
            context: Context?,
            message: String?
        ): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}