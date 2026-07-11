package com.example.injusticearchive

import java.time.LocalDateTime
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale


fun getCurrentPhantomZone(now: LocalDateTime): PhantomZoneRotation {
    val anchorIndex = 0
    val anchorStart = LocalDateTime.of(2026,7,2, 18,0)
    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val blocksSinceAnchor = hoursSinceAnchor / 336
    val currentIndex = (anchorIndex + blocksSinceAnchor).toInt() % phantomZoneSchedule.size


    return phantomZoneSchedule[currentIndex]
}

fun phantomZoneDateRange(index: Int): String {
    val anchorIndex = 1
    val anchorStart = LocalDateTime.of(2026,7,2, 18,0)
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

fun phantomZoneDateRangeFromOffset(offset: Int): String {
    val anchorStart = LocalDateTime.of(2026,7,2,18,0)
    val now = LocalDateTime.now()

    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val blocksSinceAnchor = hoursSinceAnchor / 336

    val start = anchorStart.plusDays((blocksSinceAnchor + offset) * 14)
    val end = start.plusDays(14).minusMinutes(1)

    val startMonth = start.month.getDisplayName(TextStyle.FULL, Locale.US)
    val endMonth = end.month.getDisplayName(TextStyle.FULL, Locale.US)

    if (start.year == end.year) {
        return "${startMonth} ${start.dayOfMonth} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    } else {
        return "${startMonth} ${start.dayOfMonth} ${start.year} - ${endMonth} ${end.dayOfMonth}, ${end.year}"
    }
}
