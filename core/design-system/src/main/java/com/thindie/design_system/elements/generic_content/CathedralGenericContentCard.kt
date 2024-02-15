package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CathedralGenericContentCard(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    content: @Composable () -> Unit,
) {
    val cardColors = CardDefaults.elevatedCardColors(
        containerColor = color,
    )
    val cardElevation = CardDefaults.elevatedCardElevation(
        defaultElevation = 3.dp.plus(elevation),
        pressedElevation = 1.dp.plus(elevation),
        focusedElevation = 2.dp.plus(elevation),
        hoveredElevation = 1.dp.plus(elevation),
        draggedElevation = 1.dp.plus(elevation),
        disabledElevation = 0.dp.plus(elevation)
    )


    ElevatedCard(
        modifier = modifier.padding(horizontal = 2.dp),
        shape = shape,
        colors = cardColors,
        elevation = cardElevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                ,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            content()
        }
    }
}