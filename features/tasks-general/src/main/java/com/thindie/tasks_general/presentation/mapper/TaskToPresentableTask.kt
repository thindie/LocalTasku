package com.thindie.tasks_general.presentation.unsorted_tasks.mapper

import com.thindie.design_system.TaskStatusType
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.presentation.PresentableTask

internal fun Task.asPresentableTask() = PresentableTask(
    taskId = getId(),
    taskTitle = getName(),
    taskDescription = getDescription(),
    taskDeadline = getPlannedTimeStampMillis(),
    taskGroupTitle = getGrouping(),
    taskStatusType = TaskStatusType.getInstance(getAssign()),
    isTaskExpanded = false
)