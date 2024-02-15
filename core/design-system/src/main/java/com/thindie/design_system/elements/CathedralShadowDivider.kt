package com.thindie.design_system.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thindie.design_system.TaskuGradients
import com.thindie.design_system.ColorAlphas

@Composable
fun CathedralShadowDivider(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = 3.dp)
            .fillMaxWidth()
    ) {
        Divider(
            thickness = Dp.Hairline,
            color = Color.LightGray.copy(ColorAlphas.basic)
        )
        Spacer(
            modifier = Modifier
                .background(brush = Brush.horizontalGradient(TaskuGradients.weakGray))
                .fillMaxWidth()
                .height(3.dp)
        )
        Divider(
            thickness = Dp.Hairline,
            color = Color.White
        )
    }
}