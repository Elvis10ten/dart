package com.fluentbuild.apollo.foundation

import android.os.Bundle

fun Map<String, String>.toBundle(): Bundle {
    return Bundle().apply {
        for((key, value) in this@toBundle) {
            putString(key, value)
        }
    }
}
