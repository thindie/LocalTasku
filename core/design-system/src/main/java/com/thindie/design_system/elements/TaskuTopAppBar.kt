package com.thindie.design_system.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.elements.generic_content.TaskuGenericSurfaceIconContent
import com.thindie.design_system.painter
import com.thindie.design_system.theme.TaskuColors

@Composable
fun TaskuTopAppBar(labelText: String, onClickBack: () -> Unit, onOptionsEvent: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(TaskuDimensions.Padding.commonValues)
            .fillMaxWidth()
            .height(TaskuDimensions.TopBar.height),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onClickBack) {
            Icon(
                painter = TaskuIcons.Controls.chevronBack.painter(),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        TaskuGenericSurfaceIconContent(
            modifier = Modifier
                .padding(TaskuDimensions.Padding.horizontal)
                .wrapContentWidth(),
            painter = TaskuIcons.flame.painter(),
            iconTint = TaskuColors.orange,
            horizontalArrangement = Arrangement.Center,
            surfaceColor = MaterialTheme.colorScheme.surface,
            spacerWidth = TaskuDimensions.Spacing.usual
        ) {
            Text(text = labelText)
        }

        IconButton(onClick = onOptionsEvent) {
            Icon(
                painter = TaskuIcons.Controls.optionDots.painter(),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}