package com.fluentbuild.apollo.runner

import android.os.Parcel
import android.os.Parcelable

data class TestDescription(
    val className: String,
    val methodName: String?,
    val displayName: String
): Parcelable {

    fun getFullName() = "${className}#${methodName}"

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(className)
        parcel.writeString(methodName)
        parcel.writeString(displayName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestDescription> {
        override fun createFromParcel(parcel: Parcel): TestDescription {
            return TestDescription(parcel)
        }

        override fun newArray(size: Int): Array<TestDescription?> {
            return arrayOfNulls(size)
        }
    }

}
