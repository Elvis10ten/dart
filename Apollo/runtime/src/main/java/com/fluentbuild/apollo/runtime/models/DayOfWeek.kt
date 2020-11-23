package com.fluentbuild.apollo.runtime.models

enum class DayOfWeek(val numericValue: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    companion object {

        fun of(numericValue: Int): DayOfWeek {
            return values().first { it.numericValue == numericValue }
        }
    }
}