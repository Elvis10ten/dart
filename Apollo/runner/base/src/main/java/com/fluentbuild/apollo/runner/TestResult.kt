package com.fluentbuild.apollo.runner

import android.os.Parcel
import android.os.Parcelable

data class TestResult(
    val runtime: Long,
    val ignoreCount: Int,
    val failures: List<TestFailure>
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readInt(),
        parcel.createTypedArrayList(TestFailure)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(runtime)
        parcel.writeInt(ignoreCount)
        parcel.writeTypedList(failures)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestResult> {
        override fun createFromParcel(parcel: Parcel): TestResult {
            return TestResult(parcel)
        }

        override fun newArray(size: Int): Array<TestResult?> {
            return arrayOfNulls(size)
        }
    }
}
