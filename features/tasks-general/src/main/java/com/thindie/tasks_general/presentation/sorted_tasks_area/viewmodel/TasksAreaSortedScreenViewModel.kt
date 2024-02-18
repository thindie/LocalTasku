package com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.error
import com.thindie.common.coreartifacts.loading
import com.thindie.common.coreartifacts.requestResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.coreartifacts.success
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.domain.GetTasksUseCase
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.presentation.PresentableTask
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodelevent.TasksAreaSortedScreenViewModelEvent
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodelstate.TasksAreaSortedScreenViewModelState
import com.thindie.tasks_general.presentation.unsorted_tasks.mapper.asPresentableTask
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

@TasksGeneralScope
internal class TasksAreaSortedScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
) : ViewModel(), ViewStateHolder<TasksAreaSortedScreenViewModelState> {


    private val _state = MutableStateFlow(TasksAreaSortedScreenViewModelState.getDefault())

    override val state: StateFlow<TasksAreaSortedScreenViewModelState> = _state
        .subscribeControlledStateFlow(viewModelScope)

    fun onLaunchScreen() {
        getContacts()
    }

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
                        .groupBy(PresentableTask::taskGroupTitle)
                )
            }
        })
    }

    fun onEvent(event: TasksAreaSortedScreenViewModelEvent) {
        when (event) {
            is TasksAreaSortedScreenViewModelEvent.OnTaskUpdate -> {
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    tasksGeneralViewModelState // todo(
                }
            }
        }
    }

}