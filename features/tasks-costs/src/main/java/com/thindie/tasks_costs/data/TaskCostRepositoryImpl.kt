package com.thindie.tasks_costs.data

import com.thindie.tasks_costs.di.TasksCostsScope
import com.thindie.tasks_costs.domain.CostsList
import com.thindie.tasks_costs.domain.TasksCostRepository
import javax.inject.Inject
@TasksCostsScope
internal class TaskCostRepositoryImpl @Inject constructor(): TasksCostRepository {
    override suspend fun getCostsSumMonth(): CostsList {
        TODO("Not yet implemented")
    }

    override suspend fun getCostsSumYear(): CostsList {
        TODO("Not yet implemented")
    }

    override suspend fun getCostsSumWeek(): CostsList {
        TODO("Not yet implemented")
    }

    override suspend fun getCostsSumDay(): CostsList {
        TODO("Not yet implemented")
    }
}