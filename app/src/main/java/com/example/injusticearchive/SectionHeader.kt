package com.example.injusticearchive

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight


@Composable
fun SectionHeader(header: String) {
    Text(
        text = header,
        fontWeight = FontWeight.Bold
    )
}