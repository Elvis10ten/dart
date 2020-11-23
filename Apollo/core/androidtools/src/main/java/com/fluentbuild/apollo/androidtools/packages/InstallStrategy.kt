package com.fluentbuild.apollo.androidtools.packages

import java.io.File
import kotlin.RuntimeException

interface InstallStrategy {

    fun install(appFile: File)

    fun uninstall()

    fun dispose()

    interface Callback {

        fun onCompleted()

        fun onError(error: Throwable)
    }

    abstract class InstallException(message: String? = null): RuntimeException(message)
    
    /**
     * The operation failed in a generic way. The system will always try to
     * provide a more specific failure reason, but in some rare cases this may
     * be delivered.
     */
    class GenericException(message: String? = null): InstallException(message)

    /**
     * The operation failed because it was blocked. For example, a device policy
     * may be blocking the operation, a package verifier may have blocked the
     * operation, or the app may be required for core system operation.
     * <p>
     * The result may also contain {@link #EXTRA_OTHER_PACKAGE_NAME} with the
     * specific package blocking the install.
     */
    class BlockedException(
        blockingPackageName: String?
    ): InstallException("Install blocked by $blockingPackageName")

    /**
     * The operation failed because it was actively aborted. For example, the
     * user actively declined requested permissions, or the session was
     * abandoned.
     */
    class AbortedException: InstallException()

    /**
     * The operation failed because one or more of the APKs was invalid. For
     * example, they might be malformed, corrupt, incorrectly signed,
     * mismatched, etc.
     *
     * @see #EXTRA_STATUS_MESSAGE
     */
    class InvalidException: InstallException()

    /**
     * The operation failed because it conflicts (or is inconsistent with) with
     * another package already installed on the device. For example, an existing
     * permission, incompatible certificates, etc. The user may be able to
     * uninstall another app to fix the issue.
     * <p>
     * The result may also contain {@link #EXTRA_OTHER_PACKAGE_NAME} with the
     * specific package identified as the cause of the conflict.
     */
    class ConflictException: InstallException()

    /**
     * The operation failed because of storage issues. For example, the device
     * may be running low on space, or external media may be unavailable. The
     * user may be able to help free space or insert different external media.
     * <p>
     * The result may also contain {@link #EXTRA_STORAGE_PATH} with the path to
     * the storage device that caused the failure.
     */
    class StorageException: InstallException()

    /**
     * The operation failed because it is fundamentally incompatible with this
     * device. For example, the app may require a hardware feature that doesn't
     * exist, it may be missing native code for the ABIs supported by the
     * device, or it requires a newer SDK version, etc.
     */
    class IncompatibleException: InstallException()

    class TimeoutException(
        timeoutMillis: Long
    ): InstallException("Time out! App install/uninstall took more than ${timeoutMillis}ms")

}