package com.example.workout_tracker.data.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Classe que representa a relação 1 para N de treino com exercícios
 * */
data class WorkoutWithExercises(
    @Embedded
    val workout: Workout,
    @Relation(
        parentColumn = "id",
        entityColumn = "workoutId"
    )
    val exercises: List<Exercise>
)