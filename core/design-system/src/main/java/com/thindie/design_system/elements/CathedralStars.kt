package com.thindie.design_system.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thindie.design_system.painter
import com.thindie.design_system.resources.TaskuIcons
 import kotlin.random.Random

@Composable
fun CathedralStars(width: Dp, repetitions: Int = 45, color: Color = Color.Black, scale: Float = 0.2f) {
    Row(
        modifier = androidx.compose.ui.Modifier.height(width.div(2)),
        horizontalArrangement = Arrangement.End
    ) {
        repeat(repetitions) {
            Icon(
                modifier = Modifier
                    .offset(
                        x = Random.nextInt(0, 500).dp,
                        y = Random.nextInt(0, 200).dp
                    )
                    .scale(scale = scale),
                painter = TaskuIcons.starPicture.painter(),
                contentDescription = "",
                tint = color

            )
        }
    }
}