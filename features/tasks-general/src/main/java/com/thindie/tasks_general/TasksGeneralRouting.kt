package com.thindie.tasks_general

import androidx.compose.runtime.Composable
import com.thindie.common.di.getApp
import com.thindie.tasks_general.di.TasksGeneralComponent


@Composable
internal fun FeatureDestinationComponentInit(): TasksGeneralComponent? {
    return getApp()
        ?.getDependenciesProvider()
        ?.let { dependenciesProvider ->
            TasksGeneralComponent.init(dependenciesProvider)
        }
}
