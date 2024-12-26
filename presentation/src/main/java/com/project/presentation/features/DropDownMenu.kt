package com.project.presentation.features

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.project.presentation.models.Task

@Composable
fun DropDownList(
    expanded: Boolean,
    title: String,
    icon: @Composable() () -> Unit,
    onPressedRequest: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    items: List<Task>,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Surface(
        shape = RoundedCornerShape(1.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            icon()
            Text(text = title)

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

}