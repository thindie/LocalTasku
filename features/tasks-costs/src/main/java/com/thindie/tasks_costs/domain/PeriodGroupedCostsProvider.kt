package com.thindie.tasks_costs.domain

import com.thindie.domain.entities.behavior.Spendable

internal data class PeriodGroupedCostsProvider(
    val costs: Int,
    val costsPeriod: CostsGrouping,
    val periodCostsScope: List<Cost>,
) : Spendable {

    override fun getCost() = costs

}