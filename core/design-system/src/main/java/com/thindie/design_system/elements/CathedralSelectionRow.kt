package com.thindie.design_system.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.ColorAlphas
import com.thindie.design_system.resources.TaskuTitles
import com.thindie.design_system.string

@Composable
fun CathedralSelectionRow(
    selectedIndex: Int,
    selectingOptions: List<String>,
    onEvent: (Int, String) -> Unit,
) {

    val resultSelectOptions = selectingOptions.toMutableList().apply {
        add(0, TaskuTitles.allPossible.string())
    }

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        Alignment.CenterVertically
    ) {
        resultSelectOptions.forEachIndexed() { i, item ->
            CathedralSelectionRowUnit(item, i == selectedIndex, onEvent = {
                onEvent(
                    i, item
                )
            })
        }
    }
}

@Composable
private fun CathedralSelectionRowUnit(
    item: String,
    isSelected: Boolean,
    onEvent: () -> Unit,
) {
    val floatState by animateFloatAsState(
        targetValue = if (isSelected.not()) ColorAlphas.expert else ColorAlphas.default,
        label = ""
    )

    val colorState by animateColorAsState(
        targetValue = if (isSelected.not()) Color.Gray else MaterialTheme.colorScheme.primary,
        label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .height(TaskuDimensions.selectionRowHeight)
    ) {

        AssistChip(onClick = onEvent, label = {
            Text(
                modifier = Modifier.scale(floatState.plus(0.2f)),
                text = item,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = LocalContentColor.current.copy(
                        alpha = floatState
                    ),
                    fontWeight = FontWeight.Bold
                )
            )
        },
            border = AssistChipDefaults.assistChipBorder(borderColor = Color.White.copy(floatState)),
            shape = MaterialTheme.shapes.extraLarge,
            leadingIcon = {

                Text(
                    text = "•",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorState
                )

            })

    }
}

