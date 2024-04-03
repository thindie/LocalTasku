package com.thindie.tasks_costs

internal fun buildRangeIndexedFromNonZero(step: Int, times: Int): List<Pair<IntRange, Int>> = buildList {

    var start = 0

    repeat(times) { repetition ->
        this.add(
            start..start.plus(step) to repetition.plus(1)
        )
        start = start.plus(step)
    }
}