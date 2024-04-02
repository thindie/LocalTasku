package com.thindie.tasks_costs.domain

import com.thindie.domain.entities.behavior.Spendable

internal data class CostsList(
    val costs: Int,
    val costsPeriod: TotalCosts,
    val topCosts: List<Cost>,
) : Spendable {

    override fun getCost() = costs

}