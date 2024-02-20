package com.thindie.tasks_general.presentation.sorted_tasks_priority.viewmodelevent

import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent


sealed interface TasksPrioritySortedScreenViewModelEvent {
    data class OnTaskUpdate(val event: TaskuItemEvent) : TasksPrioritySortedScreenViewModelEvent
}