package com.thindie.tasks_general.domain

import com.thindie.tasks_general.di.TasksGeneralScope
import javax.inject.Inject

@TasksGeneralScope
internal class UpdateTaskUseCase @Inject constructor(private val repository: TasksGeneralRepository) {
    suspend fun update(task: Task) {
        repository.updateTask(task)
    }
}