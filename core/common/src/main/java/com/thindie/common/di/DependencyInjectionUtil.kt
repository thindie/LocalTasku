package com.thindie.common.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.thindie.common.App

@Composable
fun getApp(): App? {
    val context = LocalContext.current
    return if (context is App) {
        context as? App
    } else null
}
