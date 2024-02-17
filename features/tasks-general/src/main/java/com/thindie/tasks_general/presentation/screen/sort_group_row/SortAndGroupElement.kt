package com.thindie.tasks_general.presentation.screen.sort_group_row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.rememberDimmingState
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.rememberGenericDimMediator
import com.thindie.design_system.string
import kotlinx.coroutines.delay

@Composable
internal fun SortAndGroupSection(
    modifier: Modifier = Modifier,
    areaGroups: List<String>,
    priorityGrade: List<Int>,
    onEvent: (SortAndGroupEvent) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SortSection(onEvent)
        GroupSection(priorityGrade, areaGroups, onEvent)
    }
}

@Composable
internal fun GroupSection(
    priorityGrade: List<Int>,
    areaGroups: List<String>,
    onEvent: (SortAndGroupEvent) -> Unit,
) {


    var isGroupSectionChosen: Boolean? by remember {
        mutableStateOf(null)
    }

    var groupingTitle: String by remember {
        mutableStateOf("")
    }


    if (isGroupSectionChosen == null) {
        AwaitState(
            title = TaskuTitles.titleGroupBy.string(),
            onClick = { isGroupSectionChosen = false })
    }

    if (isGroupSectionChosen == false) {

            ExpandedState(
                priorityGrade = priorityGrade,
                areaGroups = areaGroups,
                onEvent = onEvent,
                onDismiss = { isGroupSectionChosen = null },
                onClick = { selectedTitle ->
                    groupingTitle = selectedTitle
                    isGroupSectionChosen = true
                })

    }

    if (isGroupSectionChosen == true) {
        ChosenState(title = groupingTitle, onClick = {})
    }

}

@Composable
internal fun ExpandedState(
    priorityGrade: List<Int>,
    areaGroups: List<String>,
    onEvent: (SortAndGroupEvent) -> Unit,
    onDismiss: () -> Unit,
    onClick: (String) -> Unit,
) {
    var shouldExpand by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true, block = { delay(100); shouldExpand = true })
    DropdownMenu(
        expanded = shouldExpand,
        onDismissRequest = { shouldExpand = false; onDismiss() }) {
        buildList {
            repeat(5) {
                this.add(it.toString())
            }
        }.forEach {
            Text(it)
        }
    }
}

@Composable
internal fun ChosenState(title: String, onClick: () -> Unit) {
    ClickableText(text = AnnotatedString(title), onClick = { onClick() })
}

@Composable
internal fun AwaitState(title: String, onClick: () -> Unit) {
    ClickableText(text = AnnotatedString(title), onClick = { onClick() })
}

@Composable
internal fun SortSection(onEvent: (SortAndGroupEvent) -> Unit) {
}
