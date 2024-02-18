package com.thindie.design_system.elements

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thindie.design_system.Expandable
import com.thindie.design_system.Presentable
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.elements.generic_content.TaskuGenericIconContent
import com.thindie.design_system.elements.generic_content.TaskuGenericInputField
import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent


@Composable
fun TaskuItem(
    modifier: Modifier = Modifier,
    expandable: Expandable,
    index: Int,
    item: Presentable,
    onEvent: (TaskuItemEvent) -> Unit,
) {
    val itemHeight by animateDpAsState(
        targetValue = if (expandable.isExpanded()) {
            TaskuDimensions.expandedTaskuHeight
        } else {
            TaskuDimensions.basicTaskuHeight
        }, animationSpec = tween(easing = FastOutSlowInEasing), label = ""
    )
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        onClick = {
            onEvent(TaskuItemEvent.OnClick(index))
        },
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight)
    ) {

        TaskuGenericIconContent(
            painter = item.presentPicture(),
            tint = MaterialTheme.colorScheme.primary,
            verticalAlignment = if (expandable.isExpanded()) Alignment.Top else Alignment.CenterVertically
        ) {
            if (expandable.isExpanded()) {
                ExpandedItem(item = item, onEvent = onEvent, index = index)
            } else {
                UsualItem(item = item, onEvent = onEvent, index = index)
            }
        }
    }
}


@Composable
private fun ExpandedItem(item: Presentable, index: Int, onEvent: (TaskuItemEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TitleSection(isExpanded = true, item = item, onEvent = {
            onEvent(
                TaskuItemEvent.OnChangeTitle(it, index)
            )
        })
        DescriptionSection(item = item, onEvent = {
            onEvent(
                TaskuItemEvent.OnChangeDescription(it, index)
            )
        })
        CustomizingSection(isExpanded = true, item = item, onEvent) // todo(
    }
}

@Composable
private fun UsualItem(item: Presentable, index: Int, onEvent: (TaskuItemEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        TitleSection(isExpanded = false, item = item, onEvent = { /*ignore*/ })
        CustomizingSection(isExpanded = false, item = item, onEvent)
    }
}

@Composable
private fun TitleSection(
    isExpanded: Boolean,
    item: Presentable,
    onEvent: (String) -> Unit,
) {

    if (isExpanded) {
        TaskuGenericInputField(
            autoRequestFocus = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            onFieldValueChange = onEvent,
            fieldValue = item.presentTitle()
        )
    } else {
        Text(
            text = item.presentTitle()
        )
    }
}

@Composable
private fun DescriptionSection(item: Presentable, onEvent: (String) -> Unit) {

    TaskuGenericInputField(
        autoRequestFocus = false,
        textStyle = MaterialTheme.typography.bodyMedium,
        onFieldValueChange = onEvent,
        fieldValue = item.presentDescription()
    )
}

@Composable
fun CustomizingSection(isExpanded: Boolean, item: Presentable, onEvent: (TaskuItemEvent) -> Unit) {

}