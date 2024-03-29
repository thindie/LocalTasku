package com.thindie.tasks_general.presentation.unsorted_tasks.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.elements.TaskuFab
import com.thindie.design_system.elements.TaskuItem
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel.TasksGeneralScreenViewModel
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelevent.TasksGeneralViewModelEvent


@Composable
internal fun TasksGeneralScreen(
    timeOperator: TimeOperator,
    viewModel: TasksGeneralScreenViewModel,

    ) {
    val viewState
            by viewModel
                .state
                .collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(TaskuDimensions.Padding.horizontal)
                .background(MaterialTheme.colorScheme.background)
                .height(600.dp)
                .verticalScroll(rememberScrollState())
        ) {


            Spacer(modifier = Modifier.height(30.dp))

            viewState.presentableTasks.forEachIndexed { i, item ->

                TaskuItem(
                    expandable = item,
                    index = i,
                    item = item,
                    onEvent = {
                        viewModel.onEvent(
                            TasksGeneralViewModelEvent.OnTaskUpdate(it)
                        )
                    })
                Spacer(modifier = Modifier.height(TaskuDimensions.Padding.vertical))
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
        TaskuFab(onClick = { viewModel.onEvent(TasksGeneralViewModelEvent.OnCreateTask) })
    }
}


