package com.fluentbuild.workserver

import com.fluentbuild.apollo.measurement.StatsFrameProto
import com.google.protobuf.util.JsonFormat
import java.io.File
import java.nio.ByteBuffer

object Test {

    @JvmStatic
    fun main(vararg args: String) {
        /*val file = File(Injector.baseDir, "89fe4890-3289-4186-a214-c082b6192ff7/stash")
        file.listFiles { file -> file.extension == "s" }.forEach { file ->
            //println(file)
        }*/

        val stream = javaClass.classLoader.getResourceAsStream("stats.s")!!

        var frame = StatsFrameProto.StatsFrame.parseDelimitedFrom(stream)

        val totalFrameBuilder = StatsFrameProto.StatsFrame.newBuilder()

        while(frame != null) {
            totalFrameBuilder.mergeFrom(frame)
            frame = StatsFrameProto.StatsFrame.parseDelimitedFrom(stream)
        }

        val totalFrame = totalFrameBuilder.build()
        val json = JsonFormat.printer().print(totalFrame)
        println(json)

        File(Injector.baseDir, "json.json").outputStream().bufferedWriter().apply {
            write(json)
            flush()
        }
    }
}