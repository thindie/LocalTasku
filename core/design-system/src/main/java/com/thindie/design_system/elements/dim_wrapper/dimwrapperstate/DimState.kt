package com.thindie.design_system.elements.dim_wrapper.dimwrapperstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset

@Stable
class DimState(private val notifyDimDismissed: () -> Unit) {

    var contentOnTopOfDimmed: @Composable () -> Unit = {}
        private set
    var shouldDim by mutableStateOf(false)
        private set

    var selectedContentOffset by mutableStateOf(Offset.Zero)
        private set

    fun setSelectedContentPosition(offset: Offset) {
        selectedContentOffset = offset
    }

    fun setTopContent(onTop: @Composable () -> Unit) {
        contentOnTopOfDimmed = onTop
    }


    fun onTriggerDim() {
        shouldDim = true
    }

    fun onDismissRequest() {
        contentOnTopOfDimmed = {}
        selectedContentOffset = Offset.Zero
        shouldDim = false
        notifyDimDismissed()
    }

}