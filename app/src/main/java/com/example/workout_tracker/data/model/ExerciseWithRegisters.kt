package com.example.workout_tracker.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class ExerciseWithRegisters (
    @Embedded
    val exercise: Exercise,
    @Relation (
        parentColumn = "id",
        entityColumn = "exerciseId"
    )
    val registers: List<Register>
)