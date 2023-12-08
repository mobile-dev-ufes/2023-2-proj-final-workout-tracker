package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.RoutineWithWorkouts

@Dao
interface RoutineWithWorkoutsDAO {
    @Transaction
    @Query("SELECT * FROM Routine")
    fun getStuff(): List<RoutineWithWorkouts>
}
