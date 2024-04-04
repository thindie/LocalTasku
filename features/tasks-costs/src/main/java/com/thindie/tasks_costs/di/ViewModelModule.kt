package com.thindie.tasks_costs.di

import androidx.lifecycle.ViewModel
import com.thindie.common.di.ViewModelKey
import com.thindie.tasks_costs.presentation.TasksCostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface ViewModelModule {
    @Binds
    @TasksCostsScope
    @IntoMap
    @ViewModelKey(TasksCostViewModel::class)
    fun bindViewModel(viewModel: TasksCostViewModel): ViewModel
}