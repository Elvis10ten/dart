package com.fluentbuild.workserver

import com.fluentbuild.workserver.work.wire.WorkService
import io.grpc.Server
import io.grpc.ServerBuilder
import org.tukaani.xz.LZMA2Options
import org.tukaani.xz.XZOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


object Main {

    @JvmStatic
    fun main(vararg args: String) {
        println(Injector.baseDir.absolutePath)
        /*Injector.dbModule.getSchema().drop()
        Injector.dbModule.getSchema().create()*/

        //Injector.workStore.upsertWork(DummyWorkProvider.getAssignedWork2())
        Injector.workStore.upsertWork(DummyWorkProvider.getAssignedWork1())

        Thread(Runnable {
            while(true) {
                Thread.sleep(2000)
                if(Injector.workStore.workList.isEmpty()) {
                    //Injector.workStore.upsertWork(DummyWorkProvider.getAssignedWork2())
                    Injector.workStore.upsertWork(DummyWorkProvider.getAssignedWork1())
                }
            }
        }).start()
        val server: Server = ServerBuilder.forPort(5050)
            .addService(Injector.workModule.getWorkService())
            .build()

        server.start()
        println("Server started!!!")
        server.awaitTermination()
    }
}