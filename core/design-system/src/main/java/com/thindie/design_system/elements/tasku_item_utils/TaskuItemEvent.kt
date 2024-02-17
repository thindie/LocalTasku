package com.thindie.design_system.elements.tasku_item_utils

sealed class TaskuItemEvent {

    data object OnCollapseAll: TaskuItemEvent()
    data class OnClick(val index: Int): TaskuItemEvent()
    data class OnClickPicture(val index: Int): TaskuItemEvent()
    data class OnChangeTitle(val title: String, val index: Int): TaskuItemEvent()

    data class OnChangeDescription(val description: String, val index: Int): TaskuItemEvent()

}