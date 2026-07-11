package com.example.injusticearchive

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale


// ------------------- SCHEDULE TAB ------------------- //
@Composable
fun ScheduleScreen(onChallengeClick: () -> Unit, onBreakthroughClick: () -> Unit, onPhantomZoneClick: () -> Unit, onOnlineBattleClick: () -> Unit, onSurvivorClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 16.dp, vertical = 24.dp)) {

        ScheduleChallengeSection(onChallengeClick = onChallengeClick)

        Spacer(modifier = Modifier.height(32.dp))

        ScheduleBreakthroughSection(onBreakthroughClick = onBreakthroughClick)

        Spacer(modifier = Modifier.height(32.dp))

        SchedulePhantomZoneSection(onPhantomZoneClick = onPhantomZoneClick)

        Spacer(modifier = Modifier.height(32.dp))

        ScheduleOnlineBattleSection(onOnlineBattleClick = onOnlineBattleClick)

        Spacer(modifier = Modifier.height(32.dp))

        ScheduleSurvivorSection(onSurvivorClick = onSurvivorClick)

    }
}

@Composable
fun ScheduleChallengeSection(onChallengeClick: () -> Unit) {
    val currentChallenge = getCurrentChallenge(LocalDateTime.now())
    val currentChallengeIndex = challengeSchedule.indexOf(currentChallenge)

    val nextChallengeIndex = (currentChallengeIndex + 1) % challengeSchedule.size
    val nextChallenge = challengeSchedule[nextChallengeIndex]

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader("Challenge Character")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Current")
        Text(currentChallenge.character.displayName())

        Spacer(modifier = Modifier.height(12.dp))

        Text("Next")
        Text(nextChallenge.character.displayName())

        TextButton(onClick = onChallengeClick) {
            Text("See Full Challenge Character Schedule")
        }
    }
}

@Composable
fun ScheduleBreakthroughSection(onBreakthroughClick: () -> Unit) {
    val currentGoldRotation = getCurrentGoldBreakthrough(LocalDateTime.now())

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader("Breakthrough")
        Spacer(modifier = Modifier.height(8.dp))

        breakthroughSchedule.forEach {
                breakthrough ->
            Text(breakthrough.tier)
            Spacer(modifier = Modifier.height(1.dp))
            Text(breakthrough.days)
            Spacer(modifier = Modifier.height(4.dp))

            if (breakthrough.tier == "Gold") {
                Text(currentGoldRotation.characters.joinToString(" | "))
            }
        }

        TextButton( onClick = onBreakthroughClick ) {
            Text("See Full Breakthrough Schedule")
        }

    }
}

@Composable
fun SchedulePhantomZoneSection(onPhantomZoneClick: () -> Unit) {
    val currentPhantomZone = getCurrentPhantomZone(LocalDateTime.now())
    val currentPhantomZoneIndex = phantomZoneSchedule.indexOf(currentPhantomZone)

    val nextPhantomZoneIndex = (currentPhantomZoneIndex + 1) % phantomZoneSchedule.size
    val nextPhantomZone = phantomZoneSchedule[nextPhantomZoneIndex]



    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader("Phantom Zone")
        Spacer(modifier = Modifier.height(8.dp))

        Text(currentPhantomZone.status)
        Text(phantomZoneDateRangeFromOffset(0))

        Spacer(modifier = Modifier.height(12.dp))

        Text(nextPhantomZone.status)
        Text(phantomZoneDateRangeFromOffset(1))

        TextButton( onClick = onPhantomZoneClick) {
            Text("See Full Phantom Zone Schedule")
        }
    }
}

@Composable
fun ScheduleOnlineBattleSection(onOnlineBattleClick: () -> Unit) {
    val currentOnlineBattle = getCurrentOnlineBattle(LocalDateTime.now())
    val currentOnlineBattleIndex = onlineBattleSchedule.indexOf(currentOnlineBattle)


    val nextOnlineBattleIndex = (currentOnlineBattleIndex + 1) % onlineBattleSchedule.size
    val nextOnlineBattle = onlineBattleSchedule[nextOnlineBattleIndex]

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader("Online Battle")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Current")
        Text(currentOnlineBattle.reward)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Next")
        Text(nextOnlineBattle.reward)

        TextButton( onClick = onOnlineBattleClick) {
            Text("See Full Online Battle Schedule")
        }

    }
}

@Composable
fun ScheduleSurvivorSection(onSurvivorClick: () -> Unit) {
    val currentSurvivor = getCurrentSurvivor(LocalDateTime.now())
    val currentSurvivorIndex = survivorSchedule.indexOf(currentSurvivor)

    val nextSurvivorIndex = (currentSurvivorIndex + 1) % survivorSchedule.size
    val nextSurvivor = survivorSchedule[nextSurvivorIndex]

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionHeader("Survivor")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Current")
        Text(currentSurvivor.gearSet)

        Spacer(modifier = Modifier.height(12.dp))

        Text("Next")
        Text(nextSurvivor.gearSet)

        TextButton( onClick = onSurvivorClick) {
            Text("See Full Survivor Schedule")
        }
    }
}



// ------------- CHALLENGE SCREEN & HELPER FUNCTIONS ------------- //

@Composable
fun ChallengeScheduleScreen(onBack: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        TextButton(onClick = onBack) {
            Text("<-")
        }

        SectionHeader("Challenge Character Schedule")

        Spacer(modifier = Modifier.height(16.dp))

        challengeSchedule.forEach {
                challenge -> ChallengeScheduleCard(challenge)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ChallengeScheduleCard(challenge: ChallengeEvent) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val index = challengeSchedule.indexOf(challenge)

        val currentChallenge = getCurrentChallenge(LocalDateTime.now())
        val currentIndex = challengeSchedule.indexOf(currentChallenge)
        val isCurrent = index == currentIndex

        Text(challenge.character.displayName(),
            fontWeight = if (isCurrent) {
                FontWeight.Bold
            } else FontWeight.Normal)

        Spacer(modifier = Modifier.height(6.dp))

        Text(challengeDateRange(index))

        Spacer(modifier = Modifier.height(6.dp))

        Text(challenge.gear)

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()
    }
}

// ------------- BREAKTHROUGH SCREEN & HELPER FUNCTIONS ------------- //
@Composable
fun BreakthroughScheduleScreen(onBack: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        TextButton(onClick = onBack) {
            Text("<-")
        }

        SectionHeader("Breakthrough Schedule")
        Spacer(modifier = Modifier.height(16.dp))

        breakthroughSchedule.forEach {
                breakthrough -> BreakthroughScheduleCard(breakthrough)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        SectionHeader("Gold Breakthrough Schedule")
        Spacer(modifier = Modifier.height(16.dp))

        goldBreakthroughRotation.forEach {
                rotation -> GoldBreakthroughScheduleCard(rotation) }
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun BreakthroughScheduleCard(breakthrough: BreakthroughRotation) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(breakthrough.tier, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(6.dp))
        Text(breakthrough.days)

        Spacer(modifier = Modifier.height(6.dp))
        HorizontalDivider()
    }
}

@Composable
fun GoldBreakthroughScheduleCard(goldRotation: GoldBreakthroughRotation) {
    val index = goldBreakthroughRotation.indexOf(goldRotation)

    val currentRotation = getCurrentGoldBreakthrough(LocalDateTime.now())
    val currentIndex = goldBreakthroughRotation.indexOf(currentRotation)
    val isCurrent = index == currentIndex

    Text(goldRotation.characters.joinToString(" | "),
        fontWeight = if (isCurrent) {
            FontWeight.Bold
        } else FontWeight.Normal)
    Spacer(modifier = Modifier.height(4.dp))
}

// ------------- PHANTOM ZONE SCREEN & HELPER FUNCTIONS ------------- //

@Composable
fun PhantomZoneScheduleScreen(onBack: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        TextButton(onClick = onBack) {
            Text("<-")
        }

        SectionHeader("Phantom Zone Schedule")

        Spacer(modifier = Modifier.height(16.dp))

        phantomZoneSchedule.forEach {
                phantomZone -> PhantomZoneScheduleCard(phantomZone)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PhantomZoneScheduleCard(phantomZone: PhantomZoneRotation) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val index = phantomZoneSchedule.indexOf(phantomZone)
        Text(
            phantomZone.status,
            fontWeight = FontWeight.Bold
        )

        Text(phantomZoneDateRange(index))
        Spacer(modifier = Modifier.height(6.dp))
        HorizontalDivider()
    }
}


// ------------- ONLINE BATTLE SCREEN & HELPER FUNCTIONS ------------- //

@Composable
fun OnlineBattleScheduleScreen(onBack: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        TextButton(onClick = onBack) {
            Text("<-")
        }

        SectionHeader("Online Battle Schedule")

        Spacer(modifier = Modifier.height(16.dp))

        val currentOnlineBattle = getCurrentOnlineBattle(LocalDateTime.now())
        val currentIndex = onlineBattleSchedule.indexOf(currentOnlineBattle)

        repeat(52) { offset ->
            val index = (currentIndex + offset) % onlineBattleSchedule.size
            val onlineBattle = onlineBattleSchedule[index]

            OnlineBattleScheduleCard(onlineBattle, offset)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun OnlineBattleScheduleCard(onlineBattle: OnlineBattleRotation, offset: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val index = onlineBattleSchedule.indexOf(onlineBattle)

        val currentOnlineBattle = getCurrentOnlineBattle(LocalDateTime.now())
        val currentIndex = onlineBattleSchedule.indexOf(currentOnlineBattle)
        val isCurrent = index == currentIndex

        Text(
            onlineBattle.reward,
            fontWeight =
                if (isCurrent)
                    FontWeight.Bold
                else FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(onlineBattleDateRangeFromOffset(offset))

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()
    }
}

// ------------- SURVIVOR SCREEN & HELPER FUNCTIONS ------------- //

@Composable
fun SurvivorScheduleScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            Row {
                TextButton(onClick = onBack) {
                    Text("<-")
                }
                SectionHeader("Survivor Schedule")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {


            val currentSurvivor = getCurrentSurvivor(LocalDateTime.now())
            val currentIndex = survivorSchedule.indexOf(currentSurvivor)

            repeat(26) { offset ->
                val index = (currentIndex + offset) % survivorSchedule.size
                val survivor = survivorSchedule[index]

                SurvivorScheduleCard(survivor = survivor, offset = offset)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun SurvivorScheduleCard(survivor: SurvivorRotation, offset: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(survivor.gearSet,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(6.dp))

        Text(survivorDateRangeFromOffset(offset))

        Spacer(modifier = Modifier.height(6.dp))

        HorizontalDivider()
    }
}

fun survivorDateRangeFromOffset(offset: Int): String {
    val anchorStart = LocalDateTime.of(2026,6,24,8,0)
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
