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
                        taskTitle = "title1",
                        taskDescription = "d1",
                        taskDeadline = 0,
                        taskGroupTitle = "123",
                        taskStatusAssign = 1
                    )
                )

                add(
                    Task(
                        taskId = 2,
                        taskTitle = "title2",
                        taskDescription = "d4",
                        taskDeadline = 0,
                        taskGroupTitle = "123",
                        taskStatusAssign = 3
                    )
                )

                add(
                    Task(
                        taskId = 3,
                        taskTitle = "title3",
                        taskDescription = "d34",
                        taskDeadline = 0,
                        taskGroupTitle = "123",
                        taskStatusAssign = 3
                    )
                )

                add(
                    Task(
                        taskId = 4,
                        taskTitle = "title4",
                        taskDescription = "d1",
                        taskDeadline = 0,
                        taskGroupTitle = "456",
                        taskStatusAssign = 1
                    )
                )

                add(
                    Task(
                        taskId = 5,
                        taskTitle = "title5",
                        taskDescription = "d4",
                        taskDeadline = 0,
                        taskGroupTitle = "456",
                        taskStatusAssign = 3
                    )
                )

                add(
                    Task(
                        taskId = 6,
                        taskTitle = "title6",
                        taskDescription = "d34",
                        taskDeadline = 0,
                        taskGroupTitle = "456",
                        taskStatusAssign = 3
                    )
                )
            }
        }

    }
}