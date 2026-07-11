package com.example.injusticearchive

import java.time.LocalDateTime
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale


fun getCurrentOnlineBattle(now: LocalDateTime): OnlineBattleRotation {
    val anchorIndex = 27
    val anchorStart = LocalDateTime.of(2026, 6, 24, 18, 0)

    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val weeksSinceAnchor = hoursSinceAnchor / 168

    val currentIndex = (anchorIndex + weeksSinceAnchor).toInt() % onlineBattleSchedule.size

    return onlineBattleSchedule[currentIndex]

}

fun onlineBattleDateRange(index: Int): String {
    val anchorIndex = 27
    val anchorStart = LocalDateTime.of(2026,6,25, 18,0)
    val weeksFromAnchor = index - anchorIndex
    val start = anchorStart.plusWeeks(weeksFromAnchor.toLong())
    val end = start.plusDays(7).minusMinutes(1)
    val startMonth = start.month.getDisplayName(TextStyle.FULL, Locale.US)
    val endMonth = end.month.getDisplayName(TextStyle.FULL, Locale.US)

    if (start.year == end.year) {
        return "${startMonth} ${start.dayOfMonth} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    } else {
        return "${startMonth} ${start.dayOfMonth} ${start.year} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    }
}

fun onlineBattleDateRangeFromOffset(offset: Int): String {
    val anchorStart = LocalDateTime.of(2026, 6, 25, 18, 0)
    val now = LocalDateTime.now()
    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val weeksSinceAnchor = hoursSinceAnchor / 168

    val start = anchorStart.plusWeeks(weeksSinceAnchor + offset)
    val end = start.plusDays(7).minusMinutes(1)
    val startMonth = start.month.getDisplayName(TextStyle.FULL, Locale.US)
    val endMonth = end.month.getDisplayName(TextStyle.FULL, Locale.US)


    if (start.year == end.year) {
        return "${startMonth} ${start.dayOfMonth} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    } else {
        return "${startMonth} ${start.dayOfMonth} ${start.year} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    }
}