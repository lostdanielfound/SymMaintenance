package com.project.framework

import java.time.LocalDateTime
import java.util.UUID

/**
 * ModelView of a Task
 * If faterError is null, it's assumed that this task is a deck / aisle repair
 */
data class Task(
    val taskId: UUID,
    val botId: Int?,
    val createdAt: LocalDateTime?,
    val finishedAt: LocalDateTime?,
    val module: Int?,
    val level: Int?,
    val mvc: Int?,
    val mvcSide: Int?,
    val avenue: Int?,
    val aisle: Int?,
    val fatalError: FatalError?,
    val controllerComment: String?,
    val maintenanceComment: String?,
    val initial1: String?,
    val initial2: String?,
    val isCompleted: Boolean
)