package com.example.workout_tracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Classe que representa um registro
 * */
@Entity(tableName = "Register")
data class Register(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "sets")
    var sets: Int = 0,

    @ColumnInfo(name = "reps")
    var reps: Int = 0,

    @ColumnInfo(name = "exerciseName")
    var exerciseName: String = ""
)