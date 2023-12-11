package com.example.workout_tracker.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

/**
 * Classe que representa uma rotina
 * */
@Entity(tableName = "Routine")
data class Routine(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "name")
    var name: String? = ""
)
