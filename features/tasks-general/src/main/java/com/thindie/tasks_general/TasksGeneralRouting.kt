package com.thindie.tasks_general

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thindie.common.di.getApp
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.design_system.elements.TaskuSortAndGroupRow
import com.thindie.tasks_general.di.TasksGeneralComponent
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.sorted_tasks_area.sortedTasksArea
import com.thindie.tasks_general.presentation.unsorted_tasks.unsortedTasks


@Composable
internal fun FeatureDestinationComponentInit(): TasksGeneralComponent? {
    return getApp()
        ?.getDependenciesProvider()
        ?.let { dependenciesProvider ->
            TasksGeneralComponent.init(dependenciesProvider)
        }
}

fun NavGraphBuilder.tasksScreenRoute() {
    composable(route = TaskuDestinations.tasksRoute) {
        val modifier: Modifier = Modifier
        val internalNavController = rememberNavController()
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            TaskuSortAndGroupRow(modifier = modifier.zIndex(2f))
            NavHost(
                modifier = modifier.zIndex(1f),
                navController = internalNavController,
                startDestination = FeatureDestination.routeUnSortTasks
            ) {
                sortedTasksArea()
                unsortedTasks()
            }
        }

    }
}


