package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.RoutineWithWorkouts
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
    fun getById(id: Int): Workout

    @Query("DELETE FROM Workout")
    fun deleteAll(): Int

//    @Query("SELECT * FROM Workout WHERE id = :id")
//    suspend fun getWorkouteWithExercises(id: Int): List<WorkoutWithExercises>
}
