package com.thindie.tasks_general.domain

import kotlinx.coroutines.flow.Flow

internal interface TasksGeneralRepository {
    fun observeTasks(): Flow<Result<List<Task>>>
    suspend fun initTask()

    suspend fun updateTask(task: Task)
}