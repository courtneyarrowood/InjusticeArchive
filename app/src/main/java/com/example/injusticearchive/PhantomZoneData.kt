package com.example.injusticearchive


data class PhantomZoneRotation(
    val status: String
)

val phantomZoneSchedule = listOf(
    PhantomZoneRotation("Active"),
    PhantomZoneRotation("Inactive")
)
