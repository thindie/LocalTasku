package com.thindie.tasks_general.presentation.sorted_tasks_priority

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.FeatureDestinationComponentInit
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.sorted_tasks_priority.screen.TasksPrioritySortedScreen
import com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodel.TasksPrioritySortedScreenViewModel

fun NavGraphBuilder.sortedTasksPriority() {
    composable(route = FeatureDestination.routePrioritySortedTasks) {
        val factory = FeatureDestinationComponentInit()?.provideFactory()
        val timeOperator = FeatureDestinationComponentInit()?.provideTimeOperator()
        if (factory != null && timeOperator != null) {
            val viewModel: TasksPrioritySortedScreenViewModel = viewModel(factory = factory)
            TasksPrioritySortedScreen(
                viewModel = viewModel,
                timeOperator = timeOperator,
            )
        } else {
            error("")
        }
    }

}
