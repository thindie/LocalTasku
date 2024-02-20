package com.thindie.tasks_general.feature_navigation

import androidx.navigation.NavController


internal fun NavController.unsortedTasks() {
    forward(FeatureDestination.routeUnSortTasks)
}

internal fun NavController.areaSortedTasks() {
    forward(FeatureDestination.routeAreaSortedTasks)
}

internal fun NavController.prioritySortedTasks() {
    forward(FeatureDestination.routePrioritySortedTasks)
}

private fun NavController.forward(destination: String) {
    navigate(destination) {
        launchSingleTop = true
        restoreState = true
    }
}