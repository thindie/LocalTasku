package com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.error
import com.thindie.common.coreartifacts.loading
import com.thindie.common.coreartifacts.requestFlowResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.coreartifacts.success
import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.domain.GetTasksUseCase
import com.thindie.tasks_general.domain.QuickStartTaskUseCase
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.domain.UpdateTaskUseCase
import com.thindie.tasks_general.presentation.PresentableTask
import com.thindie.tasks_general.presentation.mapper.asPresentableTask
import com.thindie.tasks_general.presentation.mapper.asTask
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelevent.TasksGeneralViewModelEvent
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelstate.TasksGeneralViewModelState
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@TasksGeneralScope
internal class TasksGeneralScreenViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val quickStartTaskUseCase: QuickStartTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
) : ViewModel(), ViewStateHolder<TasksGeneralViewModelState> {


    private val _state = MutableStateFlow(TasksGeneralViewModelState.getDefault())
    private val _expandedIndices = MutableStateFlow(setOf<Int>())

    override val state: StateFlow<TasksGeneralViewModelState> =
        _state.combine(_expandedIndices) { state, indices ->
            state.copy(presentableTasks = state.presentableTasks.mapIndexed { index, presentableTask ->
                if (indices.contains(index)) {
                    presentableTask.copy(isTaskExpanded = true)
                } else presentableTask.copy(isTaskExpanded = false)
            })
        }.subscribeControlledStateFlow(viewModelScope, TasksGeneralViewModelState.getDefault())


    override fun onError() {
        _state.error()
    }

    override fun onLoading() {
        _state.loading()
    }


    private fun getContacts() {
        requestFlowResultAndParse(request = getTasksUseCase::observe, onSuccess = { incomingList ->
            _state.update { stateToUpdate ->
                _state.success()
                stateToUpdate.copy(presentableTasks = incomingList.map(Task::asPresentableTask))
            }
        })
    }

    fun onEvent(event: TasksGeneralViewModelEvent) {
        when (event) {
            is TasksGeneralViewModelEvent.OnTaskUpdate -> {
                onTaskuItemEvent(event.event)
            }

            TasksGeneralViewModelEvent.OnSortAlphabet -> {
                getDefaultPresentableTasksState()
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    val list =
                        tasksGeneralViewModelState.presentableTasks.sortedBy { it.taskTitle } //todo
                    tasksGeneralViewModelState.copy(presentableTasks = list)
                }
            }

            TasksGeneralViewModelEvent.OnSortDate -> {
                getDefaultPresentableTasksState()
                _state.getAndUpdate { tasksGeneralViewModelState ->
                    val list =
                        tasksGeneralViewModelState.presentableTasks.sortedBy { it.taskDeadline } //todo
                    tasksGeneralViewModelState.copy(presentableTasks = list)
                }
            }

            TasksGeneralViewModelEvent.OnStartDefault -> {
                getContacts()
            }

            TasksGeneralViewModelEvent.OnCreateTask -> {
                onTaskuItemEvent(TaskuItemEvent.OnCollapseAll)
                viewModelScope.launch {
                    quickStartTaskUseCase.set()
                    expandLastPresentableTaskInList()
                }

            }
        }
    }

    private fun tasksListSize(): Int {
        return _state.value.presentableTasks.size
    }

    private fun expandLastPresentableTaskInList() {
        onEvent(
            TasksGeneralViewModelEvent.OnTaskUpdate(
                TaskuItemEvent.OnClick(tasksListSize())
            )
        )
    }

    private fun getDefaultPresentableTasksState() {
        onEvent(TasksGeneralViewModelEvent.OnStartDefault)
    }

    private fun onTaskuItemEvent(taskuItemEvent: TaskuItemEvent) {
        viewModelScope.launch {
            when (taskuItemEvent) {
                is TaskuItemEvent.OnChangeCredits -> {
                    val presentableTask =
                        getPresentableTask(taskuItemEvent.index)
                            .copy(taskCredits = taskuItemEvent.credits.toIntOrNull())
                    updateTaskUseCase.update(presentableTask.asTask())
                }

                is TaskuItemEvent.OnChangeDescription -> {
                    val presentableTask =
                        getPresentableTask(taskuItemEvent.index)
                            .copy(taskDescription = taskuItemEvent.description)
                    updateTaskUseCase.update(presentableTask.asTask())
                }

                is TaskuItemEvent.OnChangeTitle -> {
                    val presentableTask =
                        getPresentableTask(taskuItemEvent.index)
                            .copy(taskTitle = taskuItemEvent.title)
                    updateTaskUseCase.update(presentableTask.asTask())
                }

                is TaskuItemEvent.OnClick -> {
                    _expandedIndices.update { indices ->
                        indices.addOrRemove(taskuItemEvent.index)
                    }
                }

                is TaskuItemEvent.OnClickPicture -> {}
                TaskuItemEvent.OnCollapseAll -> {
                    _expandedIndices.update {
                        setOf()
                    }
                }
            }
        }
    }

    private fun currentPresentableTasks(): List<PresentableTask> {
        return _state.value.presentableTasks
    }

    private fun getPresentableTask(index: Int) = currentPresentableTasks()[index]
    private fun <T> Set<T>.addOrRemove(t: T): Set<T> {
        val updatedSet = toMutableSet()
        if (updatedSet.add(t).not()) {
            updatedSet.remove(t)
        }
        return updatedSet
    }
}