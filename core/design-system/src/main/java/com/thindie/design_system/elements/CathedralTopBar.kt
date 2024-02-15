package com.thindie.design_system.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thindie.design_system.painter
import com.thindie.design_system.resources.TaskuIcons

@Composable
fun CathedralTopBar(onClickMenu: () -> Unit) {
    TopBar(onClickMenu = onClickMenu) {
        Title()
    }
}

@Composable
private fun Title() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(painter = TaskuIcons.logoCathedralPicture.painter(), contentDescription = null, tint = Color.Black)
        Icon(
            painter = TaskuIcons.cathedralLettering.painter(),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onClickMenu: () -> Unit,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(12.dp))
        IconButton(onClick = onClickMenu) {
            Icon(
                painter = TaskuIcons.menu.painter(),
                contentDescription = null,
                tint = Color.Black
            )
        }
        content()
    }
}