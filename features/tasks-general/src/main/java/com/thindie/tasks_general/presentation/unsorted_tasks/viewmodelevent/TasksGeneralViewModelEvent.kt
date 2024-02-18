package com.thindie.tasks_general.presentation.unsorted_tasks.viewmodelevent

import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent

sealed interface TasksGeneralViewModelEvent {
    data class OnTaskUpdate(val event: TaskuItemEvent) : TasksGeneralViewModelEvent
}