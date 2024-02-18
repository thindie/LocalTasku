package com.thindie.tasks_general.presentation.sorted_tasks_area.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.design_system.elements.TaskuItem
import com.thindie.design_system.elements.dim_wrapper.itemsMap
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodel.TasksAreaSortedScreenViewModel
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodelevent.TasksAreaSortedScreenViewModelEvent


@Composable
internal fun TasksAreaSortedScreen(
    timeOperator: TimeOperator,
    viewModel: TasksAreaSortedScreenViewModel,

    ) {
    LaunchedEffect(key1 = Unit, block = { viewModel.onLaunchScreen() })

    val viewState by viewModel
        .state
        .collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)


    LazyColumn(
        Modifier
            .background(MaterialTheme.colorScheme.background)
            .height(600.dp)

    ) {
        itemsMap(
            viewState.presentableTasks, headerContent = {
                Text(text = it)
            }) {

            it.forEachIndexed() { i, item ->
                TaskuItem(
                    expandable = item,
                    index = i,
                    item = item,
                    onEvent = {
                        viewModel.onEvent(
                            TasksAreaSortedScreenViewModelEvent.OnTaskUpdate(it)
                        )
                    })
            }
        }
    }
}