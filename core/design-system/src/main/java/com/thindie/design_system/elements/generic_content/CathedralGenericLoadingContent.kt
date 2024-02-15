package com.thindie.design_system.elements.generic_content

import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Suppress("LongParameterList")
@Composable
fun CathedralGenericLoadingContent(
    isLoading: Boolean,
    repeatTimes: Int = 1,
    blockPadding: Dp = 15.dp,
    spaceBy: Dp = 8.dp,
    loadingStrokeHeight: Dp = 12.dp,
    loadingContent: @Composable () -> Unit = {
        LoadingContent(
            repeatTimes = repeatTimes,
            blockPadding = blockPadding,
            spaceBy = spaceBy,
            loadingStrokeHeight = loadingStrokeHeight
        )
    },
    content: @Composable () -> Unit,
) {
    if (isLoading) loadingContent() else content()
}

@Composable
fun LoadingContent(
    repeatTimes: Int = 1,
    blockPadding: Dp = 15.dp,
    spaceBy: Dp = 8.dp,
    loadingStrokeHeight: Dp = 12.dp,

    ) {
    val state = rememberLoadingState()
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(spaceBy)
    ) {
        val brush = state.gradientBrush
        repeat(repeatTimes) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 2.dp, vertical = blockPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LoadingUnit(
                    height = loadingStrokeHeight,
                    brush = brush,
                    width = 0.7f,

                    )
                LoadingUnit(
                    height = loadingStrokeHeight,
                    brush = brush,
                    width = 0.5f,
                )
            }

        }
    }
}



@Composable
private fun LoadingUnit(height: Dp, brush: Brush, width: Float) {
    require(width <= 1f)
    Surface(
        shape = MaterialTheme.shapes.extraLarge, shadowElevation = 5.dp
    ) {
        Spacer(
            modifier = Modifier
                .background(brush, shape = MaterialTheme.shapes.extraLarge)
                .clip(MaterialTheme.shapes.extraLarge)
                .fillMaxWidth(width)
                .height(height)
        )
    }
}


@Composable
private fun rememberLoadingState(durationAndDelay: Int = 900): LoadingState {
    return remember {
        LoadingState(durationAndDelay = durationAndDelay)
    }
}

@Stable
private class LoadingState(private val durationAndDelay: Int) {
    val transition
        @Composable get() = rememberInfiniteTransition(label = "")

    val colorList
        @Composable get() = listOf(
            Color.LightGray,
            Color.LightGray,
        ).mapIndexed { index, color ->
            color.copy(
                alpha =
                colorsState(duration = index * 100).value
            )
        }

    val gradientBrush
        @Composable get() = Brush.horizontalGradient(
            colors = colorList,
        )

    @Composable
    fun colorsState(duration: Int): State<Float> {
        return transition.animateFloat(
            initialValue = 0.2f,
            targetValue = 1.0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    delayMillis = duration,
                    durationMillis = durationAndDelay,
                    easing = EaseInBounce
                ),
                repeatMode = RepeatMode.Restart
            ),
            label = ""
        )
    }
}