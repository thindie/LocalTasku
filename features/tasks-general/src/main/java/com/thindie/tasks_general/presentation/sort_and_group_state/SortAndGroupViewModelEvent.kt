package com.thindie.tasks_general.presentation.sort_and_group_state

sealed interface SortAndGroupViewModelEvent {
    data object OnClickArea : SortAndGroupViewModelEvent
    data object OnClickPriority : SortAndGroupViewModelEvent

    data object OnClickDate : SortAndGroupViewModelEvent

    data object OnClickAlphabet : SortAndGroupViewModelEvent

    data object Root : SortAndGroupViewModelEvent

    data object ExpandSort : SortAndGroupViewModelEvent
    data object UnExpandSort : SortAndGroupViewModelEvent

    data object ExpandGroup : SortAndGroupViewModelEvent
    data object UnExpandGroup : SortAndGroupViewModelEvent
    data class DestinationChange(val route: String) : SortAndGroupViewModelEvent
}