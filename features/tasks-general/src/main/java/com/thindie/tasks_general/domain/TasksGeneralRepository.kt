package com.thindie.tasks_general.domain

internal interface TasksGeneralRepository {
    suspend fun getTasks(): Result<List<Task>>
    suspend fun setCreateable(createAble: Task.Companion.CreateAble): Result<Unit>
}