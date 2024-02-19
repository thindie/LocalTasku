package com.thindie.design_system.elements.dim_wrapper.dimwrapperstate

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import com.thindie.design_system.elements.dim_wrapper.StateMediator

interface DimMediator : StateMediator {
    fun setOffset(offset: Offset)
    operator fun invoke(content: @Composable () -> Unit): @Composable () -> Unit
    fun dismissDim()

}