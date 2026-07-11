package com.example.injusticearchive

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun CharacterCardView(character: CharacterCard) {
    Box(
        modifier = Modifier
            .size(width = 130.dp, height = 175.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(character.imageResource), contentDescription = character.displayName(),
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Fit
        )
    }
}


// ------------------- CHARACTER TAB ------------------- //

@Composable
fun CharacterScreen() {
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)) {

        var selectedFilter by remember { mutableStateOf(CharacterFilter.All) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CharacterFilter.values().forEach { filter ->
                Text(text = filter.name,
                    fontWeight = if (selectedFilter == filter) {
                        FontWeight.Bold
                    }
                    else FontWeight.Normal,
                    modifier = Modifier.clickable {
                        selectedFilter = filter
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        val displayedCharacters =
            when (selectedFilter) {
                CharacterFilter.All -> allCharacters.sortedWith(compareBy<CharacterCard>{ it.name }.thenBy { it.variant ?: "" })

                CharacterFilter.Bronze -> allCharacters.filter { it.tier == Tier.Bronze }
                CharacterFilter.Silver -> allCharacters.filter { it.tier == Tier.Silver }
                CharacterFilter.Gold -> allCharacters.filter { it.tier == Tier.Gold }
                CharacterFilter.Metal -> allCharacters.filter { it.tier == Tier.Metal }
            }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement =
                Arrangement.spacedBy(12.dp),
            horizontalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {
            items(displayedCharacters) {
                    character -> CharacterCardView(character)
            }
        }
    }
}
