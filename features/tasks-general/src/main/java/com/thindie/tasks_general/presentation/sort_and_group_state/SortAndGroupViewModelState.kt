package com.thindie.tasks_general.presentation.sort_and_group_state

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.thindie.common.coreartifacts.ViewState
import com.thindie.design_system.TaskuIcons
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.theme.TaskuColors

data class SortAndGroupViewModelState(
    @StringRes val sortLabelState: Int,
    @StringRes val groupLabelState: Int,
    @DrawableRes val sortDrawable: Int,
    @DrawableRes val groupDrawable: Int,
    val rootSortElementColor: Color,
    val rootGroupElementColor: Color,
    val isSortExpanded: Boolean,
    val isGroupExpanded: Boolean,
    val rootSortBackgroundColor: Color,
    val dropdownSortBackgroundColor: Color,
    val rootGroupBackgroundColor: Color,
    val dropdownGroupBackgroundColor: Color,
    override val isLoading: Boolean,
    override val isError: Boolean,
) : ViewState {
    override fun onError() = this.copy(isError = true)

    override fun onLoading() = this.copy(isLoading = true)

    override fun onSuccess() = this.copy(isLoading = false, isError = false)

    companion object {

        fun getDefault(): SortAndGroupViewModelState {
            return SortAndGroupViewModelState(
                sortLabelState = TaskuTitles.sortBy,
                groupLabelState = TaskuTitles.groupBy,
                sortDrawable = TaskuIcons.SortGroup.expand,
                groupDrawable = TaskuIcons.SortGroup.expand,
                rootSortElementColor = TaskuColors.SortAndGroup.passive,
                rootGroupElementColor = TaskuColors.SortAndGroup.passive,
                isLoading = false,
                isError = false,
                isGroupExpanded = false,
                isSortExpanded = false,
                rootSortBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                dropdownSortBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundPassive,
                rootGroupBackgroundColor = TaskuColors.SortAndGroup.rootBackgroundPassive,
                dropdownGroupBackgroundColor = TaskuColors.SortAndGroup.dropdownBackgroundPassive,

                )
        }
    }
}