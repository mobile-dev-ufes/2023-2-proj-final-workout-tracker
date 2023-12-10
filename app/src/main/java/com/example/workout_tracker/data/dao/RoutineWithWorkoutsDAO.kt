package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.workout_tracker.data.model.RoutineWithWorkouts

@Dao
interface RoutineWithWorkoutsDAO {
    @Transaction
    @Query("SELECT * FROM Routine")
    fun getRoutineWithWorkouts(): List<RoutineWithWorkouts>

    @Transaction
    @Query("SELECT * FROM Routine WHERE id = :routineId")
    fun getRoutineWithWorkoutsById(routineId: Long): RoutineWithWorkouts

//    @Insert
//    fun insertRoutineWithWorkouts(routine: Routine, workouts: List<Workout>)
//
//    @Insert
//    fun insertRoutineWithWorkouts(routineWithWorkouts: RoutineWithWorkouts)

//    @Transaction
//    @Query("SELECT * FROM Routine")
//    fun getStuff(): List<RoutineWithWorkouts>
}
