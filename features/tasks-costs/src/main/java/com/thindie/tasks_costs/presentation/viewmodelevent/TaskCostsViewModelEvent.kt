package com.thindie.tasks_costs.presentation.viewmodelevent

sealed interface TaskCostsViewModelEvent {
    data object OnSelectMonth : TaskCostsViewModelEvent
    data object OnSelectYear : TaskCostsViewModelEvent

    data object OnSelectWeek : TaskCostsViewModelEvent

    data object OnSelectDay : TaskCostsViewModelEvent
}