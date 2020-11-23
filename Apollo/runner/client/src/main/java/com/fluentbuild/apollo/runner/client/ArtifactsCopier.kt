package com.fluentbuild.apollo.runner.client

import android.content.Context
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.foundation.autoClose
import com.fluentbuild.apollo.foundation.concatPaths
import com.fluentbuild.apollo.foundation.copyFrom
import java.io.File

private const val LOG_TAG = "ArtifactsCopier"

class ArtifactsCopier(
    private val targetContext: Context,
    private val instrumentationContext: Context,
    private val fileDescriptorProvider: FileDescriptorProvider,
    private val testConfigs: TestConfigs,
    private val logWrapper: LogWrapper
) {

    fun copy() {
        logWrapper.i(LOG_TAG, "Retrieving artifacts")
        if(testConfigs.shouldRetrieveTestFiles()) {
            copyDir("test_files", instrumentationContext.filesDir)
        }

        if(testConfigs.shouldRetrieveAppFiles()) {
            copyDir("app_files", targetContext.filesDir)
        }
    }

    private fun copyDir(pathPrefix: String, baseDir: File) {
        if(!baseDir.exists()) return

        val fileWalker = baseDir.walkBottomUp()
        fileWalker.onFail { file, ioException ->
            logWrapper.e(LOG_TAG, ioException,"Unable to get dir($file) file list")
        }

        for(artifact in fileWalker) {
            if(!artifact.exists() || artifact.isDirectory) continue
            logWrapper.i(LOG_TAG, "Copying artifact: $artifact")

            try {
                val relPath = pathPrefix.concatPaths(artifact.toRelativeString(baseDir))
                fileDescriptorProvider.getWritableDescriptor(relPath).autoClose {
                    it.copyFrom(artifact)
                }
            } catch (e: Exception) {
                logWrapper.e(LOG_TAG, e,"Failed to copy artifact")
            }
        }
    }
}