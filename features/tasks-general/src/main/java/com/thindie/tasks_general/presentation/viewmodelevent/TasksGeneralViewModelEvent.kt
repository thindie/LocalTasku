package com.thindie.tasks_general.presentation.viewmodelevent

import com.thindie.design_system.elements.tasku_item_utils.TaskuItemEvent
import com.thindie.tasks_general.presentation.screen.sort_group_row.SortAndGroupEvent

sealed interface TasksGeneralViewModelEvent {
    data class OnTaskUpdate(val event: TaskuItemEvent) : TasksGeneralViewModelEvent
    data class OnTaskListRenewResponse(val event: SortAndGroupEvent): TasksGeneralViewModelEvent
}