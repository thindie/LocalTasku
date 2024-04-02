package com.thindie.tasks_costs.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
internal interface ViewModelFactoryModule {
    @Binds
    @TasksCostsScope
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}