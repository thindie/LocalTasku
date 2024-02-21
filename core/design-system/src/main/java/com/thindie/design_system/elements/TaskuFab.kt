package com.thindie.design_system.elements

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.painter

@Composable
fun BoxScope.TaskuFab(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(TaskuDimensions.Padding.commonValues)
            .align(Alignment.BottomStart)
    ) {
        Icon(painter = TaskuIcons.flame.painter(), contentDescription = null)
    }
}

@Composable
fun TaskuFab(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(TaskuDimensions.Padding.commonValues)
    ) {
        Icon(painter = TaskuIcons.flame.painter(), contentDescription = null)
    }
}