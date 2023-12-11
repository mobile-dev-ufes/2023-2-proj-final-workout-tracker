package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.WorkoutWithExercises

@Dao
interface ExerciseDAO {
    @Insert
    fun insert(exercise: Exercise): Long

    @Update
    fun update(exercise: Exercise): Int

    @Delete
    fun delete(exercise: Exercise)

    @Query("SELECT * FROM Exercise WHERE id = :id")
    fun getById(id: Long): Exercise

    @Query("DELETE FROM Exercise")
    fun deleteAll(): Int


    @Transaction
    @Query("SELECT * FROM Workout")
    fun getWorkoutWithExercises(): List<WorkoutWithExercises>

    @Transaction
    @Query("SELECT * FROM Workout WHERE id = :workoutId")
    fun getWorkoutWithExercisesById(workoutId: Long): WorkoutWithExercises
}
