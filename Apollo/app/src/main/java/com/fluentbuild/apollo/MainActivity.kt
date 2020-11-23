package com.fluentbuild.apollo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fluentbuild.apollo.androidtools.notifications.DndPermission
import com.fluentbuild.apollo.presentation.Navigator
import com.fluentbuild.apollo.presentation.splash.SplashHost
import com.fluentbuild.apollo.setup.ComponentInjector
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navigator: Navigator
    lateinit var splashHostProvider: () -> SplashHost

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentInjector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        navigator.onStart(hostContainer)
        if(navigator.isBackStackEmpty()) {
            navigator.goto(splashHostProvider.invoke())
        }
    }

    override fun onStop() {
        navigator.onStop()
        super.onStop()
    }

    override fun onBackPressed() {
        if(!navigator.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(!navigator.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
