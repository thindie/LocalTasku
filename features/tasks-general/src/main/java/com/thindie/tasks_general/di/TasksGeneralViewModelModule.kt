package com.thindie.tasks_general.di

import androidx.lifecycle.ViewModel
import com.thindie.common.di.ViewModelKey
import com.thindie.tasks_general.presentation.sorted_tasks_area.viewmodel.TasksAreaSortedScreenViewModel
import com.thindie.tasks_general.presentation.unsorted_tasks.viewmodel.TasksGeneralScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface TasksGeneralViewModelModule {
    @Binds
    @TasksGeneralScope
    @IntoMap
    @ViewModelKey(TasksGeneralScreenViewModel::class)
    fun bindFeatureViewModel1(viewModel: TasksGeneralScreenViewModel): ViewModel

    @Binds
    @TasksGeneralScope
    @IntoMap
    @ViewModelKey(TasksAreaSortedScreenViewModel::class)
    fun bindFeatureViewModel2(viewModel: TasksAreaSortedScreenViewModel): ViewModel
}