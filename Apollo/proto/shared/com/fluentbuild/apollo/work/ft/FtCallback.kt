package com.fluentbuild.apollo.work.ft

interface FtCallback<R> {

    fun onFtProgressUpdate(curFileIndex: Int, progressPercent: Int, filesCount: Int)

    fun onFtError(throwable: Throwable)

    fun onFtComplete(result: R)
}