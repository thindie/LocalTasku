package com.thindie.tasks_costs.data

import com.thindie.common.timemanagement.TimeOperator
import com.thindie.database.LocalSource
import com.thindie.database.entities.LocalSourceEntity
import com.thindie.tasks_costs.buildRangeIndexedFromNonZero
import com.thindie.tasks_costs.di.TasksCostsScope
import com.thindie.tasks_costs.domain.Cost
import com.thindie.tasks_costs.domain.CostsGrouping
import com.thindie.tasks_costs.domain.PeriodGroupedCostsProvider
import com.thindie.tasks_costs.domain.TasksCostRepository
import java.time.LocalDateTime
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

@TasksCostsScope
internal class TaskCostRepositoryImpl @Inject constructor(
    private val timeOperator: TimeOperator,
    private val localSource: LocalSource,
) : TasksCostRepository {

    companion object {
        private const val daysInWeek = 7
        private const val weeksInYear = 52
    }

    private val _totalCostsGrouping = MutableStateFlow<CostsGrouping>(CostsGrouping.WEEK)
    private val _resultFlow: Flow<PeriodGroupedCostsProvider> =
        _totalCostsGrouping.combine(localSource.observeLocalStoredEntities()) { grouping, storedEntities ->
            val currentDateTime = timeOperator.getCurrent()

            val filteredEntities = storedEntities
                .filter { it.getCost() != null }
                .filter { entity ->
                    val entityCreationTime = entity.getTrackPoint()
                    isGivenDateTimeMatchCriteria(
                        currentDateTime = currentDateTime,
                        givenDateTime = getLocalDateTimeFromMillis(
                            timeOperator, entityCreationTime
                        ),
                        grouping = grouping
                    )
                }


            PeriodGroupedCostsProvider(
                costs = filteredEntities.sumOf { it.getCost() ?: 0 },
                costsPeriod = grouping,
                periodCostsScope = groupByPeriod(grouping, storedEntities).map { entry ->
                    Cost(
                        title = entry.key,
                        cost = entry.value.sumOf { entity -> entity.getCost() ?: 0 }
                    )
                }
            )
        }

    override suspend fun requestCostsSumMonth() {
        _totalCostsGrouping.value = CostsGrouping.MONTH
    }

    override suspend fun requestCostsSumYear() {
        _totalCostsGrouping.value = CostsGrouping.YEAR
    }

    override suspend fun requestCostsSumWeek() {
        _totalCostsGrouping.value = CostsGrouping.WEEK
    }

    override suspend fun requestCostsSumDay() {
        _totalCostsGrouping.value = CostsGrouping.DAY
    }

    override fun observeCostsSummary(): Flow<PeriodGroupedCostsProvider> {
        return _resultFlow
    }

    private fun getLocalDateTimeFromMillis(
        timeOperator: TimeOperator,
        millis: Long,
    ): LocalDateTime {
        return timeOperator.getCurrentLocalDateTime(millis)
    }

    private fun groupByPeriod(
        grouping: CostsGrouping,
        list: List<LocalSourceEntity>,
    ): Map<String, List<LocalSourceEntity>> {
        return when (grouping) {
            CostsGrouping.DAY -> list.groupBy {
                getLocalDateTimeFromMillis(timeOperator, it.getTrackPoint()).dayOfMonth.toString()
            }

            CostsGrouping.MONTH -> list.groupBy {
                getLocalDateTimeFromMillis(timeOperator, it.getTrackPoint()).month.toString()
            }

            CostsGrouping.WEEK -> list.groupBy {
                getLocalDateTimeFromMillis(timeOperator, it.getTrackPoint()).getWeek().toString()
            }

            CostsGrouping.YEAR -> list.groupBy {
                getLocalDateTimeFromMillis(timeOperator, it.getTrackPoint()).year.toString()
            }
        }
    }

    private fun isGivenDateTimeMatchCriteria(
        currentDateTime: LocalDateTime,
        givenDateTime: LocalDateTime,
        grouping: CostsGrouping,
    ): Boolean {
        return when (grouping) {
            CostsGrouping.DAY -> currentDateTime.dayOfYear == givenDateTime.dayOfYear
            CostsGrouping.MONTH -> currentDateTime.month == givenDateTime.month
            CostsGrouping.WEEK -> currentDateTime.dayOfYear - givenDateTime.dayOfYear <= 7
            CostsGrouping.YEAR -> currentDateTime.year == givenDateTime.year
        }
    }

    private fun LocalDateTime.getWeek(): Int {
        val weeks = buildRangeIndexedFromNonZero(daysInWeek, weeksInYear)
        return weeks.first {
            dayOfYear in it.first
        }.second
    }
}
