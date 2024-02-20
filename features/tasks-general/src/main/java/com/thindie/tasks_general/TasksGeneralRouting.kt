package com.thindie.tasks_general

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thindie.common.di.getApp
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.design_system.TaskuColorAlphas
import com.thindie.design_system.TaskuAnimationsSpec
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.elements.SortGroup
import com.thindie.design_system.elements.TaskuSortAndGroupRow
import com.thindie.tasks_general.di.TasksGeneralComponent
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.feature_navigation.areaSortedTasks
import com.thindie.tasks_general.feature_navigation.unsortedTasks
import com.thindie.tasks_general.presentation.sorted_tasks_area.sortedTasksArea
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

        var currentDestination by remember {
            mutableStateOf(FeatureDestination.routeUnSortTasks)
        }

        internalNavController.addOnDestinationChangedListener { _, destination, _ ->
            currentDestination = destination.route.orEmpty()
        }

        val shouldBeDefault by remember {
            derivedStateOf { currentDestination == FeatureDestination.routeUnSortTasks }
        }


        Column(modifier = modifier.fillMaxSize()) {
            TaskuSortAndGroupRow(
                onSortGroup = { event ->
                    actionSortGroup(event, navController = internalNavController)
                },
                shouldBeDefault = shouldBeDefault,
            )
            SectionsDivider(modifier = modifier)
            NavHost(modifier = modifier.zIndex(1f),
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
                unsortedTasks()
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


private fun actionSortGroup(sortGroup: SortGroup, navController: NavController) {
    when (sortGroup) {
        SortGroup.AREA -> {
            navController.areaSortedTasks()
        }

        SortGroup.PRIORITY -> TODO()
        SortGroup.DATE -> TODO()
        SortGroup.ALPHABET -> TODO()
        SortGroup.RESET -> {
            navController.unsortedTasks()
        }
    }
}

