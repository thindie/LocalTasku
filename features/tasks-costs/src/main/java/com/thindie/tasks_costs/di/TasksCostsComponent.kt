package com.thindie.tasks_costs.di

import androidx.lifecycle.ViewModelProvider
import com.thindie.common.DependenciesProvider
import dagger.Component

@TasksCostsScope
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [ViewModelModule::class, ViewModelFactoryModule::class, TaskRepositoryModule::class]
)
interface TasksCostsComponent {
    companion object {
        fun init(dependenciesProvider: DependenciesProvider): TasksCostsComponent {
            return DaggerTasksCostsComponent
                .factory()
                .create(dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependenciesProvider: DependenciesProvider): TasksCostsComponent
    }

    fun provideFactory(): ViewModelProvider.Factory
}