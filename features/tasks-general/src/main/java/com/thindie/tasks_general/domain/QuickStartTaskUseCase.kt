package com.thindie.tasks_general.domain

import com.thindie.tasks_general.di.TasksGeneralScope
import javax.inject.Inject

@TasksGeneralScope
internal class QuickStartTaskUseCase @Inject constructor(private val repository: TasksGeneralRepository) {
    suspend fun set(): Result<Unit> {
        return kotlin.runCatching {  repository.initTask() }
    }
}