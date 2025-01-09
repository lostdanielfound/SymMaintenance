package com.project.presentation.features.HomeScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.presentation.data.GenerateFakeData
import com.project.presentation.features.DropDownList
import com.project.symmaintenance.ui.routes.Routes

/**
 * HomeScreen
 *
 * @param onTaskRequest Callback function that's passed to TaskItems.
 * TODO: (Possible have the ViewModel implement this function instead)
 * FOR TESTING: all TaskItems when clicked on will navigate to task screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onTaskRequest: (String) -> Unit,
    onClickRequestTesting: (String) -> Unit
) {
    /* During recomposition, the homescreen is suppose to fill in the list of tasks respectively after
    * pulling the list of all tasks from server.
    *
    * current_Tasks
    * all_tasks
    * completed_tasks
    *
    * These lists are used to populate the 4 DropDownList
    * */
    val allTasks = GenerateFakeData.generateFakeTaskList()
    val currentTasks = allTasks
        .filter { task -> !task.isCompleted }
        .sortedBy { task -> task.createdAt }
    val completeTasks = allTasks
        .filter { task -> task.isCompleted }
        .sortedBy { task -> task.finishedAt }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Home Screen") }
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            DropDownList(
                title = "All Shift Tasks",
                icon = Icons.Filled.Build,
                dropDownDescription = "All Shift Tasks",
                onPressedRequest = {},
                {},
                {},
                {},
                items = allTasks
            )
            DropDownList(
                title = "Current Shift Tasks",
                icon = Icons.Filled.Build,
                dropDownDescription = "Current Shift Tasks",
                onPressedRequest = {},
                {},
                {},
                {},
                items = currentTasks
            )
            DropDownList(
                title = "Completed Shift Tasks",
                icon = Icons.Filled.Build,
                dropDownDescription = "Completed Shift Tasks",
                onPressedRequest = {},
                {},
                {},
                {},
                items = completeTasks
            )
            // TODO: Will need to make a filter DropDownList later on

            // TODO: Navigation Testing
            TextButton(
                onClick = { onClickRequestTesting(Routes.Init) }
            ) { Text("Navigate to InitScreen")}

        }
    }
}