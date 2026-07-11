package com.example.injusticearchive

import java.time.LocalDateTime
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale


fun getCurrentSurvivor(now: LocalDateTime): SurvivorRotation {
    val anchorIndex = 0
    val anchorStart = LocalDateTime.of(2026, 6, 24, 18, 0)

    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val weeksSinceAnchor = hoursSinceAnchor / 336

    val currentIndex = (anchorIndex + weeksSinceAnchor).toInt() % survivorSchedule.size

    return survivorSchedule[currentIndex]

}


fun survivorDateRange(index: Int): String {
    val anchorIndex = 0
    val anchorStart = LocalDateTime.of(2026,6,24, 18,0)
    val weeksFromAnchor = index - anchorIndex
    val start = anchorStart.plusWeeks((weeksFromAnchor * 2).toLong())
    val end = start.plusDays(14).minusMinutes(1)
    val startMonth = start.month.getDisplayName(TextStyle.FULL, Locale.US)
    val endMonth = end.month.getDisplayName(TextStyle.FULL, Locale.US)

    if (start.year == end.year) {
        return "${startMonth} ${start.dayOfMonth} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    } else {
        return "${startMonth} ${start.dayOfMonth} ${start.year} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    }
}