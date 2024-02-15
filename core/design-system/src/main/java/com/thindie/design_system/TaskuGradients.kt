package com.thindie.design_system

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object TaskuGradients {
    private val color1 = Color(0xFFFFF7FF)
    private val color2 = Color(0xFFF5FFFE)
    val weakGray = listOf(
        Color.White.copy(ColorAlphas.basic),
        Color.LightGray.copy(ColorAlphas.expert),
        Color.White.copy(ColorAlphas.basic),
    )
    val whiteBlack = listOf(Color.Gray, Color.Black)
    val primaryPrimaryContainer
        @Composable get() = listOf(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.primary
        )
    val surfaceVariantPrimaryContainer
        @Composable get() = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.surfaceVariant
        )

    val whiteCyan
        @Composable get() = listOf(
            Color.White,
            Color.Cyan,
        )
    val whiteRounderStops
        @Composable get() = arrayOf(
            0.0f to Color.White,
            0.2f to MaterialTheme.colorScheme.background,
            0.3f to color1,
            0.4f to color1,
            0.5f to color2,
            0.6f to color2,
            0.7f to MaterialTheme.colorScheme.background,
            1.0f to Color.White
        )
}