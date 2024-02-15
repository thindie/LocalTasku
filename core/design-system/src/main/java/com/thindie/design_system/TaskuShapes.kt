package com.thindie.design_system

import androidx.compose.foundation.shape.RoundedCornerShape

object TaskuShapes {
    val firstElementShape =
        RoundedCornerShape(topStart = 50f, topEnd = 50f, bottomStart = 0f, bottomEnd = 0f)
    val lastElementShape =
        RoundedCornerShape(topStart = 0f, topEnd = 0f, bottomStart = 50f, bottomEnd = 50f)
    val coreElementShape =
        RoundedCornerShape(topStart = 9f, topEnd = 9f, bottomStart = 9f, bottomEnd = 9f)
    private val singleElementShape =
        RoundedCornerShape(topStart = 50f, topEnd = 50f, bottomStart = 50f, bottomEnd = 50f)

    val bottomRound =
        RoundedCornerShape(topStart = 0f, topEnd = 0f, bottomStart = 100f, bottomEnd = 100f)

    val straightAngle = RoundedCornerShape(0)

    fun listShape(i: Int, size: Int) = when (i) {
        size - 1 -> if (size != 1) lastElementShape else singleElementShape
        0 -> firstElementShape
        else -> coreElementShape
    }
}
