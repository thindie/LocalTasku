package com.thindie.design_system.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.thindie.design_system.TaskuGradients
import com.thindie.design_system.ColorAlphas

@Composable
fun CathedralSmallButton(
    wideness: Float = 0.3f,
    onClick: () -> Unit,
    title: String,
    textColor: Color,
) {
    FilledTonalButton(
        modifier = Modifier
            .fillMaxWidth(wideness)
            .background(
                Brush.verticalGradient(TaskuGradients.whiteBlack),
                shape = MaterialTheme.shapes.extraLarge
            ),
        onClick = onClick,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = Color.Transparent
        ),
    ) {
        Text(
            text = title,
            color = textColor.copy(ColorAlphas.expert),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun CathedralOutlinedButton(onClick: () -> Unit, title: String) {
    val borderStroke =
        BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary.copy(0.7f))
    OutlinedButton(onClick = onClick, border = borderStroke) {
        Text(
            text = title,
            color = LocalContentColor.current.copy(ColorAlphas.expert),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun CathedralNavigationButton(
    painter: Painter,
    gradientList: List<Color> = TaskuGradients.whiteBlack,
    onClick: () -> Unit,
) {
    val brush = Brush.horizontalGradient(
        gradientList
    )

    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier.size(36.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White

    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painter,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}


@Composable
fun CathedralWideButton(modifier: Modifier = Modifier, onClick: () -> Unit, title: String) {
    Button(modifier = modifier.fillMaxWidth(), onClick = onClick) {
        Text(text = title)
    }
}

@Composable
fun CathedralGradientIconButton(
    painter: Painter,
    scale: Float = 0.5f,
    gradientList: List<Color> = TaskuGradients.whiteBlack,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val brush = Brush.horizontalGradient(
        gradientList
    )

    FilledIconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .scale(scale)
            .background(brush, CircleShape),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Transparent, disabledContainerColor = Color.Transparent
        )
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color.White.copy(ColorAlphas.expert)
        )
    }
}


@Composable
fun CathedralLargeButton(onClick: () -> Unit, title: String) {

    Button(
        modifier = Modifier
            .background(
                Brush.verticalGradient(TaskuGradients.primaryPrimaryContainer),
                shape = MaterialTheme.shapes.extraLarge
            )
            .fillMaxWidth(), onClick = onClick, colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = Color.Transparent
        ), shape = MaterialTheme.shapes.extraLarge
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White.copy(ColorAlphas.expert)
        )
    }
}