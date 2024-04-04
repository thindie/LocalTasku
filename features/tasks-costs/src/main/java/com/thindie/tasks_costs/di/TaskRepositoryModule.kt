package com.thindie.tasks_costs.di

import com.thindie.tasks_costs.data.TaskCostRepositoryImpl
import com.thindie.tasks_costs.domain.TasksCostRepository
import dagger.Binds
import dagger.Module

@Module
internal interface TaskRepositoryModule {
    @TasksCostsScope
    @Binds
    fun bindTaskScope(impl: TaskCostRepositoryImpl): TasksCostRepository
}