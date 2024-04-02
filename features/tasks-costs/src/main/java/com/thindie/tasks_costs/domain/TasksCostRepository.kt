package com.thindie.tasks_costs.domain

internal interface TasksCostRepository {
    suspend fun getCostsSumMonth(): CostsList
    suspend fun getCostsSumYear(): CostsList
    suspend fun getCostsSumWeek(): CostsList
    suspend fun getCostsSumDay(): CostsList
}