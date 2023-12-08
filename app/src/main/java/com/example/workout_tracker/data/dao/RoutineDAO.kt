package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.workout_tracker.data.model.Routine

@Dao
interface RoutineDAO {

    @Insert
    fun insert(p: Routine): Long

    @Update
    fun update(p: Routine): Int

    @Delete
    fun delete(p: Routine)

    @Query("SELECT * FROM Routine WHERE id = :id")
    fun getById(id: Int): Routine

    @Query("DELETE FROM Routine")
    fun deleteAll(): Void
}
