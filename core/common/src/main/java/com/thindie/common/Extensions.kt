package com.thindie.common

import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun LayoutCoordinates.width(density: Density): Dp {
    return with(density) {
        size.width.toDp()
    }
}


fun LayoutCoordinates.height(density: Density): Dp {
    return with(density) {
        size.height.toDp()
    }
}
