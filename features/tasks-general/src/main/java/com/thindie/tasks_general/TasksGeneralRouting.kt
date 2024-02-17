package com.thindie.tasks_general

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.presentation.viewmodel.TasksGeneralScreenViewModel
import com.thindie.common.di.getApp
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.tasks_general.di.TasksGeneralComponent
import com.thindie.tasks_general.presentation.screen.TasksGeneralScreen

fun NavGraphBuilder.tasksGeneral(
    onRouteLoaded: () -> Unit,
) {
    composable(route = TaskuDestinations.tasksGeneral) {
        onRouteLoaded()

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

@Composable
private fun FeatureDestinationComponentInit(): TasksGeneralComponent? {
    return getApp()
        ?.getDependenciesProvider()
        ?.let { dependenciesProvider ->
            TasksGeneralComponent.init(dependenciesProvider)
        }
}
