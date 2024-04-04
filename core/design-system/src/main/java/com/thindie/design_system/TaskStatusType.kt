package com.thindie.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

sealed interface TaskStatusType {
    @Composable
    fun getStatusImage(): Painter

    fun getStatusBind(): Int

    data object Active : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskActive.painter()
        override fun getStatusBind() = 0
    }

    data object Deleted : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskCancel.painter()
        override fun getStatusBind() = 1
    }

    data object Done : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskDone.painter()
        override fun getStatusBind() = 2
    }

    data object Repeat : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.taskRepeat.painter()
        override fun getStatusBind() = 3
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
