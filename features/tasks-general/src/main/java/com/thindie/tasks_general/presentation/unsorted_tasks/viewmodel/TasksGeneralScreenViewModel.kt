package com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel

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
import com.thindie.tasks_general.presentation.mapper.asPresentableTask
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelevent.TasksGeneralViewModelEvent
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelstate.TasksGeneralViewModelState
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelstate.ViewModelStateTaskuListUpdateAssistant
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

@TasksGeneralScope
internal class TasksGeneralScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val taskuEventReceiver: ViewModelStateTaskuListUpdateAssistant,
) : ViewModel(), ViewStateHolder<TasksGeneralViewModelState> {


    private val _state = MutableStateFlow(TasksGeneralViewModelState.getDefault())

    override val state: StateFlow<TasksGeneralViewModelState> = _state
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
                )
            }
        })
    }

    fun onEvent(event: TasksGeneralViewModelEvent) {
        when (event) {
            is TasksGeneralViewModelEvent.OnTaskUpdate -> {
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    taskuEventReceiver.onTaskuEvent(event.event, tasksGeneralViewModelState)
                }
            }

            TasksGeneralViewModelEvent.OnSortAlphabet -> {
                onEvent(TasksGeneralViewModelEvent.OnStartDefault)
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    val list =
                        tasksGeneralViewModelState.presentableTasks.sortedBy { it.taskTitle } //todo
                    tasksGeneralViewModelState.copy(presentableTasks = list)
                }
            }

            TasksGeneralViewModelEvent.OnSortDate -> {
                onEvent(TasksGeneralViewModelEvent.OnStartDefault)
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    val list =
                        tasksGeneralViewModelState.presentableTasks.sortedBy { it.taskDeadline } //todo
                    tasksGeneralViewModelState.copy(presentableTasks = list)
                }
            }

            TasksGeneralViewModelEvent.OnStartDefault -> {
                getContacts()
            }
        }
    }

}