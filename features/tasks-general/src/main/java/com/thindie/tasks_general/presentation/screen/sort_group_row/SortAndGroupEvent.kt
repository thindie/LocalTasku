package com.thindie.tasks_general.presentation.screen.sort_group_row

sealed interface SortAndGroupEvent {
    data object SortAlphabetAsc
    data object SortAlphabetDesc

    data object SortTimeAsc

    data object SortTimeDesc

    data class GroupArea(val groupingTitle: String)

    data class GroupPriority(val priorityGrade: Int)

}