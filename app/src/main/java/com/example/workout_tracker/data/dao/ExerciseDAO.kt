package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workout_tracker.data.model.Exercise

@Dao
interface ExerciseDAO {

    @Insert
    fun insert(p: Exercise): Long

    @Update
    fun update(p: Exercise): Int

    @Delete
    fun delete(p: Exercise)

    @Query("SELECT * FROM Exercise WHERE id = :id")
    fun getById(id: Int): Exercise

    @Query("DELETE FROM Exercise")
    fun deleteAll(): Void
}
