package com.fluentbuild.workserver.work.store

import com.fluentbuild.apollo.work.DevicePropertiesProto.DeviceProperties
import com.fluentbuild.apollo.work.WorkProto.Work

interface WorkStore {

    fun upsertWorkDevices(workKey: String, devices: List<DeviceProperties>)

    fun deleteWorkDevices(workKey: String, devices: List<DeviceProperties>)

    fun getWorkDevices(workKey: String): List<DeviceProperties>

    fun upsertWork(work: Work)

    fun deleteWork(work: Work)

    fun getWork(workKey: String): Work

    fun getAvailableWork(): Work?
}

