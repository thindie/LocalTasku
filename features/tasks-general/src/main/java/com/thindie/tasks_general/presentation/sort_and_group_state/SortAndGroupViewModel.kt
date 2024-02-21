package com.thindie.tasks_general.presentation.sort_and_group_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.theme.TaskuColors
import com.thindie.tasks_general.feature_navigation.FeatureDestination
import com.thindie.tasks_general.feature_navigation.alphabetSortedTasks
import com.thindie.tasks_general.feature_navigation.areaSortedTasks
import com.thindie.tasks_general.feature_navigation.dateSortedTasks
import com.thindie.tasks_general.feature_navigation.prioritySortedTasks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Stable
internal class SortAndGroupViewModel private constructor(private val navController: NavController) :
    ViewStateHolder<SortAndGroupViewModelState> {

    init {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            onEvent(SortAndGroupViewModelEvent.DestinationChange(destination.route.orEmpty()))
        }
    }

    private val _state = MutableStateFlow(SortAndGroupViewModelState.getDefault())

    fun onEvent(event: SortAndGroupViewModelEvent, shouldNavigate: Boolean = true) {

        when (event) {
            //ALPHABET SORT
            SortAndGroupViewModelEvent.OnClickAlphabet -> {
                onEvent(SortAndGroupViewModelEvent.Root)
                _state.update {
                    it.copy(
                        rootSortElementColor = TaskuColors.SortAndGroup.active,
                        sortLabelState = TaskuTitles.Sort.alphabet,
                        rootSortBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                        sortDrawable = TaskuIcons.SortGroup.cancel

                    )
                }
                if (shouldNavigate) navController.alphabetSortedTasks()
                onEvent(SortAndGroupViewModelEvent.UnExpandGroup)
            }

            //AREA GROUP
            SortAndGroupViewModelEvent.OnClickArea -> {
                onEvent(SortAndGroupViewModelEvent.Root)
                _state.update {
                    it.copy(
                        rootGroupElementColor = TaskuColors.SortAndGroup.active,
                        groupLabelState = TaskuTitles.Group.area,
                        rootGroupBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                        groupDrawable = TaskuIcons.SortGroup.cancel

                    )
                }
                if (shouldNavigate) navController.areaSortedTasks()
                onEvent(SortAndGroupViewModelEvent.UnExpandGroup)
            }
            //DATE SORT
            SortAndGroupViewModelEvent.OnClickDate -> {
                onEvent(SortAndGroupViewModelEvent.Root)
                _state.update {
                    it.copy(
                        rootSortElementColor = TaskuColors.SortAndGroup.active,
                        sortLabelState = TaskuTitles.Sort.date,
                        rootSortBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                        sortDrawable = TaskuIcons.SortGroup.cancel

                    )
                }
                if (shouldNavigate) navController.dateSortedTasks()
                onEvent(SortAndGroupViewModelEvent.UnExpandGroup)
            }

            //PRIORITY GROUP
            SortAndGroupViewModelEvent.OnClickPriority -> {
                onEvent(SortAndGroupViewModelEvent.Root)
                _state.update {
                    it.copy(
                        rootGroupElementColor = TaskuColors.SortAndGroup.active,
                        groupLabelState = TaskuTitles.Group.priority,
                        rootGroupBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                        groupDrawable = TaskuIcons.SortGroup.cancel
                    )
                }
                if (shouldNavigate) navController.prioritySortedTasks()
                onEvent(SortAndGroupViewModelEvent.UnExpandGroup)
            }

            // ON NAVCONTROLLER CALLBACK
            is SortAndGroupViewModelEvent.DestinationChange -> {
                when (event.route) {
                    FeatureDestination.routeUnSortTasks -> onEvent(
                        SortAndGroupViewModelEvent.Root,
                        shouldNavigate = false
                    )

                    FeatureDestination.routePrioritySortedTasks -> onEvent(
                        SortAndGroupViewModelEvent.OnClickPriority, shouldNavigate = false
                    )

                    FeatureDestination.routeAreaSortedTasks -> onEvent(
                        SortAndGroupViewModelEvent.OnClickArea, shouldNavigate = false
                    )

                    FeatureDestination.dateSortedTasks -> {
                        onEvent(SortAndGroupViewModelEvent.OnClickDate, shouldNavigate = false)
                    }

                    FeatureDestination.alphabetSortedTasks -> {
                        onEvent(SortAndGroupViewModelEvent.OnClickAlphabet, shouldNavigate = false)
                    }
                }
            }

            //DEFAULT STATE
            SortAndGroupViewModelEvent.Root -> _state.update {
                SortAndGroupViewModelState.getDefault()
            }

            //EXPAND SORT
            SortAndGroupViewModelEvent.ExpandSort -> _state.update {
                it.copy(
                    isSortExpanded = true,
                    dropdownSortBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundActive,
                    rootSortBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundActive
                )
            }
            // HIDE SORT
            SortAndGroupViewModelEvent.UnExpandSort -> _state.update {
                it.copy(
                    isSortExpanded = false,
                    rootSortBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                    dropdownSortBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundPassive
                )
            }
            // EXPAND GROUP
            SortAndGroupViewModelEvent.ExpandGroup -> _state.update {
                it.copy(
                    isGroupExpanded = true,
                    dropdownGroupBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundActive,
                    rootGroupBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundActive
                )
            }
            // HIDE GROUP
            SortAndGroupViewModelEvent.UnExpandGroup -> _state.update {
                it.copy(
                    isGroupExpanded = false,
                    rootGroupBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                    dropdownGroupBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundPassive
                )
            }
        }
    }

    override val state: StateFlow<SortAndGroupViewModelState> = _state.asStateFlow()

    override fun onError() {
        _state.update {
            it.onError()
        }
    }


    override fun onLoading() {
        _state.update {
            it.onLoading()
        }
    }

    companion object ComposeBuilder {
        @Composable
        fun rememberInstance(navController: NavController): SortAndGroupViewModel {
            return remember {
                SortAndGroupViewModel(navController)
            }
        }
    }
}