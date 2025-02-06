package com.project.view_tasks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.framework.GenerateFakeData
import com.project.framework.Task

@Composable
fun DropDownList(
    title: String,
    icon: ImageVector,
    dropDownDescription: String?,
    onPressedRequest: () -> Unit, // When the DropDownList is pressed to expand
    onDetailsPress: (String) -> Unit, // When a TaskItem is clicked
    onCompletePress: (String) -> Unit,
    onUnCompletePress: (String) -> Unit,
    modifier: Modifier = Modifier,
    items: List<Task>,
) {
    var expanded by remember { mutableStateOf(false) }
    Surface(
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(4.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(icon, contentDescription = dropDownDescription)
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(text = title)
                Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                if (expanded) {
                    IconButton(
                        onClick = { expanded = false },
                        modifier = Modifier
                            .size(48.dp)
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowDown,
                            contentDescription = "Unexpand drop down list",
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                } else {
                    IconButton(
                        onClick = {
                            expanded = true
                            onPressedRequest() },
                        modifier = Modifier
                            .size(48.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Expand drop down list",
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                }
            }
            if (expanded) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    items(items) { item ->
                        TaskItem(
                            item,
                            { taskId -> onCompletePress(taskId) },
                            { taskId -> onUnCompletePress(taskId) },
                            { taskId -> onDetailsPress(taskId) }
                        )
                    }
                }
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewDropDownList() {
    val title = "Current Tasks"
    val dropDownDescription = "Current Outstanding tasks"
    val exampleList = GenerateFakeData.generateFakeTaskList()

    DropDownList(
        title = title,
        icon = Icons.Filled.Build,
        dropDownDescription = dropDownDescription,
        onPressedRequest = {},
        {},
        {},
        {},
        items = exampleList,
    )
}