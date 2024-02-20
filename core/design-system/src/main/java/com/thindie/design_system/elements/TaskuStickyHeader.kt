package com.thindie.design_system.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.thindie.design_system.TaskPriorityType
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.elements.generic_content.TaskuGenericDividedContent
import com.thindie.design_system.elements.generic_content.TaskuGenericIconText
import com.thindie.design_system.painter
import com.thindie.design_system.string
import com.thindie.design_system.theme.TaskuColors


@Composable
fun TaskuStickyHeader(painter: Painter, title: String, tint: Color) {
    TaskuGenericDividedContent {
        TaskuGenericIconText(painter = painter, tint = tint, title = title)
    }
}

@Composable
fun TaskuAreaStickyHeader(title: String) {
    TaskuStickyHeader(painter = TaskuIcons.area.painter(), title = title, tint = TaskuColors.azure)
}

@Composable
fun TaskuPriorityStickyHeader(priorityType: TaskPriorityType) {
    TaskuStickyHeader(
        painter = priorityType.getStatusImage(),
        title = priorityType.getTitle().string(),
        tint = priorityType.getColor()
    )
}