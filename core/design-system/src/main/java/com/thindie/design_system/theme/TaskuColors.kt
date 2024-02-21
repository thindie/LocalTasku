package com.thindie.design_system.theme

import androidx.compose.ui.graphics.Color

object TaskuColors {

    val orange = Color(0xffFF5E00)
    val orangeWeak = Color(0xffFF8D5B)
    val green = Color(0xff009100)
    val red = Color(0xffFF3427)
    val purple = Color(0xff923CBB)
    val azure = Color(0xFF30D5C8)
    val blueWeak = Color(0xff5AB3FF)

    object SortAndGroup {
        val active = md_theme_light_primary
        val passive = md_theme_light_onBackground

        val dropdownBackgroundActive = md_theme_light_surfaceTint
        val dropdownBackgroundPassive = Color.Transparent

        val rootBackgroundActive = md_theme_light_primaryContainer
        val rootBackgroundPassive = Color.Transparent
    }
}