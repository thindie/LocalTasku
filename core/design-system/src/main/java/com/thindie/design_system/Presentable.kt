package com.thindie.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

interface Presentable {
    fun presentTitle(): String
    fun presentDescription(): String

    fun presentCredits(): String

    @Composable
    fun presentPicture(): Painter
}