package com.thindie.common.di.viewmodels_factory

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module interface ViewModelFactoryModule {
    @Binds
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}