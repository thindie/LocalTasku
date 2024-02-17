package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.TaskuDimensions

@Suppress("LongParameterList")
@Composable
fun TaskuGenericTextContent(
    modifier: Modifier = Modifier,
    title: String,
    style: TextStyle? = null,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    spacerWidth: Dp = TaskuDimensions.spaceNear,
    content: @Composable () -> Unit,
) {

    Row(
        modifier = modifier.padding(
            TaskuDimensions.commonPadding
        ),
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Text(
            modifier = Modifier,
            style = style ?: LocalTextStyle.current,
            text = title
        )
        Spacer(modifier = Modifier.width(spacerWidth))
        content()
    }
}
