package com.example.workout_tracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.room.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testBD()
    }

    private fun testBD() {
        val dbe = AppDatabase.getDatabase(this).ExerciseDAO()
        val dbr = AppDatabase.getDatabase(this).RoutineDAO()
        val dbw = AppDatabase.getDatabase(this).WorkoutDAO()
        dbe.deleteAll()
        dbr.deleteAll()
        dbw.deleteAll()
//        val exer = Exercise().apply{
//            this.name = "Bench Press"
//        }
//        dbe.insert(exer)
//        val exer2 = Exercise().apply{
//            this.name = "Shoulder Press"
//        }
//        dbe.insert(exer2)
        val rout = Routine().apply{
            this.name = "MyRoutine"
        }
        val rout2 = Routine().apply{
            this.name = "MyRoutine2"
        }
        dbr.insert(rout)
        val work = Workout().apply{
            this.name = "MyWorkout"
            this.routineId = rout.id
        }
        val work2 = Workout().apply{
            this.name = "MyWorkout2"
            this.routineId = rout2.id
        }
        dbw.insert(work)
        // Daqui pra baixo não funciona
        val dbrw = AppDatabase.getDatabase(this).RoutineWithWorkoutsDAO()
        val lr = dbrw.getStuff()
        for (r in lr) {
            println(r)
        }
    }
}