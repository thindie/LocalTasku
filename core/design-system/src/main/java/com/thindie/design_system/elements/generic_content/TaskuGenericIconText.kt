package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.TaskuDimensions

@Suppress("LongParameterList")
@Composable
fun TaskuGenericIconText(
    modifier: Modifier = Modifier,
    painter: Painter,
    tint: Color,
    style: TextStyle? = null,
    spacerWidth: Dp = TaskuDimensions.Spacing.near,
    iconSize: Dp = TaskuDimensions.TaskuIcons.regular,
    arrangement: Arrangement.Horizontal = Arrangement.Start,
    alignment: Alignment.Vertical = Alignment.CenterVertically,
    title: String,
) {
    TaskuGenericIconContent(
        verticalAlignment = alignment,
        horizontalArrangement = arrangement,
        painter = painter,
        tint = tint,
        modifier = modifier,
        spacerWidth = spacerWidth,
        iconSize = iconSize,
    ) {
        Text(text = title, style = style ?: LocalTextStyle.current)
    }
}
