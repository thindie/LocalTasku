package com.thindie.design_system.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.zIndex
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuShapes
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.dropdown_menu.TaskuDropdownMenu
import com.thindie.design_system.elements.generic_content.TaskuGenericTextContent
import com.thindie.design_system.painter
import com.thindie.design_system.string
import kotlinx.coroutines.delay


object TaskuSortAndGroup {
    interface Applyable {
        fun getLabel(): Int
        fun getDrawable(): Int

        fun getRootElementColor(): Color

        fun getRootBackgroundColor(): Color

        fun getDropdownBackgroundColor(): Color

        fun isExpanded(): Boolean
    }
}

@Suppress("LongParameterList")
@Composable
fun TaskuSortAndGroupRow(
    sortApplyable: TaskuSortAndGroup.Applyable,
    groupApplyable: TaskuSortAndGroup.Applyable,
    optionsSort: List<Pair<Int, SortGroup>> = sortOptions,
    optionsGroup: List<Pair<Int, SortGroup>> = groupOptions,
    modifier: Modifier = Modifier,
    onEvent: (SortGroup) -> Unit,
) {


    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .zIndex(2f)
            .fillMaxWidth()
    ) {
        SortSection(sortApplyable, optionsSort, onEvent)
        GroupSection(groupApplyable, optionsGroup, onEvent)
    }

}

@Composable
fun SortSection(
    sortApplyable: TaskuSortAndGroup.Applyable,
    options: List<Pair<Int, SortGroup>>,
    onEvent: (SortGroup) -> Unit,
) {
    GroupSection(sortApplyable, options, onEvent = {
        val event = when (it) {
            SortGroup.AREA -> it
            SortGroup.PRIORITY -> it
            SortGroup.DATE -> it
            SortGroup.ALPHABET -> it
            SortGroup.RESET -> it
            SortGroup.EXPAND_SORT -> it
            SortGroup.UNEXPAND_SORT -> it
            SortGroup.EXPAND_GROUP -> SortGroup.EXPAND_SORT
            SortGroup.UNEXPAND_GROUP -> SortGroup.UNEXPAND_SORT
        }
        onEvent(event)
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GroupSection(
    applyable: TaskuSortAndGroup.Applyable,
    options: List<Pair<Int, SortGroup>>,
    onEvent: (SortGroup) -> Unit,
) {


    Column {
        Row(
            modifier = Modifier
                .clip(
                    TaskuShapes.DropDownMenuShapes.underLyingElement
                )
                .background(
                    color = applyable.getDropdownBackgroundColor(),
                    shape = TaskuShapes.DropDownMenuShapes.underLyingElement
                )
        ) {
            Card(
                onClick = { onEvent(SortGroup.EXPAND_GROUP) },
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = applyable.getRootBackgroundColor()
                ),
                modifier = Modifier
                    .width(TaskuDimensions.DropDownMenu.width)
                    .height(TaskuDimensions.DropDownMenu.height)
            ) {
                TaskuGenericTextContent(
                    verticalAlignment = Alignment.CenterVertically,
                    title = applyable.getLabel().string(),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .height(TaskuDimensions.DropDownMenu.height),
                    style = LocalTextStyle.current.copy(
                        color = applyable.getRootElementColor(), fontWeight = FontWeight.Bold
                    )
                ) {
                    Icon(
                        painter = applyable.getDrawable().painter(),
                        contentDescription = null,
                        tint = applyable.getRootElementColor()
                    )
                }

            }
        }


        var debounceBarrier by remember {
            mutableStateOf(false)
        }
        if (debounceBarrier) {
            LaunchedEffect(key1 = debounceBarrier, block = {
                delay(600)
                onEvent(SortGroup.UNEXPAND_GROUP)
                debounceBarrier = false
            })
        }



        TaskuDropdownMenu(
            modifier = Modifier.width(TaskuDimensions.DropDownMenu.width),
            expanded = applyable.isExpanded(),
            onDismissRequest = {
                debounceBarrier = true
            },
            color = applyable.getDropdownBackgroundColor(),
            contentVerticalPadding = TaskuDimensions.Padding.horizontal,
            shape = TaskuShapes.DropDownMenuShapes.expandedDropDownMenu
        ) {
            options.forEachIndexed() { i, item ->
                TextButton(
                    onClick = { onEvent(item.second) },
                    modifier = Modifier.align(CenterHorizontally)
                ) {
                    Text(
                        text = item.first.string(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }


}

val sortOptions = listOf(
    TaskuTitles.Sort.date to SortGroup.DATE,
    TaskuTitles.Sort.alphabet to SortGroup.ALPHABET,
)

val groupOptions = listOf(
    TaskuTitles.Group.priority to SortGroup.PRIORITY,
    TaskuTitles.Group.area to SortGroup.AREA,
)

enum class SortGroup {
    AREA, PRIORITY, DATE, ALPHABET, RESET, EXPAND_SORT, UNEXPAND_SORT, EXPAND_GROUP, UNEXPAND_GROUP
}