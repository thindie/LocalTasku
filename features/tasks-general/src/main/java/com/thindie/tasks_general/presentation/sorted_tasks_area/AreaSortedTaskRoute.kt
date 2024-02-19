package com.thindie.tasks_general.presentation.sorted_tasks_area

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.FeatureDestinationComponentInit
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.sorted_tasks_area.screen.TasksAreaSortedScreen
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodel.TasksAreaSortedScreenViewModel

fun NavGraphBuilder.sortedTasksArea() {
    composable(route = FeatureDestination.routeAreaSortedTasks) {
        val factory = FeatureDestinationComponentInit()?.provideFactory()
        val timeOperator = FeatureDestinationComponentInit()?.provideTimeOperator()
        if (factory != null && timeOperator != null) {
            val viewModel: TasksAreaSortedScreenViewModel = viewModel(factory = factory)
            TasksAreaSortedScreen(
                viewModel = viewModel,
                timeOperator = timeOperator,
            )
        } else {
            error("")
        }
    }

}