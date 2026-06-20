package com.example.walletwise.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private val displayFormat = SimpleDateFormat("dd MMM yyyy", Locale("pl", "PL"))
    private val monthFormat = SimpleDateFormat("LLLL yyyy", Locale("pl", "PL"))

    fun formatDate(timestamp: Long): String = displayFormat.format(Date(timestamp))

    fun formatMonth(year: Int, month: Int): String {
        val cal = Calendar.getInstance()
        cal.set(year, month, 1)
        return monthFormat.format(cal.time).replaceFirstChar { it.uppercase() }
    }

    fun getMonthRange(year: Int, month: Int): Pair<Long, Long> {
        val start = Calendar.getInstance().apply {
            set(year, month, 1, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val end = Calendar.getInstance().apply {
            set(year, month, 1, 0, 0, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.MONTH, 1)
        }.timeInMillis - 1

        return Pair(start, end)
    }

    fun currentYear(): Int = Calendar.getInstance().get(Calendar.YEAR)
    fun currentMonth(): Int = Calendar.getInstance().get(Calendar.MONTH)

    // Obliczanie milisekund do godziny 20:00 (dla powiadomień)
    fun msUntil20h(): Long {
        val now = Calendar.getInstance()
        val target = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 20)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (target.before(now)) target.add(Calendar.DAY_OF_YEAR, 1)
        return target.timeInMillis - now.timeInMillis
    }
}
