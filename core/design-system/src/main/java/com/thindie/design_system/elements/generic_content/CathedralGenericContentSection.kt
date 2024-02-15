package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.thindie.design_system.elements.CathedralDividedTitle

@Composable
fun CathedralGenericContentSection(
    title: String,
    painter: Painter? = null,
    shouldDrawOnContentCard: Boolean = true,
    content: @Composable () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        CathedralDividedTitle(title = title, painter = painter)
        Spacer(modifier = Modifier.height(15.dp))
        if (shouldDrawOnContentCard) {
            CathedralGenericContentCard() {
                content()
            }
        } else content()

        Spacer(modifier = Modifier.height(15.dp))
    }
}