package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CathedralGenericContentUnit(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    content: @Composable () -> Unit,
) {

    Surface(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        shape = shape,
        color = color,
        shadowElevation = shadowElevation,
        tonalElevation = elevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            content()
        }
    }
}