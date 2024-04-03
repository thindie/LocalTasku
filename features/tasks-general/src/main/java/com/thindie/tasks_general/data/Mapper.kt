package com.thindie.tasks_general.data

import com.thindie.database.entities.LocalSourceEntity
import com.thindie.tasks_general.domain.Task

fun LocalSourceEntity.map(): Task = Task(
    taskId = getId(),
    taskTitle = getName(),
    taskDescription = getDescription(),
    taskDeadline = getPlannedTimeStampMillis(),
    taskGroupTitle = getGrouping(),
    taskStatusAssign = getAssign(),
    taskPriority = getPrior(),
    taskCost = getCost(),
    taskCreationTime = getTrackPoint()
)

fun Task.map(): LocalSourceEntity = object : LocalSourceEntity {
    override fun getName() = this@map.getName()

    override fun getDescription() = this@map.getDescription()

    override fun getPlannedTimeStampMillis() = this@map.getPlannedTimeStampMillis()

    override fun getId() = this@map.getId()

    override fun getGrouping() = this@map.getGrouping()

    override fun isGrouped() = this@map.isGrouped()

    override fun getAssign() = this@map.getAssign()

    override fun getPrior() = this@map.getPrior()

    override fun getTrackPoint() = this@map.getTrackPoint()

    override fun getCost() = this@map.getCost()

}
