package com.thindie.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object TaskuDimensions {
    object TopBar {
        val height = 36.dp
    }

    object DropDownMenu {
        val width = 148.dp
        val height = 36.dp
    }

    object TaskuCard {
        val taskuHeight = 40.dp
        val taskuHeightExpanded = 112.dp
    }

    object TaskuIcons {
        val regular = 24.dp
        val small = 12.dp
    }


    object Spacing {
        val near = 4.dp
        val usual = 8.dp
    }

    object Padding {
        private val twelve = 12.dp
        val horizontal = PaddingValues(horizontal = twelve)
        val vertical = 8.dp
        val commonValues = PaddingValues(horizontal = twelve, vertical)
    }

    @Deprecated(message = "due TaskuDimensionReOrganise")
    val basicTaskuHeight = 40.dp

    @Deprecated(message = "due TaskuDimensionReOrganise")
    val expandedTaskuHeight = 112.dp


    @Deprecated(message = "due TaskuDimensionReOrganise")
    val iconSizeRegular = 24.dp


    @Deprecated(message = "due TaskuDimensionReOrganise")
    val spaceNear = 4.dp

    @Deprecated(message = "due TaskuDimensionReOrganise")
    val horizontalPadding = 12.dp

    @Deprecated(message = "due TaskuDimensionReOrganise")
    val verticalPadding = 4.dp

    @Deprecated(message = "due TaskuDimensionReOrganise")
    val commonPadding = PaddingValues(horizontalPadding, verticalPadding)

}