package com.fluentbuild.apollo.automation

enum class PermissionAction(
    val id: Int
) {
    GRANT(0),
    GRANT_FOREGROUND_ONLY(1),
    DENY(2),
    DENY_FOREVER(3);

    companion object {

        fun of(id: Int) {
            values().first { it.id == id }
        }
    }
}