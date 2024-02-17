package com.thindie.tasks_general.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.thindie.design_system.Expandable
import com.thindie.design_system.Presentable
import com.thindie.design_system.TaskStatusType
import com.thindie.domain.entities.behavior.Descriptionable
import com.thindie.domain.entities.behavior.Groupable
import com.thindie.domain.entities.behavior.Nameable
import com.thindie.domain.entities.behavior.Planable
import com.thindie.domain.entities.behavior.Uniqable

internal data class PresentableTask(
    val taskId: Long,
    val taskTitle: String,
    val taskDescription: String,
    val taskDeadline: Long,
    val taskGroupTitle: String,
    val taskStatusType: TaskStatusType,
    val isTaskExpanded: Boolean,
) : Presentable, Nameable, Descriptionable, Uniqable, Planable, Groupable, Expandable {
    override fun presentTitle() = taskTitle

    override fun presentDescription() = taskDescription

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
}