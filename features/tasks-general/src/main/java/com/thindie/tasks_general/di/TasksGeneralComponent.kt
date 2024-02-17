package com.thindie.tasks_general.di


import androidx.lifecycle.ViewModelProvider
import com.thindie.common.DependenciesProvider
import com.thindie.common.di.viewmodels_factory.ViewModelFactoryModule
import com.thindie.common.timemanagement.TimeOperator
import dagger.Component


@TasksGeneralScope
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [TasksGeneralModule::class, TasksGeneralViewModelModule::class, ViewModelFactoryModule::class],
)
interface TasksGeneralComponent {
    companion object {
        fun init(dependenciesProvider: DependenciesProvider): TasksGeneralComponent {

            return DaggerTasksGeneralComponent
                .factory()
                .create(dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependenciesProvider: DependenciesProvider): TasksGeneralComponent
    }

    fun provideFactory(): ViewModelProvider.Factory

    fun provideTimeOperator(): TimeOperator

}