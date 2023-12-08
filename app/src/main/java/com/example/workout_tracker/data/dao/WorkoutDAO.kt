package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workout_tracker.data.model.Workout

@Dao
interface WorkoutDAO {

    @Insert
    fun insert(p: Workout): Long

    @Update
    fun update(p: Workout): Int

    @Delete
    fun delete(p: Workout)

    @Query("SELECT * FROM Workout WHERE id = :id")
    fun getById(id: Int): Workout

    @Query("DELETE FROM Workout")
    fun deleteAll(): Void
}
