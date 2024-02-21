package com.thindie.localtasku

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thindie.common.navigation_destinations.TaskuDestinations
import com.thindie.design_system.TaskuTitles
import com.thindie.design_system.elements.TaskuTopAppBar
import com.thindie.design_system.string
import com.thindie.tasks_general.tasksScreenRoute

@Composable
fun TaskuApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(containerColor = MaterialTheme.colorScheme.background, topBar = {
        TaskuTopAppBar(labelText = TaskuTitles.Calendar.today.string(),
            onClickBack = { },
            onOptionsEvent = { })
    }) {
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
                startDestination = TaskuDestinations.tasksRoute
            ) {
                tasksScreenRoute()
            }

        }
    }
}
