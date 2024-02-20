package com.thindie.tasks_general.domain

import com.thindie.domain.entities.behavior.Assignable
import com.thindie.domain.entities.behavior.Descriptionable
import com.thindie.domain.entities.behavior.Groupable
import com.thindie.domain.entities.behavior.Nameable
import com.thindie.domain.entities.behavior.Planable
import com.thindie.domain.entities.behavior.Priorable
import com.thindie.domain.entities.behavior.Uniqable

data class Task(
    val taskId: Long,
    val taskTitle: String,
    val taskDescription: String,
    val taskDeadline: Long,
    val taskGroupTitle: String,
    val taskStatusAssign: Int,
    val taskPriority: Int,
) : Nameable, Descriptionable, Planable, Uniqable, Groupable, Assignable, Priorable {
    override fun getDescription() = taskDescription

    override fun getGrouping() = taskGroupTitle

    override fun isGrouped() = taskGroupTitle.isNotBlank()

    override fun getName() = taskTitle

    override fun getPlannedTimeStampMillis() = taskDeadline

    override fun getId() = taskId
    override fun getAssign() = taskStatusAssign
    override fun getPrior() = taskPriority
}