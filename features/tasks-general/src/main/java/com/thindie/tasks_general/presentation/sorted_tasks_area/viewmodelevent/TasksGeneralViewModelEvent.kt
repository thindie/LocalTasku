package com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodelevent

import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent


sealed interface TasksAreaSortedScreenViewModelEvent {
    data class OnTaskUpdate(val event: TaskuItemEvent) : TasksAreaSortedScreenViewModelEvent
}