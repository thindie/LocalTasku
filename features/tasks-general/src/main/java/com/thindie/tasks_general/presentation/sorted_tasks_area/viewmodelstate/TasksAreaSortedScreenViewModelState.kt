package com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodelstate

import com.thindie.common.coreartifacts.ViewState
import com.thindie.tasks_general.presentation.PresentableTask

internal data class TasksAreaSortedScreenViewModelState(
      val presentableTasks: Map<String,List<PresentableTask>>,
      val expandedIndex: Int,
    override val isLoading: Boolean,
    override val isError: Boolean,
) :  ViewState {


    override fun onError(): ViewState {
        return this.copy(isLoading = false, isError = true)
    }

    override fun onLoading(): ViewState {
        return this.copy(isLoading = true, isError = false)
    }

    override fun onSuccess(): ViewState {
        return this.copy(isLoading = false, isError = false)
    }

    companion object {
        fun getDefault() = TasksAreaSortedScreenViewModelState(
            isLoading = true,
            isError = false,
            expandedIndex = -1,
            presentableTasks = mapOf()
        )
    }
}