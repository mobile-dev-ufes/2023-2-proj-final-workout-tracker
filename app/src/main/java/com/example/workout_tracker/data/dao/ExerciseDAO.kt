package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workout_tracker.data.model.ExerciseModel

@Dao
interface ExerciseDAO {

    @Insert
    fun insert(p: ExerciseModel): Long

    @Update
    fun update(p: ExerciseModel): Int

    @Delete
    fun delete(p: ExerciseModel)

    @Query("SELECT * FROM Exercise WHERE id = :id")
    fun getById(id: Int): ExerciseModel
}
