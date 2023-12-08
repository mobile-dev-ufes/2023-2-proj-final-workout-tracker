package com.example.workout_tracker.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.dao.ExerciseDAO
import com.example.workout_tracker.data.dao.RoutineDAO
import com.example.workout_tracker.data.dao.RoutineWithWorkoutsDAO
import com.example.workout_tracker.data.dao.WorkoutDAO
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.RoutineWithWorkouts
import com.example.workout_tracker.data.model.Workout

@Database(entities = [Exercise::class, Routine::class, Workout::class/*, RoutineWithWorkouts::class*/], version = 1)
abstract class AppDatabase(): RoomDatabase() {
    abstract fun ExerciseDAO(): ExerciseDAO
    abstract fun RoutineDAO(): RoutineDAO
    abstract fun WorkoutDAO(): WorkoutDAO
    abstract fun RoutineWithWorkoutsDAO(): RoutineWithWorkoutsDAO
    companion object {
        private lateinit var INSTANCE: AppDatabase
        fun getDatabase(context: Context): AppDatabase {

            if(!::INSTANCE.isInitialized) {

                synchronized(AppDatabase::class) {

                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "mydatabase.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

