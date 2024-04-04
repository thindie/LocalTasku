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

    fun getPriorityBind(): Int

    @StringRes
    fun getTitle(): Int

    data object Low : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.Priority.prirotyLow.painter()

        override fun getColor() = Color.LightGray
        override fun getTitle() = TaskuTitles.Priority.low

        override fun getPriorityBind() = 0
    }

    data object Medium : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.Priority.prirotyLow.painter()
        override fun getColor() = TaskuColors.green

        override fun getTitle() = TaskuTitles.Priority.medium

        override fun getPriorityBind() = 1
    }

    data object High : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.Priority.priorityHigh.painter()
        override fun getColor() = TaskuColors.azure

        override fun getTitle() = TaskuTitles.Priority.high
        override fun getPriorityBind() = 2

    }

    data object Highest : TaskPriorityType {
        @Composable
        override fun getStatusImage() = TaskuIcons.Priority.priorityHigh.painter()
        override fun getColor() = TaskuColors.red
        override fun getTitle() = TaskuTitles.Priority.highest
        override fun getPriorityBind() = 3
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

