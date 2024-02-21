package com.thindie.tasks_general.presentation.sorted_tasks_priority

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.FeatureDestinationComponentInit
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.sorted_tasks_priority.screen.TasksPrioritySortedScreen
import com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodel.TasksPrioritySortedScreenViewModel
import com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodelevent.TasksPrioritySortedScreenViewModelEvent

fun NavGraphBuilder.sortedTasksPriority() {
    composable(route = FeatureDestination.routePrioritySortedTasks) {
        val factory = FeatureDestinationComponentInit()?.provideFactory()
        val timeOperator = FeatureDestinationComponentInit()?.provideTimeOperator()
        if (factory != null && timeOperator != null) {
            val viewModel: TasksPrioritySortedScreenViewModel = viewModel(factory = factory)

            LaunchedEffect(key1 = Unit, block = {
                viewModel.onEvent(
                    TasksPrioritySortedScreenViewModelEvent.OnStartDefault
                )
            })

            TasksPrioritySortedScreen(
                viewModel = viewModel,
                timeOperator = timeOperator,
            )
        } else {
            error("")
        }
    }

}
