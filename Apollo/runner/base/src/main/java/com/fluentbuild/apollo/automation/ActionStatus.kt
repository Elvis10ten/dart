package com.fluentbuild.apollo.automation

import android.os.Parcel
import android.os.Parcelable
import java.lang.Exception

data class ActionStatus(
    val wasSuccessful: Boolean,
    val errorText: String? = null
): Parcelable {

    fun requireSuccessful(lazyException: () -> Exception) {
        if(!wasSuccessful) {
            throw lazyException()
        }
    }

    // region Parcelable boilerplate
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (wasSuccessful) 1 else 0)
        parcel.writeString(errorText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ActionStatus> {
        override fun createFromParcel(parcel: Parcel): ActionStatus {
            return ActionStatus(parcel)
        }

        override fun newArray(size: Int): Array<ActionStatus?> {
            return arrayOfNulls(size)
        }
    }
    // endregion
}
