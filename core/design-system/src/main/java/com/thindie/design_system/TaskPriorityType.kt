package com.thindie.design_system

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.thindie.design_system.theme.TaskuColors

sealed interface TaskPriorityType {
    @Composable
    fun getStatusImage(): Painter

    fun getColor(): Color
    @StringRes
    fun getTitle(): Int

    data object Low : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskActive.painter()

        override fun getColor() = Color.LightGray
        override fun getTitle() = TaskuTitles.Priority.low
    }

    data object Medium : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskCancel.painter()
        override fun getColor() = TaskuColors.green

        override fun getTitle() = TaskuTitles.Priority.medium
    }

    data object High : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskDone.painter()
        override fun getColor() = TaskuColors.azure

        override fun getTitle() = TaskuTitles.Priority.high

    }

    data object Highest : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskRepeat.painter()
        override fun getColor() = TaskuColors.red
        override fun getTitle() = TaskuTitles.Priority.highest
    }

    companion object Factory {
        fun getInstance(id: Int): TaskPriorityType {
            return when (id) {
                0 -> Low
                1 -> Medium
                2 -> High
                3 -> Highest
                else -> Low
            }
        }
    }
}

