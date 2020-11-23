package com.fluentbuild.apollo.measurement

import android.content.Context
import android.os.SystemClock
import com.fluentbuild.apollo.foundation.android.AndroidVersion
import com.fluentbuild.apollo.foundation.android.LogWrapper
import com.fluentbuild.apollo.measurement.memory.MemoryStatsProvider
import com.fluentbuild.apollo.measurement.memory.StorageStatsProvider
import com.fluentbuild.apollo.measurement.StatsFrameProto.*
import com.fluentbuild.apollo.measurement.device.FileIoStatsProvider
import com.fluentbuild.apollo.measurement.device.NetworkStatsProvider
import com.fluentbuild.apollo.measurement.process.*
import java.io.IOException
import java.io.OutputStream

private const val LOG_TAG = "StatsFrameWrapper"

class StatsFrameWrapper(
    appContext: Context,
    private val logWrapper: LogWrapper
) {

    private val memoryStatsProvider = MemoryStatsProvider(appContext)
    private val storageStatsProvider = StorageStatsProvider(appContext)
    private val gcStatsProvider = GcStatsProvider()

    private val processStatsProvider = JavaProcessStatsProvider()
    private val vmPropsStatsProvider = VmPropsStatsProvider()
    private val threadStatsProvider = ThreadStatsProvider()
    private val binderStatsProvider = BinderStatsProvider()

    private val unixProcessStatsProvider = UnixProcessStatsProvider()
    private val resourceUsageStatsProvider = ResourceUsageStatsProvider(appContext)
    private val fileIoStatsProvider = FileIoStatsProvider()
    private val networkStatsProvider = NetworkStatsProvider()

    private lateinit var vitalsBuilder: StatsFrame.Builder
    private var referenceTime = -1L

    fun setStartValues(uid: Int, pid: Int) {
        vitalsBuilder.vmPropsStats = vmPropsStatsProvider.getStats()
        vitalsBuilder.processStats = processStatsProvider.getStats()
        vitalsBuilder.startStorageStats = storageStatsProvider.getStats()
        loadAllNow(uid, pid)
    }

    fun setEndValues(uid: Int, pid: Int) {
        vitalsBuilder.endStorageStats = storageStatsProvider.getStats()
        loadAllNow(uid, pid)
    }

    private fun loadAllNow(uid: Int, pid: Int) {
        loadMemoryStats()
        loadGcStats()
        loadThreadStats()
        loadBinderStats()
        loadUnixProcessStats(pid)
        loadFileIoStats(pid)
        loadNetworkStats(uid)

        if(AndroidVersion.isAtLeastNougat()) {
            loadResourceUsageStats()
        }
    }

    fun getRelativeTime(): Int = (SystemClock.elapsedRealtime() - referenceTime).toInt()

    fun addFrameStats(frameStats: FrameStatsProto.FrameStats) {
        vitalsBuilder.addFrameStats(frameStats)
    }

    fun addAppStats(appStats: ApplicationStatsProto.ApplicationStats) {
        vitalsBuilder.addApplicationStats(appStats)
    }

    fun addActivityStats(activityStats: ActivityStatsProto.ActivityStats) {
        vitalsBuilder.addActivityStats(activityStats)
    }

    fun loadBinderStats() {
        vitalsBuilder.addBinderStats(binderStatsProvider.getStats(getRelativeTime()))
    }

    fun loadGcStats() {
        vitalsBuilder.addGcStats(gcStatsProvider.getStats(getRelativeTime()))
    }

    fun loadThreadStats() {
        vitalsBuilder.addThreadStats(threadStatsProvider.getStats(getRelativeTime()))
    }

    fun loadMemoryStats() {
        vitalsBuilder.addMemoryStats(memoryStatsProvider.getStats(getRelativeTime()))
    }

    fun loadUnixProcessStats(pid: Int) {
        try {
            val stats = unixProcessStatsProvider.getStats(pid, getRelativeTime())
            vitalsBuilder.addUnixProcessStats(stats)
        } catch (e: Exception) {
            logWrapper.e(LOG_TAG, e, "Error getting unix process stats")
        }
    }

    fun loadFileIoStats(pid: Int) {
        try {
            vitalsBuilder.addFileIoStats(fileIoStatsProvider.getStats(pid, getRelativeTime()))
        } catch (e: Exception) {
            logWrapper.e(LOG_TAG, e, "Error getting file io stats")
        }
    }

    fun loadNetworkStats(uid: Int) {
        vitalsBuilder.addNetworkStats(networkStatsProvider.getStats(uid, getRelativeTime()))
    }

    fun loadResourceUsageStats() {
        if(AndroidVersion.isAtLeastNougat()) {
            vitalsBuilder.addResourceUsageStats(resourceUsageStatsProvider.getStats(getRelativeTime()))
        }
    }

    fun reset() {
        vitalsBuilder = StatsFrame.newBuilder()
        referenceTime = SystemClock.elapsedRealtime()
    }

    @Throws(IOException::class)
    fun writeTo(outputStream: OutputStream) {
        val frame = vitalsBuilder.build()
        frame.writeDelimitedTo(outputStream)
    }
}