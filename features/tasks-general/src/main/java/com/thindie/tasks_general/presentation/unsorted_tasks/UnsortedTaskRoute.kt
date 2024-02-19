package com.thindie.tasks_general.presentation.unsorted_tasks

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.FeatureDestinationComponentInit
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.unsorted_tasks.screen.TasksGeneralScreen
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel.TasksGeneralScreenViewModel


fun NavGraphBuilder.unsortedTasks() {
    composable(route = FeatureDestination.routeUnSortTasks) {
        val factory = FeatureDestinationComponentInit()?.provideFactory()
        val timeOperator = FeatureDestinationComponentInit()?.provideTimeOperator()
        if (factory != null && timeOperator != null) {
            val viewModel: TasksGeneralScreenViewModel = viewModel(factory = factory)
            TasksGeneralScreen(
                viewModel = viewModel,
                timeOperator = timeOperator,
            )
        } else {
            error("")
        }
    }

}