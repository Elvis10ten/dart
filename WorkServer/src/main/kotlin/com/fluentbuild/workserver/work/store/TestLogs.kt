package com.fluentbuild.workserver.work.store

data class TestLogs(
    val lines: List<String>,
    val nextOffset: Int
)