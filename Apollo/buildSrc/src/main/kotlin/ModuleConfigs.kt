import org.gradle.api.JavaVersion
import java.io.File

object ModuleConfigs {

    const val APPLICATION_ID = "com.fluentbuild.apollo"

    // Supported Java Version
    val JAVA_VERSION = JavaVersion.VERSION_1_8

    // Supported Android SDKs
    const val COMPILE_SDK_VERSION = 29
    const val BUILD_TOOLS_VERSION = "29.0.2"
    const val TARGET_SDK_VERSION = 29
    const val MINIMUM_SDK_VERSION = 21

    fun getGrpcScriptPath(rootDir: File): String {
        return "${rootDir.absolutePath}/grpc.gradle"
    }
}
