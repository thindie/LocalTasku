package com.thindie.localtasku.navigation_utils


import androidx.navigation.NavController
import com.thindie.common.navigation_destinations.TaskuDestinations


private fun NavController.forward(destination: String) {
    navigate(destination) {
        launchSingleTop = true
        restoreState = true
    }
}


fun NavController.unsortedTasks() {
    forward(TaskuDestinations.unsortedTasks)
}

fun NavController.areaSortedTasks() {
    forward(TaskuDestinations.sortedTasksArea)
}



