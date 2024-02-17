package com.thindie.tasks_general.domain

import com.thindie.tasks_general.di.TasksGeneralScope
import javax.inject.Inject
@TasksGeneralScope
internal class GetTasksUseCase @Inject constructor(private val repository: TasksGeneralRepository) {
    suspend fun get(): Result<List<Task>> {
        return repository.getTasks()
    }
}