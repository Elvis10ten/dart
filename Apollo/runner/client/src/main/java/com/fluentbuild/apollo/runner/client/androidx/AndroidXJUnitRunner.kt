package com.fluentbuild.apollo.runner.client.androidx

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import androidx.test.runner.AndroidJUnitRunner
import com.fluentbuild.apollo.foundation.android.LogWrapper

open class AndroidXJUnitRunner: AndroidJUnitRunner() {

    private lateinit var helper: RunnerHelper

    override fun onCreate(arguments: Bundle) {
        helper = RunnerHelper(this, getLogWrapper())
        helper.onCreate(arguments)
        super.onCreate(arguments)
    }

    open fun getLogWrapper() = LogWrapper(true)

    override fun onStart() {
        helper.onStart()
        super.onStart()
    }

    override fun onDestroy() {
        helper.onDestroy()
        super.onDestroy()
    }

    override fun callApplicationOnCreate(app: Application) {
        helper.onCallApplicationOnCreate(app) {
            super.callApplicationOnCreate(app)
        }
    }

    override fun callActivityOnCreate(activity: Activity, bundle: Bundle?) {
        helper.onCallActivityOnCreate(activity, bundle) {
            super.callActivityOnCreate(activity, bundle)
        }
    }

    override fun callActivityOnCreate(
        activity: Activity,
        bundle: Bundle?,
        persistableBundle: PersistableBundle
    ) {
        helper.onCallActivityOnCreate(activity, bundle, persistableBundle) {
            super.callActivityOnCreate(activity, bundle, persistableBundle)
        }
    }

    override fun callActivityOnStart(activity: Activity) {
        helper.onCallActivityOnStart(activity) {
            super.callActivityOnStart(activity)
        }
    }

    override fun callActivityOnResume(activity: Activity) {
        helper.onCallActivityOnResume(activity) {
            super.callActivityOnResume(activity)
        }
    }

    override fun callActivityOnPause(activity: Activity) {
        helper.onCallActivityOnPause(activity) {
            super.callActivityOnPause(activity)
        }
    }

    override fun callActivityOnStop(activity: Activity) {
        helper.onCallActivityOnStop(activity) {
            super.callActivityOnStop(activity)
        }
    }

    override fun callActivityOnRestart(activity: Activity) {
        helper.onCallActivityOnRestart(activity) {
            super.callActivityOnRestart(activity)
        }
    }

    override fun callActivityOnDestroy(activity: Activity) {
        helper.onCallActivityOnDestroy(activity) {
            super.callActivityOnDestroy(activity)
        }
    }
}
