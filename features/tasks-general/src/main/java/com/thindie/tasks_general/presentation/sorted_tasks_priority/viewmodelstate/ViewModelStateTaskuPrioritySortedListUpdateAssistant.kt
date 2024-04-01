package com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodelstate

import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelstate.TasksGeneralViewModelState
import javax.inject.Inject

@TasksGeneralScope
internal class ViewModelStateTaskuPrioritySortedListUpdateAssistant @Inject constructor() {

    fun onTaskuEvent(
        taskuCardEvent: TaskuItemEvent,
        viewModelState: TasksGeneralViewModelState,
    ): TasksGeneralViewModelState {
        return when (taskuCardEvent) {
            is TaskuItemEvent.OnChangeDescription -> {

                viewModelState.copy(
                    presentableTasks = viewModelState.presentableTasks.mapIndexed { index, presentableTask ->
                        if (taskuCardEvent.index == index) {
                            presentableTask.copy(taskDescription = taskuCardEvent.description)
                        } else {
                            presentableTask
                        }
                    }
                )

            }

            is TaskuItemEvent.OnChangeTitle -> {

                viewModelState.copy(
                    presentableTasks = viewModelState.presentableTasks.mapIndexed { index, presentableTask ->
                        if (taskuCardEvent.index == index) {
                            presentableTask.copy(taskTitle = taskuCardEvent.title)
                        } else {
                            presentableTask
                        }
                    }
                )
            }


            is TaskuItemEvent.OnClick -> {
                val taskList =
                    viewModelState.presentableTasks.mapIndexed { index, presentableTask ->
                        if (taskuCardEvent.index == index) {
                            presentableTask.copy(isTaskExpanded = !presentableTask.isExpanded())
                        } else {
                            presentableTask
                        }
                    }

                viewModelState.copy(
                    presentableTasks = taskList,
                    expandedIndex = taskuCardEvent.index
                )
            }

            is TaskuItemEvent.OnClickPicture -> {
                error("Not implemented yet")
            }

            is TaskuItemEvent.OnCollapseAll -> {
                val taskList =
                    viewModelState.presentableTasks.map { presentableTask ->
                        presentableTask.copy(isTaskExpanded = false)
                    }

                viewModelState.copy(
                    presentableTasks = taskList,
                    expandedIndex = -1
                )
            }
            is TaskuItemEvent.OnChangeCredits -> {
                viewModelState.copy(
                    presentableTasks = viewModelState.presentableTasks.mapIndexed { index, presentableTask ->
                        if (taskuCardEvent.index == index) {
                            presentableTask.copy(taskCredits = taskuCardEvent.credits.toIntOrNull())
                        } else {
                            presentableTask
                        }
                    }
                )
            }
        }
    }
}