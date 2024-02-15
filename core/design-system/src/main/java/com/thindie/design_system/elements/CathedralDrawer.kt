package com.thindie.design_system.elements

import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thindie.design_system.ColorAlphas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun CathedralDrawer(
    drawerContent: @Composable () -> Unit,
    content: @Composable (DrawerState) -> Unit,
) {
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = drawerContent
    ) {
        content.invoke(drawerState)
    }
}

@Composable
fun rememberCathedralDrawerState(state: DrawerState): CathedralDrawerState {
    val scope = rememberCoroutineScope()
    return remember {
        CathedralDrawerState(scope = scope, drawerState = state)
    }
}

@Stable
class CathedralDrawerState(
    private val drawerState: DrawerState,
    private val scope: CoroutineScope,
) {
    fun open() {
        scope.launch {
            drawerState.open()
        }
    }

    fun close() {
        scope.launch {
            drawerState.close()
        }
    }
}

@Composable
fun CathedralDrawerElement(
    textLabel: String, onClick: () -> Unit,
    color: Color
    = Color.Transparent,
    painter: Painter,
) {
    NavigationDrawerItem(
        label = {
            Text(
                text = textLabel,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.W900,
                color = LocalContentColor.current.copy(ColorAlphas.default)
            )
        }, selected = false,
        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = color),
        onClick = onClick,
        icon = { CathedralGradientIconButton(painter = painter, onClick = onClick) }
    )
}