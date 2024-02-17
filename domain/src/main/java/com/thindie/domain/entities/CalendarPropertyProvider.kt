package com.thindie.domain.entities

abstract class CalendarPropertyProvider {
    abstract val today: Int
    abstract val daysOfWeek: List<String>
    abstract val daysOfMonth: List<String>
    abstract val firstWeekDayOffsetFromStart: Int
    abstract val offsetFromCurrentDayInMonths: Long
    abstract val selectedMonthTitle: String
    abstract val selectedYear: Int
}