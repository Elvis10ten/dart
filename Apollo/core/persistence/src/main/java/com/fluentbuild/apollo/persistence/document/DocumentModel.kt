package com.fluentbuild.apollo.persistence.document

data class DocumentModel<T>(
    val content: T,
    val size: Long
)
