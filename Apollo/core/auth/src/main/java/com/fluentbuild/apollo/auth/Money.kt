package com.fluentbuild.apollo.auth

import java.math.BigDecimal
import java.text.DecimalFormat

data class Money(
    val currencySymbol: String,
    val amount: BigDecimal
)
