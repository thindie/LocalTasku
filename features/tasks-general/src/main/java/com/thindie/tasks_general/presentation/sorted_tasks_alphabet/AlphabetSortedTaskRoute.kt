package com.thindie.tasks_general.presentation.sorted_tasks_alphabet

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.tasks_general.FeatureDestinationComponentInit
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.presentation.unsorted_tasks.screen.TasksGeneralScreen
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel.TasksGeneralScreenViewModel
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelevent.TasksGeneralViewModelEvent

fun NavGraphBuilder.sortedTasksAlphabet() {
    composable(route = FeatureDestination.alphabetSortedTasks) {
        val factory = FeatureDestinationComponentInit()?.provideFactory()
        val timeOperator = FeatureDestinationComponentInit()?.provideTimeOperator()
        if (factory != null && timeOperator != null) {
            val viewModel: TasksGeneralScreenViewModel = viewModel(factory = factory)

            LaunchedEffect(
                key1 = Unit,
                block = { viewModel.onEvent(TasksGeneralViewModelEvent.OnSortAlphabet) })

            TasksGeneralScreen(
                viewModel = viewModel,
                timeOperator = timeOperator,
            )
        } else {
            error("")
        }
    }

}