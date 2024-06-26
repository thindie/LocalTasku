package com.thindie.tasks_general.presentation.mapper

import com.thindie.design_system.TaskPriorityType
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
    isTaskExpanded = false,
    taskPriorityType = TaskPriorityType.getInstance(getPrior()),
    creationTime = getTrackPoint(),
    taskCredits = getCost()
)

internal fun PresentableTask.asTask() = Task(
    taskId = getId(),
    taskTitle = getName(),
    taskDescription = getDescription(),
    taskDeadline = getPlannedTimeStampMillis(),
    taskGroupTitle = getGrouping(),
    taskStatusAssign = taskStatusType.getStatusBind(),
    taskPriority = taskPriorityType.getPriorityBind(),
    taskCost = getCost(),
    taskCreationTime = getTrackPoint()
)