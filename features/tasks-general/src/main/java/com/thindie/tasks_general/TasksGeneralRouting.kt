package com.thindie.tasks_general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thindie.common.di.getApp
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.design_system.TaskuAnimationsSpec
import com.thindie.design_system.TaskuColorAlphas
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.elements.SortGroup
import com.thindie.design_system.elements.TaskuSortAndGroupRow
import com.thindie.tasks_general.di.TasksGeneralComponent
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.sort_and_group_state.SortAndGroupViewModel
import com.thindie.tasks_general.presentation.sort_and_group_state.SortAndGroupViewModelEvent
import com.thindie.tasks_general.presentation.sort_and_group_state.mapper.getGroupApplyable
import com.thindie.tasks_general.presentation.sort_and_group_state.mapper.getSortApplyable
import com.thindie.tasks_general.presentation.sorted_tasks_alphabet.sortedTasksAlphabet
import com.thindie.tasks_general.presentation.sorted_tasks_area.sortedTasksArea
import com.thindie.tasks_general.presentation.sorted_tasks_date.sortedTasksDate
import com.thindie.tasks_general.presentation.sorted_tasks_priority.sortedTasksPriority
import com.thindie.tasks_general.presentation.unsorted_tasks.unsortedTasks


@Composable
internal fun FeatureDestinationComponentInit(): TasksGeneralComponent? {
    return getApp()?.getDependenciesProvider()?.let { dependenciesProvider ->
        TasksGeneralComponent.init(dependenciesProvider)
    }
}

fun NavGraphBuilder.tasksScreenRoute() {
    composable(route = TaskuDestinations.tasksRoute) {

        val internalNavController = rememberNavController()
        val modifier: Modifier = Modifier

        val sortAndGroupViewModel = SortAndGroupViewModel.rememberInstance(
            navController = internalNavController
        )

        val sortAndGroupState by sortAndGroupViewModel.state.collectAsStateWithLifecycle(
            minActiveState = Lifecycle.State.RESUMED
        )


        Column(modifier = modifier
            .padding(TaskuDimensions.Padding.commonValues)
            .fillMaxSize()) {
            TaskuSortAndGroupRow(
                onEvent = { event ->
                    event.passToEventOperator(sortAndGroupViewModel::onEvent)
                },
                sortApplyable = sortAndGroupState.getSortApplyable(),
                groupApplyable = sortAndGroupState.getGroupApplyable(),
            )
            SectionsDivider(modifier = modifier)
            NavHost(modifier = modifier

                .zIndex(1f),
                navController = internalNavController,
                startDestination = FeatureDestination.routeUnSortTasks,
                enterTransition = {
                    TaskuAnimationsSpec.NavTransitions.fadeIn
                },
                exitTransition = {
                    TaskuAnimationsSpec.NavTransitions.fadeOut
                }

            ) {
                sortedTasksArea()
                sortedTasksPriority()
                unsortedTasks()
                sortedTasksDate()
                sortedTasksAlphabet()
            }
        }
    }
}

@Composable
private fun SectionsDivider(modifier: Modifier) {
    Spacer(modifier = modifier.height(TaskuDimensions.Spacing.near))
    Divider(
        modifier = modifier.fillMaxWidth(),
        thickness = Dp.Hairline,
        color = LocalContentColor.current.copy(TaskuColorAlphas.basic)
    )
    Spacer(modifier = modifier.height(TaskuDimensions.Spacing.usual))
}

private fun SortGroup.passToEventOperator(foo: (SortAndGroupViewModelEvent) -> Unit) {
    when (this) {
        SortGroup.AREA -> foo.invoke(SortAndGroupViewModelEvent.OnClickArea)
        SortGroup.PRIORITY -> foo.invoke(SortAndGroupViewModelEvent.OnClickPriority)
        SortGroup.DATE -> foo.invoke(SortAndGroupViewModelEvent.OnClickDate)
        SortGroup.ALPHABET -> foo.invoke(SortAndGroupViewModelEvent.OnClickAlphabet)
        SortGroup.RESET -> foo.invoke(SortAndGroupViewModelEvent.Root)
        SortGroup.EXPAND_SORT -> foo.invoke(SortAndGroupViewModelEvent.ExpandSort)
        SortGroup.UNEXPAND_SORT -> foo.invoke(SortAndGroupViewModelEvent.UnExpandSort)
        SortGroup.EXPAND_GROUP -> foo.invoke(SortAndGroupViewModelEvent.ExpandGroup)
        SortGroup.UNEXPAND_GROUP -> foo.invoke(SortAndGroupViewModelEvent.UnExpandGroup)
    }
}



