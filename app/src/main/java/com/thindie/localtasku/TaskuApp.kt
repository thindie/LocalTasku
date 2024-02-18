package com.thindie.localtasku

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.localtasku.navigation_utils.areaSortedTasks
import com.thindie.localtasku.navigation_utils.unsortedTasks
import com.thindie.tasks_general.presentation.sorted_tasks_area.sortedTasksArea
import com.thindie.tasks_general.presentation.unsorted_tasks.unsortedTasks

@Composable
fun TaskuApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Row() {
                Button(onClick = navController::areaSortedTasks) {
                    Text(text = "1")
                }
                Button(onClick = navController::unsortedTasks) {
                    Text(text = "2")
                }
            }
        }
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
                startDestination = TaskuDestinations.sortedTasksArea
            ) {
                sortedTasksArea()
                unsortedTasks()
            }

        }

    }
}
