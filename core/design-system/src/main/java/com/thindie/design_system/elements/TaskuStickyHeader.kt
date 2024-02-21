package com.thindie.design_system.elements

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import com.thindie.design_system.TaskPriorityType
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.elements.generic_content.TaskuGenericDividedContent
import com.thindie.design_system.elements.generic_content.TaskuGenericIconText
import com.thindie.design_system.painter
import com.thindie.design_system.string
import com.thindie.design_system.theme.TaskuColors


@Composable
fun TaskuStickyHeader(
    painter: Painter,
    title: String,
    painterTint: Color,
    style: TextStyle? = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onSurface),
) {
    TaskuGenericDividedContent {
        TaskuGenericIconText(painter = painter, tint = painterTint, title = title, style = style)
    }
}

@Composable
fun TaskuAreaStickyHeader(title: String) {
    TaskuStickyHeader(
        painter = TaskuIcons.area.painter(),
        title = title,
        painterTint = TaskuColors.azure,
    )
}

@Composable
fun TaskuPriorityStickyHeader(priorityType: TaskPriorityType) {
    TaskuStickyHeader(
        painter = priorityType.getStatusImage(),
        title = priorityType.getTitle().string(),
        painterTint = priorityType.getColor(),
    )
}