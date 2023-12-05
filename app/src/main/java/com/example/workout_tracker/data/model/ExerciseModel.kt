package com.example.workout_tracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercise")
class ExerciseModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String? = ""

    @ColumnInfo(name = "reps")
    var reps: Int = 0

    @ColumnInfo(name = "sets")
    var sets: Int = 0
}