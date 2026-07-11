package com.example.injusticearchive

data class BreakthroughRotation(val tier: String, val days: String)

val breakthroughSchedule = listOf(
    BreakthroughRotation("Bronze", "Monday  Wednesday"),
    BreakthroughRotation("Silver", "Tuesday  Thursday"),
    BreakthroughRotation("Gold", "Friday  Saturday  Sunday")
)

data class GoldBreakthroughRotation(val characters: List<String>)

val goldBreakthroughRotation = listOf(
    GoldBreakthroughRotation(listOf("Superman", "Raven", "The Arkham Knight")),

    GoldBreakthroughRotation(listOf("Harley Quinn", "Killer Croc", "Martian Manhunter")),

    GoldBreakthroughRotation(listOf("Hawkgirl", "Green Lantern", "Lobo")),

    GoldBreakthroughRotation(listOf("Lex Luthor", "Batman", "Doomsday")),

    GoldBreakthroughRotation(listOf("Bane", "Killer Frost", "Ares")),

    GoldBreakthroughRotation(listOf("Sinestro", "Green Arrow", "Scorpion")),

    GoldBreakthroughRotation(listOf("The Joker", "Nightwing", "Darkseid")),

    GoldBreakthroughRotation(listOf("Zod", "Aquaman", "Shazam")),

    GoldBreakthroughRotation(listOf("Catwoman", "Deathstroke", "Raven")),

    GoldBreakthroughRotation(listOf("Cyborg", "Batgirl", "Black Adam")),

    GoldBreakthroughRotation(listOf("Deadshot", "Wonder Woman", "Static")),

    GoldBreakthroughRotation(listOf("Zatanna", "The Flash", "Solomon Grundy")),
)
