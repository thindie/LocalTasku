package com.thindie.tasks_general.di

import androidx.lifecycle.ViewModel
import com.thindie.tasks_general.presentation.viewmodel.TasksGeneralScreenViewModel
import com.thindie.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface TasksGeneralViewModelModule {
    @Binds
    @TasksGeneralScope
    @IntoMap
    @ViewModelKey(TasksGeneralScreenViewModel::class)
    fun bindFeatureViewModel(viewModel: TasksGeneralScreenViewModel): ViewModel
}