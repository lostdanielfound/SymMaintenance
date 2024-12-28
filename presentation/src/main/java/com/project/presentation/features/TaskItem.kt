package com.project.presentation.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.presentation.data.GenerateFakeData
import com.project.presentation.models.Task

/**
 * TaskItem
 * This item is meant to show the user a minimal view of a maintenance task which shows 6 parts
 * Module, Level, MVC, Avenue and aisle
 * @param Task A task object
 *
 */
@Composable
fun TaskItem(task: Task) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(IntrinsicSize.Min)
    ) {
        Row(

        ) {
            Text("M " + task.module.toString())
            VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            Text("Lv. " + task.level.toString())
            VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            Text("Ave. " + task.avenue.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    val fakeTask = GenerateFakeData.generateFakeTaskList()[0]
    TaskItem(fakeTask)
}