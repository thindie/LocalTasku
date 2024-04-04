package com.thindie.tasks_general.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.thindie.design_system.Expandable
import com.thindie.design_system.Presentable
import com.thindie.design_system.TaskPriorityType
import com.thindie.design_system.TaskStatusType
import com.thindie.domain.entities.behavior.Descriptionable
import com.thindie.domain.entities.behavior.Groupable
import com.thindie.domain.entities.behavior.Nameable
import com.thindie.domain.entities.behavior.Planable
import com.thindie.domain.entities.behavior.Spendable
import com.thindie.domain.entities.behavior.Trackable
import com.thindie.domain.entities.behavior.Uniqable

internal data class PresentableTask(
    val taskId: Long,
    val taskTitle: String,
    val taskDescription: String,
    val taskDeadline: Long,
    val taskGroupTitle: String,
    val taskStatusType: TaskStatusType,
    val taskPriorityType: TaskPriorityType,
    val isTaskExpanded: Boolean,
    val taskCredits: Int? = null,
    val creationTime: Long,
) : Presentable, Nameable, Descriptionable, Uniqable, Planable, Groupable, Expandable, Spendable,
    Trackable {
    override fun presentTitle() = taskTitle

    override fun presentDescription() = taskDescription
    override fun presentCredits(): String {
        return getCost()?.let {
            it.toString()
        }.orEmpty()
    }

    @Composable
    override fun presentPicture(): Painter {
        return taskStatusType.getStatusImage()
    }

    override fun getDescription() = taskDescription

    override fun getGrouping() = taskGroupTitle

    override fun isGrouped() = taskGroupTitle.isNotBlank()

    override fun getName() = taskTitle

    override fun getPlannedTimeStampMillis() = taskDeadline

    override fun getId() = taskId
    override fun isExpanded() = isTaskExpanded
    override fun getCost() = taskCredits
    override fun getTrackPoint() = creationTime
}