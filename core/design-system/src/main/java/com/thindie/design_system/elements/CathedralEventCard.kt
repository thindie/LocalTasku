package com.thindie.design_system.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.ColorAlphas
import com.thindie.design_system.elements.generic_content.CathedralGenericContentUnit

@Composable
fun CathedralEventCard(
    modifier: Modifier = Modifier,
    title: String,
    time: String,
    description: String,
    price: String,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    onClick: () -> Unit,
) {

    CathedralGenericContentUnit(
        modifier = modifier
            .fillMaxHeight(),
        color = Color.White,
        shape = shape
    ) {

        Column(
            modifier = modifier
                .height(TaskuDimensions.eventElementHeight)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = time, color = LocalContentColor.current.copy(ColorAlphas.basic))
            }
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = modifier.weight(0.2f, true))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = description,
                    color = LocalContentColor.current.copy(ColorAlphas.expert),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 6,
                    textAlign = TextAlign.Justify,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = modifier.weight(1f, true))
            Row(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                CathedralSmallButton(
                    onClick = onClick,
                    wideness = 1f,
                    title = price,
                    textColor = Color.White
                )
            }
        }
    }
}