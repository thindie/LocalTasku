package com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.error
import com.thindie.common.coreartifacts.loading
import com.thindie.common.coreartifacts.requestResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.coreartifacts.success
import com.thindie.design_system.TaskPriorityType
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.domain.GetTasksUseCase
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.presentation.PresentableTask
import com.thindie.tasks_general.presentation.mapper.asPresentableTask
import com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodelevent.TasksPrioritySortedScreenViewModelEvent
import com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodelstate.TasksPrioritySortedScreenViewModelState
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

@TasksGeneralScope
internal class TasksPrioritySortedScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
) : ViewModel(), ViewStateHolder<TasksPrioritySortedScreenViewModelState> {


    private val _state = MutableStateFlow(TasksPrioritySortedScreenViewModelState.getDefault())

    override val state: StateFlow<TasksPrioritySortedScreenViewModelState> = _state
        .subscribeControlledStateFlow(viewModelScope)


    override fun onError() {
        _state.error()
    }

    override fun onLoading() {
        _state.loading()
    }


    private fun getContacts() {
        requestResultAndParse(request = getTasksUseCase::get, onSuccess = {
            _state.update { stateToUpdate ->
                _state.success()
                stateToUpdate.copy(
                    presentableTasks = it.map(Task::asPresentableTask)
                        .groupBy(PresentableTask::byTaskPriority)
                )
            }
        })
    }

    fun onEvent(event: TasksPrioritySortedScreenViewModelEvent) {
        when (event) {
            is TasksPrioritySortedScreenViewModelEvent.OnTaskUpdate -> {
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    tasksGeneralViewModelState // todo(
                }
            }

            TasksPrioritySortedScreenViewModelEvent.OnStartDefault -> {
                getContacts()
            }
        }
    }

}

private fun PresentableTask.byTaskPriority(): TaskPriorityType {
    return taskPriorityType
}