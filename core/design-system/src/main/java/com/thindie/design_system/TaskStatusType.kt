package com.thindie.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

sealed interface TaskStatusType {
    @Composable
    fun getStatusImage(): Painter

    data object Active : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskActive.painter()

    }

    data object Deleted : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskCancel.painter()

    }

    data object Done : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskDone.painter()

    }

    data object Repeat : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskRepeat.painter()

    }

    companion object Factory {
        fun getInstance(id: Int): TaskStatusType {
            return when (id) {
                1 -> Deleted
                2 -> Done
                3 -> Repeat
                else -> Active
            }
        }
    }
}
