package com.example.workout_tracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout_tracker.data.model.ExerciseWithRegisters
import com.example.workout_tracker.data.model.Register

@Dao
interface RegisterDAO {
    @Insert
    fun insert(register: Register): Long

    @Update
    fun update(register: Register): Int

    @Delete
    fun delete(register: Register)

    @Query("SELECT * FROM Register WHERE id = :id")
    fun getById(id: Long): Register

    @Query("SELECT * FROM Register")
    fun getAll(): List<Register>

    @Query("DELETE FROM Register")
    fun deleteAll(): Int

    @Transaction
    @Query("SELECT * FROM Exercise")
    fun getExercisesWithRegisters(): List<ExerciseWithRegisters>

    @Transaction
    @Query("SELECT * FROM Exercise WHERE id = :exerciseId")
    fun getExercisesWithRegistersById(exerciseId: Long): List<ExerciseWithRegisters>
}
