package com.example.workout_tracker.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

/**
 * Classe que representa a relação 1 para N de rotina com exercícios
 * */
data class RoutineWithWorkouts (
    @Embedded
    val routine: Routine,
    @Relation (
        parentColumn = "id",
        entityColumn = "routineId"
    )
    val workouts: List<Workout>
)