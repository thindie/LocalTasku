package com.thindie.tasks_costs.presentation

import androidx.lifecycle.ViewModel
import com.thindie.tasks_costs.domain.TasksCostRepository
import com.thindie.tasks_costs.presentation.viewmodelevent.TaskCostsViewModelEvent
import javax.inject.Inject

internal class TasksCostViewModel @Inject constructor(private val tasksCostRepository: TasksCostRepository) :
    ViewModel() {

    fun onEvent(taskCostsViewModelEvent: TaskCostsViewModelEvent) {
        when (taskCostsViewModelEvent) {
            TaskCostsViewModelEvent.OnSelectDay -> tasksCostRepository
            TaskCostsViewModelEvent.OnSelectMonth -> TODO()
            TaskCostsViewModelEvent.OnSelectWeek -> TODO()
            TaskCostsViewModelEvent.OnSelectYear -> TODO()
        }
    }
}