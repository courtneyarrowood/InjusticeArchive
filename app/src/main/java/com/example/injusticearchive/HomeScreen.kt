package com.example.injusticearchive

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

// ------------------- HOME TAB ------------------- //

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        ChallengeCharacterSection()

        PhantomZoneSection()
        Spacer(modifier = Modifier.height(24.dp))

        BreakthroughSection()
        Spacer(modifier = Modifier.height(24.dp))

        OnlineSection()
        Spacer(modifier = Modifier.height(24.dp))

        SurvivorSection()
    }
}
@Composable
fun ChallengeCharacterSection() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

        val currentChallenge = getCurrentChallenge(LocalDateTime.now())

        Column {
            SectionHeader("Challenge Character")
            Text(currentChallenge.character.displayName())
            Text(challengeDateRange(challengeSchedule.indexOf(currentChallenge)))
        }
        CharacterCardView(currentChallenge.character)
    }
}
@Composable
fun PhantomZoneSection() {
    Row() {
        Column {
            SectionHeader("Phantom Zone")
            val currentPhantomZone = getCurrentPhantomZone(LocalDateTime.now())

            Text(currentPhantomZone.status)
            Text(phantomZoneDateRangeFromOffset(0))
        }
    }
}
@Composable
fun BreakthroughSection() {
    val todayTier = getTodayBreakthroughTier(LocalDateTime.now())
    val goldLabel = getBreakthroughGoldLabel(LocalDateTime.now())
    val displayGoldRotation = getDisplayGoldBreakthrough(LocalDateTime.now())
    Row() {
        Column {
            SectionHeader("Breakthrough")

            Text(todayTier)

            Spacer(modifier = Modifier.height(6.dp))

            Text(goldLabel)
            Text(displayGoldRotation.characters.joinToString(" | "))
        }
    }
}

@Composable
fun OnlineSection() {
    Row() {
        Column {
            SectionHeader("Online Battle")
            val currentOnlineBattle = getCurrentOnlineBattle(LocalDateTime.now())
            val currentOnlineBattleIndex = onlineBattleSchedule.indexOf(currentOnlineBattle)

            Text(currentOnlineBattle.reward)
            Text(onlineBattleDateRange(currentOnlineBattleIndex))
        }
    }
}
@Composable
fun SurvivorSection() {
    Row() {
        Column {
            SectionHeader("Survivor")
            val currentSurvivor = getCurrentSurvivor(LocalDateTime.now())
            val currentSurvivorIndex = survivorSchedule.indexOf(currentSurvivor)

            Text(currentSurvivor.gearSet)
            Text(survivorDateRange(currentSurvivorIndex))
        }
    }
}