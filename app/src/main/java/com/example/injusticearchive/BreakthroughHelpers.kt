package com.example.injusticearchive

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


fun getTodayBreakthroughTier(now: LocalDateTime): String {
    val day = now.dayOfWeek
    return when (day) {
        DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY -> "Bronze"
        DayOfWeek.TUESDAY, DayOfWeek.THURSDAY -> "Silver"
        DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> "Gold"
    }
}

fun getBreakthroughGoldLabel(now: LocalDateTime): String {
    val day = now.dayOfWeek
    return when (day) {
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY -> "Next Gold Rotation"

        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY,
        DayOfWeek.SUNDAY -> "Current Gold Rotation"
    }
}

fun getDisplayGoldBreakthrough(now: LocalDateTime): GoldBreakthroughRotation {
    val day = now.dayOfWeek
    val currentGoldRotation = getCurrentGoldBreakthrough(now)
    val currentIndex = goldBreakthroughRotation.indexOf(currentGoldRotation)

    val nextIndex = (currentIndex + 1)  % goldBreakthroughRotation.size

    return when (day) {
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY -> goldBreakthroughRotation[nextIndex]

        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY,
        DayOfWeek.SUNDAY -> currentGoldRotation
    }
}

fun getCurrentGoldBreakthrough(now: LocalDateTime): GoldBreakthroughRotation {
    val anchorIndex = 2
    val anchorStart = LocalDateTime.of(2026,6,26,0,0)

    val hoursSinceAnchor = ChronoUnit.HOURS.between(anchorStart, now)
    val weeksSinceAnchor = hoursSinceAnchor / 168

    val currentIndex = (anchorIndex + weeksSinceAnchor).toInt() % goldBreakthroughRotation.size

    return goldBreakthroughRotation[currentIndex]

}