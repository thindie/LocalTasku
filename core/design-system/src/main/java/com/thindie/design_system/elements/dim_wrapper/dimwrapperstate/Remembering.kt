package com.thindie.design_system.elements.dim_wrapper.dimwrapperstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberDimmingState(notifyDimDismissed: () -> Unit): DimState {
    return remember {
        DimState(notifyDimDismissed = notifyDimDismissed)
    }
}

@Composable
fun rememberGenericDimMediator(state: DimState): DimMediator {
    return remember {
        TaskuCardDimMediator(state)
    }
}