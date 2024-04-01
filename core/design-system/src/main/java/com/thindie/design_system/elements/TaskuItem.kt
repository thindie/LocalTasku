package com.thindie.design_system.elements

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.thindie.design_system.Expandable
import com.thindie.design_system.Presentable
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.generic_content.TaskuGenericImageContent
import com.thindie.design_system.elements.generic_content.TaskuGenericInputField
import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent
import com.thindie.design_system.string


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
            TaskuDimensions.TaskuCard.taskuHeightExpanded
        } else {
            TaskuDimensions.TaskuCard.taskuHeight
        }, animationSpec = tween(easing = FastOutSlowInEasing), label = ""
    )
    Surface(
        shape = MaterialTheme.shapes.extraLarge, onClick = {
            onEvent(TaskuItemEvent.OnClick(index))
        }, modifier = modifier
            .fillMaxWidth()
            .height(itemHeight)
    ) {

        TaskuGenericImageContent(
            painter = item.presentPicture(),
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
        CostDisplayingExpanded(item = item, onEvent = {
            onEvent(TaskuItemEvent.OnChangeCredits(it, index))
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleSection(isExpanded = false, item = item, onEvent = { /*ignore*/ })
            CostDisplayingUnexpanded(item = item)
        }

        CustomizingSection(isExpanded = false, item = item, onEvent)
    }
}

@Composable
private fun CostDisplayingUnexpanded(item: Presentable) {
    if (item.presentCredits().isNotBlank())
        Text(
            text = item.presentCredits(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
}

@Composable
private fun CostDisplayingExpanded(item: Presentable, onEvent: (String) -> Unit) {
    TaskuGenericInputField(
        autoRequestFocus = true,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onBackground,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W400
        ),
        onFieldValueChange = onEvent,
        fieldValue = item.presentCredits(),
        placeHolderString =  TaskuTitles.TaskuCard.blankCost.string()
    )
}

@Composable
private fun TitleSection(
    isExpanded: Boolean,
    item: Presentable,
    onEvent: (String) -> Unit,
) {

    if (isExpanded) {
        TaskuGenericInputField(
            autoRequestFocus = true, textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W400
            ), onFieldValueChange = onEvent, fieldValue = item.presentTitle(),
            placeHolderString =  TaskuTitles.TaskuCard.blankTitle.string()
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
        autoRequestFocus = false, textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onBackground,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.W400
        ), onFieldValueChange = onEvent,
        fieldValue = item.presentDescription(),
        placeHolderString = TaskuTitles.TaskuCard.blackDesc.string()
    )
}

@Composable
fun CustomizingSection(isExpanded: Boolean, item: Presentable, onEvent: (TaskuItemEvent) -> Unit) {

}