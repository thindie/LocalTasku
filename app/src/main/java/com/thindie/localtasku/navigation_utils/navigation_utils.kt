package com.thindie.localtasku.navigation_utils


import androidx.navigation.NavController


private fun NavController.forward(destination: String) {
    navigate(destination) {
        launchSingleTop = true
        restoreState = true
    }
}
