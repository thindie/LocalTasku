package com.thindie.tasks_general.data

import com.thindie.common.timemanagement.TimeOperator
import com.thindie.database.LocalSource
import com.thindie.database.entities.LocalSourceEntity
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.domain.TasksGeneralRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@TasksGeneralScope
internal class TasksGeneralRepositoryImpl @Inject constructor(
    private val timeOperator: TimeOperator,
    private val localSource: LocalSource,
) :
    TasksGeneralRepository {


    override fun observeTasks(): Flow<Result<List<Task>>> {
        return localSource.observeLocalStoredEntities()
            .map {
                kotlin.runCatching {
                    it.map(LocalSourceEntity::map)
                }
            }
    }

    override suspend fun initTask() {
        localSource.create()
    }

    override suspend fun updateTask(task: Task) {
        val savedTask = localSource.get(task)
        localSource.update(task.copy(taskCreationTime = savedTask.getTrackPoint()).map())
    }


}