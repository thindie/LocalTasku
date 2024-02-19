package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
@Suppress("LongParameterList")
@Composable
fun TaskuGenericDividedContent(
    modifier: Modifier = Modifier,
    dividerColor: Color = MaterialTheme.colorScheme.onBackground,
    thickness: Dp = Dp.Hairline,
    spacedBy: Dp = 4.dp,
    alignment: Alignment.Horizontal = Alignment.Start,
    arrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = alignment) {
        content()
        Spacer(modifier = Modifier.height(spacedBy))
        Divider(thickness = thickness, color = dividerColor)
    }
}