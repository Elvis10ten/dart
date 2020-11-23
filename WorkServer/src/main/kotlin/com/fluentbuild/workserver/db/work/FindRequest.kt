package com.fluentbuild.workserver.db.work

import com.fluentbuild.apollo.work.DevicePropertiesProto

data class FindRequest(
    val deviceProperties: DevicePropertiesProto.DeviceProperties
)