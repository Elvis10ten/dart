package com.fluentbuild.apollo.views.utils

import com.fluentbuild.apollo.auth.Money
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class MoneyFormatter(locale: Locale) {

    private val decimalFormat = NumberFormat.getInstance(locale) as DecimalFormat

    init {
        decimalFormat.applyPattern("#.###")
        decimalFormat.isGroupingUsed = true
        decimalFormat.groupingSize = 3
    }

    fun format(money: Money): String {
        return money.currencySymbol + decimalFormat.format(money.amount)
    }
}
