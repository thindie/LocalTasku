package com.thindie.localtasku

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.tasks_general.tasksGeneral

@Composable
fun TaskuApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.Transparent,

        ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(
                modifier = modifier
                    .align(Alignment.TopCenter)
                    .padding(it),
                navController = navController,
                startDestination = TaskuDestinations.tasksGeneral
            ) {
                tasksGeneral { }
            }

        }

    }
}
