package com.fluentbuild.apollo.work

import com.fluentbuild.apollo.foundation.requireDeleteDirectory
import java.io.File
import java.io.IOException

class WorkFiles(
    val remoteStorageDir: File,
    worksDir: File,
    work: WorkProto.Work
) {

    val workDir = File(worksDir, work.packageName).apply { mkdirs() }

    val resultsDir = File(workDir, "rs").apply { mkdirs() }

    /**
     * The APK under test.
     */
    fun getMainApp() = File(workDir, "m.apk")

    /**
     * The APK containing instrumentation tests.
     */
    fun getTestApp() = File(workDir, "t.apk")

    /**
     * The first Android OBB files which will be copied to the test device before the tests will run (default: None).
     * Each OBB file name must conform to the format as specified by Android (e.g. [main|patch].0300110.com.example.android.obb)
     * and will be installed into <shared-storage>/Android/obb/<package-name>/ on the test device.
     */
    fun getObb1() = File(workDir, "o1.obb")

    /**
     * The second Android OBB files which will be copied to the test device before the tests will run (default: None).
     * Each OBB file name must conform to the format as specified by Android (e.g. [main|patch].0300110.com.example.android.obb)
     * and will be installed into <shared-storage>/Android/obb/<package-name>/ on the test device.
     */
    fun getObb2() = File(workDir, "o2.obb")

    fun getPayloadBundle() = File(workDir, "pl.b")

    fun getResultsBundle() = File(resultsDir, "rb.b")

    fun getRunReportFileName() = "rr.b"

    @Throws(IOException::class)
    fun clear() {
        remoteStorageDir.requireDeleteDirectory()
        workDir.requireDeleteDirectory()
    }
}
