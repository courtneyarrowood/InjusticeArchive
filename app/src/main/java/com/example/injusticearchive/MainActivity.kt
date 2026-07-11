package com.example.injusticearchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InjusticeArchiveApp()
        }
    }
}

@Composable
fun InjusticeArchiveApp() {
    var selectedTab by remember { mutableStateOf("Home") }
    var selectedSchedulePage by remember {mutableStateOf<String?>(null)}

    Scaffold(
        bottomBar = {
            NavigationBar {
                listOf("Home", "Characters", "Schedule").forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        label = { Text(tab) },
                        icon = { Text("") }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            when (selectedTab) {
                "Home" -> HomeScreen()

                "Characters" -> CharacterScreen()

                "Schedule" ->
                    when (selectedSchedulePage) {
                    "Challenge" -> ChallengeScheduleScreen(onBack = {selectedSchedulePage = null})
                    "Breakthrough" -> BreakthroughScheduleScreen(onBack = {selectedSchedulePage = null})
                    "Phantom Zone" -> PhantomZoneScheduleScreen(onBack = {selectedSchedulePage = null})
                    "Online Battle" -> OnlineBattleScheduleScreen(onBack = {selectedSchedulePage = null})
                    "Survivor" -> SurvivorScheduleScreen(onBack = {selectedSchedulePage = null})
                        else -> ScheduleScreen(onChallengeClick = {selectedSchedulePage = "Challenge"},
                            onBreakthroughClick = {selectedSchedulePage = "Breakthrough"},
                            onPhantomZoneClick = { selectedSchedulePage = "Phantom Zone" },
                            onOnlineBattleClick = {selectedSchedulePage = "Online Battle"},
                            onSurvivorClick = {selectedSchedulePage = "Survivor"},
                        )
                    }
                else -> "Injustice Archive"
            }
        }
    }
}