package com.example.workout_tracker.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

/**
 * Classe que representa a relação 1 para N de exercício com registros
 * */
data class ExerciseWithRegisters (
    @Embedded
    val exercise: Exercise,
    @Relation (
        parentColumn = "name",
        entityColumn = "exerciseName"
    )
    val registers: List<Register>
)