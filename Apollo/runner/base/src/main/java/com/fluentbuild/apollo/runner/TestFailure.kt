package com.fluentbuild.apollo.runner

import android.os.Parcel
import android.os.Parcelable

data class TestFailure constructor(
    val description: TestDescription,
    val trace: String
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(TestDescription::class.java.classLoader)!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(description, flags)
        parcel.writeString(trace)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestFailure> {
        override fun createFromParcel(parcel: Parcel): TestFailure {
            return TestFailure(parcel)
        }

        override fun newArray(size: Int): Array<TestFailure?> {
            return arrayOfNulls(size)
        }
    }
}
