package com.thindie.design_system

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object TaskuShapes {
    object ForList {
        val firstElementShape =
            RoundedCornerShape(topStart = 50f, topEnd = 50f, bottomStart = 0f, bottomEnd = 0f)
        val lastElementShape =
            RoundedCornerShape(topStart = 0f, topEnd = 0f, bottomStart = 50f, bottomEnd = 50f)
        val coreElementShape =
            RoundedCornerShape(topStart = 9f, topEnd = 9f, bottomStart = 9f, bottomEnd = 9f)
        private val singleElementShape =
            RoundedCornerShape(topStart = 50f, topEnd = 50f, bottomStart = 50f, bottomEnd = 50f)

        fun listShape(i: Int, size: Int) = when (i) {
            size - 1 -> if (size != 1) lastElementShape else singleElementShape
            0 -> firstElementShape
            else -> coreElementShape
        }
    }

    object HardCoded {
        val bottomCornersRound =
            RoundedCornerShape(topStart = 0f, topEnd = 0f, bottomStart = 100f, bottomEnd = 100f)
        val allCornersRigid = RoundedCornerShape(0)
    }

    object DropDownMenuShapes {
        //for width 148.dp
        val underLyingElement = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
        val expandedDropDownMenu = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 12.dp,
            bottomEnd = 12.dp
        )
    }

}
