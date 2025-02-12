package com.project.view_task

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.framework.Task
import com.project.framework.GenerateFakeData

/**
 * TaskScreen
 *
 * @param task selected taskId from the homeScreen, in case if a null value is given,
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
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                if (task.botId != null) {
                    OutlinedCard(
                        border = BorderStroke(2.dp, Color.Black),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                        ) {
                            Text(
                                text = "Bot",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Bot ${task.botId}",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "ECODE: ${task.fatalError}",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }

                OutlinedCard(
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Location",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            task.module?.let { 
                                Text(
                                    text = "M ${task.module}",
                                    fontWeight = FontWeight.Light,
                                    fontSize = 20.sp,
                                )
                            }
                            task.level?.let {
                                Text(
                                    text = "Lv. ${task.level}",
                                    fontWeight = FontWeight.Light,
                                    fontSize = 20.sp,
                                )
                            }
                            task.aisle?.let {
                                Text(
                                    text = "A ${task.aisle}",
                                    fontWeight = FontWeight.Light,
                                    fontSize = 20.sp,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            task.avenue?.let {
                                Text(
                                    text = "Avenue ${task.avenue}",
                                    fontSize = 16.sp
                                )
                            }
                            task.mvc?.let {
                                Text(
                                    text = "MVC ${task.mvc} ${if (task.mvcSide != null) "-" + task.mvcSide else ""}",
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }
                }

                OutlinedCard(
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Comments",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        task.maintenanceComment?.let { Text("Maintenance Comment: $it") }
                        Spacer(modifier = Modifier.height(8.dp))
                        task.controllerComment?.let { Text("Controller Comment: $it") }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskScreenPreview() {
    val fakeTask = GenerateFakeData.generateFakeTaskList()[3]
    TaskScreen(
        fakeTask,
        onClickBack = {}
    )
}