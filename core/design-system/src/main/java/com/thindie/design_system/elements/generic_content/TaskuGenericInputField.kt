package com.thindie.design_system.elements.generic_content

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.delay

@Composable
fun TaskuGenericInputField(
    modifier: Modifier = Modifier,
    autoRequestFocus: Boolean,
    textStyle: TextStyle,
    fieldValue: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onFieldValueChange: (String) -> Unit,
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit = @Composable { innerTextField -> innerTextField() },
) {
    val focusRequester = remember {
        FocusRequester()
    }

    var shouldRequestFocus by remember {
        mutableStateOf(autoRequestFocus)
    }

    LaunchedEffect(key1 = autoRequestFocus, block = {
        if (shouldRequestFocus) {
            delay(100L)
            focusRequester.requestFocus()
            shouldRequestFocus = false
        }
    })

    val focusedModifier = Modifier
        .focusRequester(focusRequester)

    BasicTextField(
        value = fieldValue,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        onValueChange = onFieldValueChange,
        modifier = modifier
            .fillMaxWidth()
            .then(focusedModifier),
        textStyle = textStyle,
        singleLine = true,
        decorationBox = decorationBox
    )

}





