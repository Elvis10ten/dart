package com.fluentbuild.apollo.measurement.process

import com.fluentbuild.apollo.measurement.ThreadStatsProto.ThreadStats

private const val MAX_THREAD_COUNT = 1000

class ThreadStatsProvider {

    fun getStats(relativeTime: Int): ThreadStats {
        return ThreadStats.newBuilder()
            .addAllThreadsInfo(getThreadsInfo())
            .setRelativeTime(relativeTime)
            .build()
    }

    private fun getThreadsInfo(): List<ThreadStats.ThreadInfo> {
        return getThreads().map { thread ->
            ThreadStats.ThreadInfo.newBuilder()
                .setId(thread.id)
                .setName(thread.name)
                .setPriority(thread.priority)
                .setIsInterrupted(thread.isInterrupted)
                .setIsAlive(thread.isAlive)
                .setIsDaemon(thread.isDaemon)
                .setState(thread.state.toDefinedState())
                .build()
        }
    }

    private fun getThreads(): List<Thread> {
        val rootThreadGroup = getRootThreadGroup() ?: return emptyList()
        var threads = arrayOfNulls<Thread>(rootThreadGroup.activeCount())

        while (rootThreadGroup.enumerate(threads, true) == threads.size) {
            if(threads.size > MAX_THREAD_COUNT) break
            threads = arrayOfNulls(threads.size * 2)
        }

        return threads.filterNotNull()
    }

    private fun getRootThreadGroup(): ThreadGroup? {
        var rootGroup: ThreadGroup? = Thread.currentThread().threadGroup
        var parentGroup: ThreadGroup? = null

        while (rootGroup?.parent?.also { parentGroup = it } != null) {
            rootGroup = parentGroup
        }

        return rootGroup
    }
}

private fun Thread.State.toDefinedState(): ThreadStats.State {
    return when(this) {
        Thread.State.NEW -> ThreadStats.State.NEW
        Thread.State.RUNNABLE -> ThreadStats.State.RUNNABLE
        Thread.State.BLOCKED -> ThreadStats.State.BLOCKED
        Thread.State.WAITING -> ThreadStats.State.WAITING
        Thread.State.TIMED_WAITING -> ThreadStats.State.TIMED_WAITING
        Thread.State.TERMINATED -> ThreadStats.State.TERMINATED
    }
}