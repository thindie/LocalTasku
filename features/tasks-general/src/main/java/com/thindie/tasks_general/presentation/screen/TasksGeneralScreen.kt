package com.thindie.tasks_general.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.design_system.elements.TaskuItem
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.rememberDimmingState
import com.thindie.design_system.elements.dim_wrapper.dimwrapperstate.rememberGenericDimMediator
import com.thindie.design_system.elements.generic_content.TaskuGenericDimWrapperContent
import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent
import com.thindie.tasks_general.presentation.screen.sort_group_row.SortAndGroupSection
import com.thindie.tasks_general.presentation.viewmodel.TasksGeneralScreenViewModel
import com.thindie.tasks_general.presentation.viewmodelevent.TasksGeneralViewModelEvent


@Composable
internal fun TasksGeneralScreen(
    timeOperator: TimeOperator,
    viewModel: TasksGeneralScreenViewModel,

    ) {
    LaunchedEffect(key1 = Unit, block = { viewModel.onLaunchScreen() })

    val viewState by viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)
    val dimState =
        rememberDimmingState(notifyDimDismissed =
        {
            viewModel.onEvent(TasksGeneralViewModelEvent.OnTaskUpdate(TaskuItemEvent.OnCollapseAll))
        })


    TaskuGenericDimWrapperContent(dimState = dimState) {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .height(600.dp)
                .verticalScroll(rememberScrollState())
        ) {

            SortAndGroupSection(areaGroups = listOf(), priorityGrade = listOf(), onEvent = {})

            Spacer(modifier = Modifier.height(30.dp))

            viewState.presentableTasks.forEachIndexed { i, item ->
                val mediator = rememberGenericDimMediator(state = dimState)

                TaskuItem(
                    modifier = Modifier.onGloballyPositioned {
                        mediator.setOffset(it.positionInRoot())
                    },
                    expandable = item,
                    index = i,
                    item = item,
                    onEvent = {
                        viewModel.onEvent(
                            TasksGeneralViewModelEvent.OnTaskUpdate(it)
                        )
                    })

            }
        }
    }
}
