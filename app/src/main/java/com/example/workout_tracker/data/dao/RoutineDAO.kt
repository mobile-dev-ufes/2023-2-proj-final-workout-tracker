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
interface RoutineDAO {
    @Insert
    fun insert(routine: Routine): Long

    @Update
    fun update(routine: Routine): Int

    @Delete
    fun delete(routine: Routine)

    @Query("SELECT * FROM Routine WHERE id = :id")
    fun getById(id: Int): Routine

    @Query("DELETE FROM Routine")
    fun deleteAll(): Int

//    @Query("SELECT * FROM Routine WHERE id = :id")
//    suspend fun getRoutineWithWorkouts(id: Int): List<RoutineWithWorkouts>
}
