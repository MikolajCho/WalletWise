package com.example.walletwise.utils

import java.text.NumberFormat
import java.util.Locale

object CurrencyFormatter {
    private val format = NumberFormat.getCurrencyInstance(Locale("pl", "PL"))

    fun format(amount: Double): String = format.format(amount)

    fun formatShort(amount: Double): String = "%.2f PLN".format(amount)
}
