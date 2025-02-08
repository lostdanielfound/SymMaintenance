package com.project.view_tasks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.framework.GenerateFakeData
import com.project.framework.Task

/**
 * TaskItem
 * This item is meant to show the user a minimal view of a maintenance task which shows 6 parts
 * Module, Level, MVC, Avenue and aisle
 * @param task A Task object
 *
 */
@Composable
fun TaskItem(
    task: Task,
    onCompletePress: (task: Task) -> Unit,
    onUnCompletePress: (task: Task) -> Unit,
    onDetailsPress:  (task: Task) -> Unit
) {
    val surfaceColor = if (task.isCompleted) Color(0xff70bf6d) else Color.Transparent

    Surface(
        shape = ShapeDefaults.Small,
        border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.secondary),
        color = surfaceColor
    ) {
        Row(
            //horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(IntrinsicSize.Min)
        ) {
            if (task.botId == null) {
                Text("Location")
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            } else {
                Text("Bot " + task.botId.toString())
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }

            if (task.module != null) {
                Text("M " + task.module.toString())
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }
            if (task.level != null) {
                Text("Lv. " + task.level.toString())
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }
            if (task.mvc != null) {
                var str = task.mvc.toString()
                if (task.mvcSide != null) { str = str + "-" + task.mvcSide.toString()}
                Text("MVC $str")
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }
            if (task.avenue != null) {
                Text("Ave. " + task.avenue.toString())
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }
            if (task.aisle != null) {
                Text("Aisle " + task.aisle.toString())
                VerticalDivider(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(horizontal = 4.dp))
            }
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                // TODO: Putting a switch would be a better indicater for the user.
                if (!task.isCompleted) {
                    IconButton( onClick = { onCompletePress(task) }, modifier = Modifier.size(18.dp)) { Icon(imageVector = Icons.Filled.Done, contentDescription = "Complete Task", modifier = Modifier.size(18.dp)) }
                } else {
                    IconButton( onClick = { onUnCompletePress(task) }, modifier = Modifier.size(18.dp)) { Icon(imageVector = Icons.Filled.Close, contentDescription = "Uncomplete task", modifier = Modifier.size(18.dp)) }
                }
                IconButton( onClick = { onDetailsPress(task) }, modifier = Modifier.size(18.dp)) { Icon(imageVector = Icons.Filled.Info, contentDescription = "See details", modifier = Modifier.size(18.dp)) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    val fakeTask = GenerateFakeData.generateFakeTaskList()[4]
    TaskItem(fakeTask, {}, {}, {})
}