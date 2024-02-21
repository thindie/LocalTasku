package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.TaskuDimensions

@Suppress("LongParameterList")
@Composable
fun TaskuGenericImageContent(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    painter: Painter,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    iconSize: Dp = TaskuDimensions.TaskuIcons.regular,
    spacerWidth: Dp = TaskuDimensions.Spacing.usual,
    content: @Composable () -> Unit,
) {

    Row(
        modifier = modifier.padding(
            TaskuDimensions.Padding.commonValues
        ),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {

        Image(
            modifier = iconModifier
                .size(iconSize),
            painter = painter,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(spacerWidth))
        content()
    }
}
