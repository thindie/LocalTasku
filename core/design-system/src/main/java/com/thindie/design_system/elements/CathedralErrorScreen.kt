package com.thindie.design_system.elements

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thindie.design_system.ColorAlphas
import com.thindie.design_system.painter
import com.thindie.design_system.resources.TaskuIcons
import com.thindie.design_system.resources.TaskuTitles
import com.thindie.design_system.string


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CathedralErrorScreen(
    modifier: Modifier = Modifier,
    message: String = TaskuTitles.kantKindFace.string(),
) {
    val density = LocalDensity.current
    var width by remember { mutableStateOf(3.dp) }
    var height by remember { mutableStateOf(3.dp) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                height = it.height(density)
                width = it.width(density)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CathedralStars(width = width)
        Image(
            modifier = Modifier.scale(0.7f),
            painter = TaskuIcons.kantError.painter(),
            contentDescription = ""
        )

        Text(
            modifier = modifier.basicMarquee(),
            text = message,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = LocalContentColor.current.copy(ColorAlphas.default),
            textAlign = TextAlign.Justify,
            maxLines = 2

        )
    }
}

private fun LayoutCoordinates.width(density: Density): Dp {
    return with(density) {
        size.width.toDp()
    }
}


private fun LayoutCoordinates.height(density: Density): Dp {
    return with(density) {
        size.height.toDp()
    }
}