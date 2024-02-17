package com.thindie.localtasku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.design_system.theme.TaskuTheme
import com.thindie.localtasku.application.TaskuApplication


class MainActivity : ComponentActivity(), App {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskuTheme {
                TaskuApp()
            }
        }
    }

    override fun getDependenciesProvider(): DependenciesProvider {
        val applicationApp = application
        applicationApp as App
        return applicationApp.getDependenciesProvider()
    }
}

