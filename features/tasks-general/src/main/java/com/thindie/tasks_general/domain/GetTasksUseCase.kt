package com.thindie.tasks_general.domain

import com.thindie.tasks_general.di.TasksGeneralScope
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@TasksGeneralScope
internal class GetTasksUseCase @Inject constructor(private val repository: TasksGeneralRepository) {
      fun observe(): Flow<Result<List<Task>>> {
        return repository.observeTasks()
    }
}