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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.TaskuShapes
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.dropdown_menu.TaskuDropdownMenu
import com.thindie.design_system.string

@Composable
fun TaskuSortAndGroupRow(modifier: Modifier = Modifier) {

    val groupState = rememberExpandableMenuState(
        defaultRootLabelValue = TaskuTitles.groupBy,
        dropDownLabelOptions = listOf(TaskuTitles.Group.area, TaskuTitles.Group.priority),
        indexOfItemClicked = {})

    val sortState = rememberExpandableMenuState(
        defaultRootLabelValue = TaskuTitles.sortBy,
        dropDownLabelOptions = listOf(TaskuTitles.Sort.date, TaskuTitles.Sort.alphabet),
        indexOfItemClicked = {})


    Row(
        horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier
            .zIndex(2f)
            .fillMaxWidth()
    ) {
        SortSection(sortState)
        GroupSection(groupState)
    }

}

@Composable
fun SortSection(state: TaskuExpandableMenuState) {

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
                Text(text = state.rootLabelState.string())
            }
        }

        TaskuDropdownMenu(
            modifier = Modifier
                .width(TaskuDimensions.DropDownMenu.width),
            expanded = state.isMenuExpanded,
            onDismissRequest = state::onDismissRequest,
            color = state.dropDownBackgroundColor,
            contentVerticalPadding = TaskuDimensions.horizontalPadding,
            shape = TaskuShapes.DropDownMenuShapes.expandedDropDownMenu
        ) {

            Text(text = "@")
            Text(text = "3")
        }
    }


}


@Stable
class TaskuExpandableMenuState(
    @StringRes private val defaultRootLabelValue: Int,
    @StringRes private val dropDownLabelOptions: List<Int>,
    private val chosenIndexCallback: (Int) -> Unit,
) {


    var rootLabelState by mutableStateOf(defaultRootLabelValue)
        private set

    var isMenuExpanded by mutableStateOf(false)
        private set

    val rootElementIconState by
    derivedStateOf {
        (if (defaultRootLabelValue == rootLabelState) {
            TaskuIcons.SortGroup.expand
        } else {
            TaskuIcons.SortGroup.cancel
        })
    }


    val dropDownBackgroundColor: Color
        @Composable get() = if (isMenuExpanded) MaterialTheme.colorScheme.surfaceTint else Color.Transparent


    val rootBackgroundColor
        @Composable get() =
            if (isMenuExpanded) MaterialTheme.colorScheme.primaryContainer else Color.Transparent


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

    @Composable
    private fun getColor(predicate: Boolean): Color {
        return if (predicate)
            MaterialTheme.colorScheme.onBackground
        else MaterialTheme.colorScheme.primary
    }

}


@Composable
fun rememberExpandableMenuState(
    @StringRes defaultRootLabelValue: Int,
    @StringRes dropDownLabelOptions: List<Int>,
    indexOfItemClicked: (Int) -> Unit,
): TaskuExpandableMenuState {
    return remember {
        TaskuExpandableMenuState(
            defaultRootLabelValue = defaultRootLabelValue,
            dropDownLabelOptions = dropDownLabelOptions,
            chosenIndexCallback = indexOfItemClicked
        )
    }
}
