package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.TaskuDimensions

@Suppress("LongParameterList")
@Composable
fun TaskuGenericSurfaceIconContent(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    painter: Painter,
    iconTint: Color,
    surfaceColor: Color,
    onSurfaceClick: () -> Unit = {},
    surfaceShape: Shape = MaterialTheme.shapes.extraLarge,
    iconSize: Dp = TaskuDimensions.iconSizeRegular,
    spacerWidth: Dp = TaskuDimensions.spaceNear,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = surfaceShape,
        onClick = onSurfaceClick,
        color = surfaceColor
    ) {

        TaskuGenericIconContent(
            iconModifier = iconModifier,
            painter = painter,
            tint = iconTint,
            spacerWidth = spacerWidth,
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            iconSize = iconSize,
        ) {
            content()
        }
    }
}
