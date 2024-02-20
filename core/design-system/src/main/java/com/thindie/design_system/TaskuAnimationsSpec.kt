package com.thindie.design_system

import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

object TaskuAnimationsSpec {
    object NavTransitions {
        val fadeIn = fadeIn(
            animationSpec = tween(
                easing = EaseInBack, durationMillis = 700
            )
        )

        val fadeOut = fadeOut(
            animationSpec = tween(
                easing = EaseOutBack, durationMillis = 1000
            )
        )
    }
}