package com.thindie.design_system.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.thindie.design_system.TaskuDimensions
import com.thindie.design_system.TaskuGradients
import com.thindie.design_system.resources.TaskuTitles
 import com.thindie.design_system.string
import kotlinx.coroutines.CoroutineScope

@Composable
fun CathedralDialog(dialogState: CathedralDialogState, content: @Composable () -> Unit) {
    AnimatedVisibility(visible = dialogState.shouldShowDialog) {
        Dialog(onDismissRequest = {}) {

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(
                        brush = Brush.linearGradient(colorStops = TaskuGradients.whiteRounderStops),
                        shape = MaterialTheme.shapes.large
                    )
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxWidth()
                    .height(TaskuDimensions.dialogElementHeight)
                    .padding(horizontal = 2.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                content()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = dialogState::hide) {
                        Text(
                            text = TaskuTitles.buttonOkay.string(),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun rememberCathedralDialogState(): CathedralDialogState {
    val scope = rememberCoroutineScope()
    return remember {
        CathedralDialogState(scope)
    }
}

@Stable
class CathedralDialogState(private val scope: CoroutineScope) {
    var shouldShowDialog by mutableStateOf(false)
        private set

    fun show() {
        shouldShowDialog = true
    }

    fun hide() {
        shouldShowDialog = false
    }
}