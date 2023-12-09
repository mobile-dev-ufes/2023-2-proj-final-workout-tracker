package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.workout_tracker.data.model.WorkoutWithExercises

@Dao
interface WorkoutWithExercisesDAO {
    @Transaction
    @Query("SELECT * FROM Workout")
    fun getWorkoutsWithExercises(): List<WorkoutWithExercises>
}