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
    fun getById(id: Long): Workout

    @Query("SELECT * FROM Workout")
    fun getAll(): List<Workout>

    @Query("DELETE FROM Workout")
    fun deleteAll(): Int

    /**
     * Essa query busca todas as rotinas
     * */
    @Transaction
    @Query("SELECT * FROM Routine")
    fun getRoutineWithWorkouts(): List<RoutineWithWorkouts>

    /**
     * Essa query busca todos as rotinas com exercícios a partir do id da rotina
     * */
    @Transaction
    @Query("SELECT * FROM Routine WHERE id = :routineId")
    fun getRoutineWithWorkoutsById(routineId: Long): RoutineWithWorkouts

//    @Query("SELECT * FROM Workout WHERE id = :id")
//    suspend fun getWorkouteWithExercises(id: Int): List<WorkoutWithExercises>
}
