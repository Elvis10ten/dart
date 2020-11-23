package com.fluentbuild.apollo.runtime.models

import androidx.annotation.IntRange

data class Hour(
    @IntRange(from = 0, to = 23)
    val militaryHour: Int
) {

    fun getClockHour() = militaryHour % 12
}
