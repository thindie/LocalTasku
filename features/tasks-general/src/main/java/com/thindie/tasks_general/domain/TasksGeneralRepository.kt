package com.thindie.tasks_general.domain

internal interface TasksGeneralRepository {
    suspend fun getTasks(): Result<List<Task>>

}