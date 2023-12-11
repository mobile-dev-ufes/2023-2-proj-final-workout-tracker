package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.model.WorkoutWithExercises

@Dao
interface WorkoutDAO {
    @Insert
    fun insert(workout: Workout): Long

    @Update
    fun update(workout: Workout): Int

    @Delete
    fun delete(workout: Workout)

    @Query("SELECT * FROM Workout WHERE id = :id")
    fun getById(id: Long): Workout

    @Query("DELETE FROM Workout")
    fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM Workout")
    fun getWorkoutWithExercises(): List<WorkoutWithExercises>

    @Transaction
    @Query("SELECT * FROM Workout WHERE id = :workoutId")
    fun getWorkoutWithExercisesById(workoutId: Long): WorkoutWithExercises
//    @Query("SELECT * FROM Workout WHERE id = :id")
//    suspend fun getWorkouteWithExercises(id: Int): List<WorkoutWithExercises>
}
