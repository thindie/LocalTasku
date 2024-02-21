package com.thindie.tasks_general.domain

import com.thindie.tasks_general.di.TasksGeneralScope
import javax.inject.Inject

@TasksGeneralScope
internal class SetCreateAbleUseCase @Inject constructor(private val repository: TasksGeneralRepository) {
    suspend fun set(): Result<Unit> {
        return repository.setCreateable(object : Task.Companion.CreateAble {
            override fun getName() = ""

            override fun getDescription() = getName()
        })
    }
}