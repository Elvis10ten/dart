package com.fluentbuild.workserver.work.artifacts

import com.fluentbuild.apollo.work.tests.ArtifactProto.*
import com.fluentbuild.apollo.work.tests.AtomicResultProto.*
import com.fluentbuild.workserver.utils.autoClose
import com.fluentbuild.workserver.work.store.DeviceWorkQuery
import java.io.File
import java.io.InputStream

private const val SCREEN_RECORD_FILE = "screen_record.mp4"
private val TYPES_IMAGES = arrayOf("webp", "png", "jpg")
private val TYPES_TEXT = arrayOf("txt", "l")
private val TYPES_VIDEOS = arrayOf("mp4", "3gp")
private val TYPES_ARCHIVE = arrayOf("zip")

class FileArtifactStore(
    private val baseDir: File
): ArtifactStore {

    override fun add(query: DeviceWorkQuery, result: AtomicResult, artifactEntries: ArtifactEntries) {
        artifactEntries.readEntries { entry, inputStream ->
            val destFile = File(getArtifactDir(query), entry.name)

            destFile.outputStream().autoClose { fileOutputStream ->
                if(entry.name == result.profileFileName) {
                    StatsFrameCopier.copy(inputStream, fileOutputStream)
                } else if(entry.name.startsWith(result.autoScreenShotNamePrefix)) {
                    inputStream.copyTo(fileOutputStream)
                }
                // todo: copy other file types

                fileOutputStream.flush()
            }
        }
    }

    override fun openArtifact(
        query: DeviceWorkQuery,
        artifactName: String,
        result: AtomicResult,
        range: IntRange?
    ): InputStream {
        val artifact = File(getArtifactDir(query), artifactName)
        // todo: use range
        return artifact.inputStream()
    }

    override fun listResultArtifacts(query: DeviceWorkQuery, result: AtomicResult): ResultArtifacts {
        val artifactDir = getArtifactDir(query)
        val screenshots = mutableListOf<Artifact>()
        val others = mutableListOf<Artifact>()
        val video = File(artifactDir, SCREEN_RECORD_FILE).createArtifact()

        artifactDir.listFiles()?.map { file ->
            if(file.name.startsWith(result.autoScreenShotNamePrefix)) {
                screenshots += file.createArtifact()
            } else if(file.name != SCREEN_RECORD_FILE) {
                others += file.createArtifact()
            }
        }

        return ResultArtifacts(screenshots, video, others)
    }

    private fun getArtifactDir(query: DeviceWorkQuery): File {
        val dirName = query.workKey + File.separator + query.deviceKey + File.separator
        return File(baseDir, dirName).apply { mkdirs() }
    }
}

private fun File.createArtifact(): Artifact {
    return Artifact.newBuilder()
        .setName(name)
        .setSizeBytes(length())
        .setType(getArtifactType())
        .setUrl(absolutePath) // todo
        .build()
}

private fun File.getArtifactType(): ArtifactType {
    val fileExtension = extension

    return when {
        TYPES_IMAGES.contains(fileExtension) -> {
            ArtifactType.IMAGE
        }
        TYPES_VIDEOS.contains(fileExtension) -> {
            ArtifactType.VIDEO
        }
        TYPES_ARCHIVE.contains(fileExtension) -> {
            ArtifactType.ARCHIVE
        }
        TYPES_TEXT.contains(fileExtension) -> {
            ArtifactType.TEXT
        }
        else -> {
            ArtifactType.OTHER
        }
    }
}