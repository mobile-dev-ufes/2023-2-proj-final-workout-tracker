package com.example.workout_tracker.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workout_tracker.data.model.ExerciseModel
import com.example.workout_tracker.data.dao.ExerciseDAO

@Database(entities = [ExerciseModel::class], version = 1)
abstract class AppDatabase(): RoomDatabase() {
    abstract fun ExerciseDAO(): ExerciseDAO
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

