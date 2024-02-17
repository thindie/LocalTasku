package com.thindie.tasks_general.data

import com.thindie.common.timemanagement.TimeOperator
import com.thindie.tasks_general.di.TasksGeneralScope
import com.thindie.tasks_general.domain.Task
import com.thindie.tasks_general.domain.TasksGeneralRepository
import javax.inject.Inject

@TasksGeneralScope
internal class TasksGeneralRepositoryImpl @Inject constructor(private val timeOperator: TimeOperator) :
    TasksGeneralRepository {
    override suspend fun getTasks(): Result<List<Task>> {
        return kotlin.runCatching {
            buildList {
                add(
                    Task(
                        taskId = 1,
                        taskTitle = "t1",
                        taskDescription = "d1",
                        taskDeadline = 0,
                        taskGroupTitle = "g1",
                        taskStatusAssign = 1
                    )
                )

                add(
                    Task(
                        taskId = 2,
                        taskTitle = "t3",
                        taskDescription = "d4",
                        taskDeadline = 0,
                        taskGroupTitle = "g2",
                        taskStatusAssign = 3
                    )
                )

                add(
                    Task(
                        taskId = 0,
                        taskTitle = "t3",
                        taskDescription = "d34",
                        taskDeadline = 0,
                        taskGroupTitle = "g32",
                        taskStatusAssign = 3
                    )
                )
            }
        }

    }
}