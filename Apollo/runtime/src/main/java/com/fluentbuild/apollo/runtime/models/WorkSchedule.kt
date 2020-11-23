package com.fluentbuild.apollo.runtime.models

import java.util.*

data class WorkSchedule(
    val daysOfWeek: Set<DayOfWeek> = emptySet(),
    val hours: Set<Hour> = emptySet(),
    val minutes: Set<Minute> = emptySet()
) {

    fun isAllowed(currentCalendar: Calendar): Boolean {
        val currentDayOfWeek = currentCalendar.get(Calendar.DAY_OF_WEEK)
        val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = currentCalendar.get(Calendar.MINUTE)

        if(daysOfWeek.isNotEmpty()) {
            if(!daysOfWeek.contains(DayOfWeek.of(currentDayOfWeek))) return false
        }

        if(hours.isNotEmpty()) {
            if(!hours.contains(Hour(currentHour))) return false
        }

        if(minutes.isNotEmpty()) {
            if(!minutes.contains(Minute(currentMinute))) return false
        }

        return true
    }
}