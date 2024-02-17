package com.thindie.tasks_general.di

import com.thindie.tasks_general.data.TasksGeneralRepositoryImpl
import com.thindie.tasks_general.domain.TasksGeneralRepository
import dagger.Binds
import dagger.Module

@Module
internal interface TasksGeneralModule {
    @TasksGeneralScope
    @Binds
    fun bindMainRepository(impl: TasksGeneralRepositoryImpl): TasksGeneralRepository
}