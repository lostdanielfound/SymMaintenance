package com.project.presentation.features

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.presentation.data.GenerateFakeData
import com.project.presentation.models.Task
import java.util.UUID

@Composable
fun DropDownList(
    expanded: Boolean,
    title: String,
    icon: ImageVector,
    dropDownDescription: String?,
    onPressedRequest: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    items: List<Task>,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(4.dp)
    ) {
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
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Unexpand drop down list"
                )
            } else {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Expand drop down list"
                )
            }
        }
        if (expanded) {
            LazyColumn(

            ) {
                items(items) { item ->
                    TaskItem(item)
                }
            }
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun PreviewDropDownList() {
    val expanded = false
    val title = "Current Tasks"
    val dropDownDescription = "Current Outstanding tasks"

    val exampleList = GenerateFakeData.generateFakeTaskList()

    DropDownList(
        expanded = expanded,
        title = title,
        icon = Icons.Filled.Build,
        dropDownDescription = dropDownDescription,
        onPressedRequest = {},
        onDismissRequest = {},
        items = exampleList
    ) { }
}