package com.thindie.common.coreartifacts

import androidx.compose.runtime.Composable
import com.thindie.common.DependenciesProvider
import com.thindie.common.di.getApp

@Composable
private fun <T : InjectionComponent> FeatureDestinationComponentInit(init: (DependenciesProvider) -> T): T? {
    return getApp()
        ?.getDependenciesProvider()
        ?.let { dependenciesProvider ->
            init(dependenciesProvider)
        }
}