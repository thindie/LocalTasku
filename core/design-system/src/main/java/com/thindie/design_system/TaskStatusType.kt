package com.thindie.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.thindie.design_system.resources.TaskuIcons

sealed interface TaskStatusType {
    @Composable
    fun getStatusImage(): Painter

    data object Active : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.affiche.painter()

    }

    data object Deleted : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.affiche.painter()

    }

    data object Done : TaskStatusType {
        @Composable
        override fun getStatusImage() = TaskuIcons.affiche.painter()

    }

    companion object Factory {
        fun getInstance(id: Int): TaskStatusType {
            return when (id) {
                1 -> Deleted
                2 -> Done
                else -> Active
            }
        }
    }
}
