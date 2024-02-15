package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CathedralGenericBottomBar(
    modifier: Modifier = Modifier,
    vararg content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .background(Color.Transparent)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            content.forEach { it.invoke() }

        }
    }
}


