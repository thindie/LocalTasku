package com.thindie.tasks_costs.domain

import com.thindie.domain.entities.behavior.Nameable
import com.thindie.domain.entities.behavior.Spendable

internal data class Cost(val title: String, val cost: Int) : Spendable, Nameable {
    override fun getName() = title

    override fun getCost() = cost
}