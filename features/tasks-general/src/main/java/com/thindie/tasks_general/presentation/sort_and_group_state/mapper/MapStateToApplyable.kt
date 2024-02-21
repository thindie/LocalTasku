package com.thindie.tasks_general.presentation.sort_and_group_state.mapper

import com.thindie.design_system.elements.TaskuSortAndGroup
import com.thindie.tasks_general.presentation.sort_and_group_state.SortAndGroupViewModelState

fun SortAndGroupViewModelState.getSortApplyable(): TaskuSortAndGroup.Applyable {
    return object : TaskuSortAndGroup.Applyable {
        override fun getLabel() = sortLabelState

        override fun getDrawable() = sortDrawable

        override fun getRootElementColor() = rootSortElementColor

        override fun getRootBackgroundColor() = rootSortBackgroundColor

        override fun getDropdownBackgroundColor() = dropdownSortBackgroundColor

        override fun isExpanded() = isSortExpanded

    }
}

fun SortAndGroupViewModelState.getGroupApplyable(): TaskuSortAndGroup.Applyable {
    return object : TaskuSortAndGroup.Applyable {
        override fun getLabel() = groupLabelState

        override fun getDrawable() = groupDrawable

        override fun getRootElementColor() = rootGroupElementColor

        override fun getRootBackgroundColor() = rootGroupBackgroundColor

        override fun getDropdownBackgroundColor() = dropdownGroupBackgroundColor

        override fun isExpanded() = isGroupExpanded

    }
}