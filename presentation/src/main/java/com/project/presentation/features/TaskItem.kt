package com.project.presentation.features

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = Modifier
            .fillMaxWidth()
    ) {

    }
}