package com.project.view_task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.project.framework.Task

/**
 * TaskScreen
 *
 * @param The selected taskId from the homeScreen, in case if a null value is given,
 * screen will show an erroneous page explaining to user.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    task: Task,
    onClickBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task Details") },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() } ) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "Back to Home Screen")
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Column(
            ) {
                if (task.botId != null) {
                    Text("Bot ${task.botId}")
                    Text("ECODE: ${task.fatalError}")
                }

                Text(
                    text = "Location",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                HorizontalDivider()
                task.module?.let { Text("Mod ${task.module}") }
                task.level?.let { Text("Level ${task.level}") }
                task.avenue?.let { Text("Avenue ${task.avenue}") }
                task.aisle?.let { Text("Aisle ${task.aisle}") }
                task.mvc?.let { Text("MVC ${task.mvc} side ${task.mvcSide}") }

            }
        }
    }
}