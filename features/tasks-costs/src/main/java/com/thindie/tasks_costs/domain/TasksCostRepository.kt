package com.thindie.tasks_costs.domain

import kotlinx.coroutines.flow.Flow


internal interface TasksCostRepository {
    suspend fun requestCostsSumMonth()
    suspend fun requestCostsSumYear()
    suspend fun requestCostsSumWeek()
    suspend fun requestCostsSumDay()

    fun observeCostsSummary(): Flow<PeriodGroupedCostsProvider>
}