package com.fluentbuild.workserver.work.store

import com.fluentbuild.apollo.work.DevicePropertiesProto.*
import com.fluentbuild.apollo.work.WorkProto.*

class DbWorkStore: WorkStore {

    // TODO: Change Dummy memory db
    // todo: do actual queries
    private val deviceList = mutableMapOf<String, MutableList<DeviceProperties>>()
    val workList = mutableSetOf<Work>()

    override fun upsertWorkDevices(workKey: String, devices: List<DeviceProperties>) {
        val savedDevices = deviceList.getOrPut(workKey, { mutableListOf() })
        savedDevices.addAll(devices)
        deviceList[workKey] = savedDevices
    }

    override fun deleteWorkDevices(workKey: String, devices: List<DeviceProperties>) {
        val savedDevices = deviceList.getOrPut(workKey, { mutableListOf() })
        savedDevices.removeAll(devices)
        deviceList[workKey] = savedDevices
    }

    override fun getWorkDevices(workKey: String): List<DeviceProperties> {
        return deviceList[workKey] ?: emptyList()
    }

    override fun upsertWork(work: Work) {
        workList.add(work)
    }

    override fun deleteWork(work: Work) {
        workList.remove(work)
    }

    override fun getWork(workKey: String): Work {
        return workList.first { it.key == workKey }
    }

    override fun getAvailableWork(): Work? {
        val work = workList.first()
        workList.remove(work)
        return work
    }
}