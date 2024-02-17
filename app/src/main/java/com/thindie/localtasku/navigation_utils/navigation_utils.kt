package com.thindie.localtasku.navigation_utils


import androidx.navigation.NavController
import com.thindie.common.navigation_destinations.TaskuDestinations


private fun NavController.forward(destination: String) {
    navigate(destination) {
        launchSingleTop = true
        restoreState = true
    }
}

private fun NavController.main() {
    forward(TaskuDestinations.main)
}

private fun NavController.tasksGeneral() {
    forward(TaskuDestinations.tasksGeneral)
}

private fun NavController.excursions() {
    forward(TaskuDestinations.excursions)
}

fun NavController.eventCalendar() {
    forward(TaskuDestinations.eventCalendar)
}

fun NavController.contacts() {
    forward(TaskuDestinations.contacts)
}

fun NavController.priceInfo() {
    forward(TaskuDestinations.priceInfo)
}

fun NavController.userTickets(){
    forward(TaskuDestinations.userTickets)
}


