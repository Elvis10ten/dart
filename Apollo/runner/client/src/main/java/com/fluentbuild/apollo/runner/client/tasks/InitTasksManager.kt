package com.fluentbuild.apollo.runner.client.tasks

import android.content.Context
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.runner.client.TestConfigs

private const val LOG_TAG = "InitTasksManager"

class InitTasksManager(
    private val targetContext: Context,
    private val testConfigs: TestConfigs,
    private val logWrapper: LogWrapper
) {

    fun run() {
        if(testConfigs.isClearDataEnabled()) {
            run(ClearDataTask(targetContext, logWrapper))
        }
    }

    private fun run(task: Task) {
        try {
            task.run()
        } catch (e: Exception) {
            if(task.isCritical()) {
                throw e
            } else {
                logWrapper.e(LOG_TAG, e, "Ignoring none critical task exception")
            }
        }
    }
}