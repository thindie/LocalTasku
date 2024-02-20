package com.thindie.design_system.elements

import androidx.annotation.StringRes
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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
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
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.TaskuShapes
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.dropdown_menu.TaskuDropdownMenu
import com.thindie.design_system.elements.generic_content.TaskuGenericTextContent
import com.thindie.design_system.painter
import com.thindie.design_system.string

@Composable
fun TaskuSortAndGroupRow(
    modifier: Modifier = Modifier,
    shouldBeDefault: Boolean,
    onSortGroup: (SortGroup) -> Unit,
) {


    val groupState = rememberExpandableMenuState(
        defaultRootLabelValue = TaskuTitles.groupBy,
        dropDownLabelOptions = listOf(TaskuTitles.Group.area, TaskuTitles.Group.priority),
        indexOfItemClicked = {
            onSortGroup(
                when (it) {
                    0 -> SortGroup.AREA
                    1 -> SortGroup.PRIORITY
                    else -> SortGroup.RESET
                }
            )
        },
    )

    val sortState = rememberExpandableMenuState(
        defaultRootLabelValue = TaskuTitles.sortBy,
        dropDownLabelOptions = listOf(TaskuTitles.Sort.date, TaskuTitles.Sort.alphabet),
        indexOfItemClicked = {
            onSortGroup(
                when (it) {
                    0 -> SortGroup.DATE
                    1 -> SortGroup.ALPHABET
                    else -> SortGroup.RESET
                }
            )
        },
    )

    groupState.onShouldBeDefaultNotification(shouldBeDefault)
    sortState.onShouldBeDefaultNotification(shouldBeDefault)


    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .zIndex(2f)
            .fillMaxWidth()
    ) {
        SortSection(sortState)
        GroupSection(groupState)
    }

}

@Composable
fun SortSection(state: TaskuExpandableMenuState) {
    GroupSection(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GroupSection(state: TaskuExpandableMenuState) {


    Column {
        Row(
            modifier = Modifier
                .clip(
                    TaskuShapes.DropDownMenuShapes.underLyingElement
                )
                .background(
                    color = state.dropDownBackgroundColor,
                    shape = TaskuShapes.DropDownMenuShapes.underLyingElement
                )
        ) {
            Card(
                onClick = state::onClickExpandMenu,
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(containerColor = state.rootBackgroundColor),
                modifier = Modifier
                    .width(TaskuDimensions.DropDownMenu.width)
                    .height(TaskuDimensions.DropDownMenu.height)
            ) {
                TaskuGenericTextContent(
                    verticalAlignment = Alignment.CenterVertically,
                    title = state.rootLabelState.string(),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .height(TaskuDimensions.DropDownMenu.height),
                    style = LocalTextStyle.current.copy(
                        color = state.rootElementColor,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    Icon(
                        painter = state.rootElementIconState.painter(),
                        contentDescription = null,
                        tint = state.rootElementColor
                    )
                }

            }
        }

        TaskuDropdownMenu(
            modifier = Modifier.width(TaskuDimensions.DropDownMenu.width),
            expanded = state.isMenuExpanded,
            onDismissRequest = state::onDismissRequest,
            color = state.dropDownBackgroundColor,
            contentVerticalPadding = TaskuDimensions.Padding.horizontal,
            shape = TaskuShapes.DropDownMenuShapes.expandedDropDownMenu
        ) {
            state.dropDownLabelOptions.forEachIndexed() { i, item ->
                TextButton(
                    onClick = { state.onClickChoseEvent(i) },
                    modifier = Modifier.align(CenterHorizontally)
                ) {
                    Text(text = item.string(), color = Color.White, fontWeight = FontWeight.Bold)
                }

            }
        }
    }


}


@Stable
class TaskuExpandableMenuState(
    @StringRes private val defaultRootLabelValue: Int,
    @StringRes val dropDownLabelOptions: List<Int>,
    private val chosenIndexCallback: (Int) -> Unit,
) {


    var rootLabelState by mutableStateOf(defaultRootLabelValue)
        private set

    var isMenuExpanded by mutableStateOf(false)
        private set


    val rootElementIconState by derivedStateOf {
        (if (defaultRootLabelValue == rootLabelState) {
            TaskuIcons.SortGroup.expand
        } else {
            TaskuIcons.SortGroup.cancel
        })
    }

    val rootElementColor: Color
        @Composable get() = if (rootLabelState == defaultRootLabelValue) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.primary


    val dropDownBackgroundColor: Color
        @Composable get() = if (isMenuExpanded) MaterialTheme.colorScheme.surfaceTint else Color.Transparent


    val rootBackgroundColor
        @Composable get() = if (isMenuExpanded) MaterialTheme.colorScheme.primaryContainer else Color.Transparent


    fun onClickChoseEvent(index: Int) {
        try {
            rootLabelState = dropDownLabelOptions[index]
            chosenIndexCallback(index)
        } catch (_: Exception) {
            rootLabelState = defaultRootLabelValue
            chosenIndexCallback(-1)
        }
        isMenuExpanded = false
    }


    fun onClickExpandMenu() {
        isMenuExpanded = true
    }

    fun onDismissRequest() {
        isMenuExpanded = false
    }

    fun onShouldBeDefaultNotification(predicate: Boolean) {
        if (rootLabelState != defaultRootLabelValue && predicate) {
            rootLabelState = defaultRootLabelValue
        }
    }


}


@Composable
fun rememberExpandableMenuState(
    @StringRes defaultRootLabelValue: Int,
    @StringRes dropDownLabelOptions: List<Int>,
    indexOfItemClicked: (Int) -> Unit,
): TaskuExpandableMenuState {
    return remember() {
        TaskuExpandableMenuState(
            defaultRootLabelValue = defaultRootLabelValue,
            dropDownLabelOptions = dropDownLabelOptions,
            chosenIndexCallback = indexOfItemClicked,
        )
    }
}

enum class SortGroup {
    AREA, PRIORITY, DATE, ALPHABET, RESET
}