package com.project.presentation.models

import com.project.presentation.domain.FatalError
import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID,
    val createdAt: LocalDateTime?,
    val finishedAt: LocalDateTime?,
    val module: Int?,
    val level: Int?,
    val mvc: Int?,
    val avenue: Int?,
    val aisle: Int?,
    val fatalError: FatalError?,
    val controllerComment: String?,
    val maintenanceComment: String?,
    val initial1: String?,
    val initial2: String?,
    val isCompleted: Boolean
)