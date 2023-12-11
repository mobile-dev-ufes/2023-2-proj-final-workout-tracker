package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.ExerciseWithRegisters
import com.example.workout_tracker.data.model.WorkoutWithExercises

@Dao
interface RegisterDAO {
    @Insert
    fun insert(exercise: Exercise): Long

    @Update
    fun update(exercise: Exercise): Int

    @Delete
    fun delete(exercise: Exercise)

    @Query("SELECT * FROM Exercise WHERE id = :id")
    fun getById(id: Long): Exercise

    @Query("SELECT * FROM Exercise")
    fun getAll(): List<Exercise>

    @Query("DELETE FROM Exercise")
    fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExercisesWithRegisters(): List<ExerciseWithRegisters>

    @Transaction
    @Query("SELECT * FROM Exercise WHERE id = :exerciseId")
    fun getExercisesWithRegistersById(exerciseId: Long): ExerciseWithRegisters
}
